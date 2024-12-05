package _Exam_10August2024.furnitureFactory.core;

import _Exam_10August2024.furnitureFactory.entities.factories.AdvancedFactory;
import _Exam_10August2024.furnitureFactory.entities.factories.Factory;
import _Exam_10August2024.furnitureFactory.entities.factories.OrdinaryFactory;
import _Exam_10August2024.furnitureFactory.entities.wood.OakWood;
import _Exam_10August2024.furnitureFactory.entities.wood.Wood;
import _Exam_10August2024.furnitureFactory.entities.workshops.DeckingWorkshop;
import _Exam_10August2024.furnitureFactory.entities.workshops.TableWorkshop;
import _Exam_10August2024.furnitureFactory.entities.workshops.Workshop;
import _Exam_10August2024.furnitureFactory.repositories.WoodRepository;
import _Exam_10August2024.furnitureFactory.repositories.WoodRepositoryImpl;
import _Exam_10August2024.furnitureFactory.repositories.WorkshopRepository;
import _Exam_10August2024.furnitureFactory.repositories.WorkshopRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static _Exam_10August2024.furnitureFactory.common.ConstantMessages.*;
import static _Exam_10August2024.furnitureFactory.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private WoodRepository  woodRepository;
    private WorkshopRepository workshopRepository;
    private Collection<Factory> factories;

    public ControllerImpl() {
        this.woodRepository = new WoodRepositoryImpl();
        this.workshopRepository = new WorkshopRepositoryImpl();
        this.factories = new ArrayList<>();
    }

    @Override
    public String buildFactory(String factoryType, String factoryName) {
        Factory factory;
        if (factoryType.equals("OrdinaryFactory")){
            factory = new OrdinaryFactory(factoryName);
        } else if (factoryType.equals("AdvancedFactory")){
            factory = new AdvancedFactory(factoryName);
        } else {
            throw new IllegalArgumentException(INVALID_FACTORY_TYPE);
        }
        for (Factory f : this.factories){
            if (f.getName().equals(factoryName)){
                throw new NullPointerException(FACTORY_EXISTS);
            }
        }
        this.factories.add(factory);

        return String.format(SUCCESSFULLY_BUILD_FACTORY_TYPE, factoryType, factoryName);
    }

    @Override
    public Factory getFactoryByName(String factoryName) {
        return this.factories.stream().filter(factory -> factory.getName().equals(factoryName))
                .findFirst().orElse(null);
    }

    @Override
    public String buildWorkshop(String workshopType, int woodCapacity) {
        Workshop workshop;
        if (workshopType.equals("TableWorkshop")){
            workshop = new TableWorkshop(woodCapacity);
        } else if (workshopType.equals("DeckingWorkshop")){
            workshop = new DeckingWorkshop(woodCapacity);
        } else {
            throw new IllegalArgumentException(INVALID_WORKSHOP_TYPE);
        }
        this.workshopRepository.add(workshop);

        return String.format(SUCCESSFULLY_BUILD_WORKSHOP_TYPE, workshopType);
    }

    @Override
    public String addWorkshopToFactory(String factoryName, String workshopType) {
        Factory factory = null;
        for (Factory f : this.factories){
            if (f.getName().equals(factoryName)){
                factory = f;
                break;
            }
        }
        Workshop workshop = this.workshopRepository.findByType(workshopType);
        if (workshop == null){
            throw new NullPointerException(String.format(NO_WORKSHOP_FOUND, workshopType));
        }
        for (Workshop w : factory.getWorkshops()){
            if (w.getClass().getSimpleName().equals(workshopType)){
                throw new IllegalArgumentException(WORKSHOP_EXISTS);
            }
        }
        if (factory.getClass().getSimpleName().equals("AdvancedFactory")){
            if (workshop.getClass().getSimpleName().equals("TableWorkshop")){
                return NON_SUPPORTED_WORKSHOP;
            }
        } else if (factory.getClass().getSimpleName().equals("OrdinaryFactory")){
            if (workshop.getClass().getSimpleName().equals("DeckingWorkshop")){
                return NON_SUPPORTED_WORKSHOP;
            }
        }
        factory.addWorkshop(workshop);
        return String.format(SUCCESSFULLY_ADDED_WORKSHOP_IN_FACTORY, workshopType, factoryName);
    }


    @Override
    public String buyWoodForFactory(String woodType) {
        Wood wood;
        if (woodType.equals("OakWood")){
            wood = new OakWood();
        } else {
            throw new IllegalArgumentException(INVALID_WOOD_TYPE);
        }
        this.woodRepository.add(wood);
        return String.format(SUCCESSFULLY_BOUGHT_WOOD_FOR_FACTORY, woodType);
    }

    @Override
    public String addWoodToWorkshop(String factoryName, String workshopType, String woodType) {
       Factory factory = this.factories.stream().filter(f -> f.getName().equals(factoryName))
               .findFirst().orElse(null);
       Workshop workshop = factory.getWorkshops().stream().filter(w -> w.getClass().getSimpleName().equals(workshopType))
               .findFirst().orElse(null);
       if (workshop == null){
           throw new NullPointerException(NO_WORKSHOP_ADDED);
       }
       Wood wood = this.woodRepository.findByType(woodType);
       if (wood == null){
           throw new NullPointerException(String.format(NO_WOOD_FOUND, woodType));
       }

       workshop.addWood(wood);
       this.woodRepository.remove(wood);

       return String.format(SUCCESSFULLY_ADDED_WOOD_IN_WORKSHOP, woodType, workshopType);
    }

    @Override
    public String produceFurniture(String factoryName) {
        Factory factory = getFactoryByName(factoryName);

        if (factory.getWorkshops().isEmpty()){
            throw new NullPointerException(String.format(THERE_ARE_NO_WORKSHOPS, factoryName));
        }

        Iterator<Workshop> iterator = factory.getWorkshops().iterator();
        while (iterator.hasNext()){
            Workshop workshop = iterator.next();
            if (workshop.getWoodQuantity() < workshop.getWoodQuantityReduceFactor() && workshop.getWoodQuantity() > 0){
                return String.format(INSUFFICIENT_WOOD);
            }

            workshop.produce();

            if (workshop.getWoodQuantity() <= 0){
                this.workshopRepository.remove(workshop);
                iterator.remove();
                factory.getRemovedWorkshops().add(workshop);
                return String.format(WORKSHOP_STOPPED_WORKING, workshop.getClass().getSimpleName());
            }
        }
        int producedCount = factory.getWorkshops().stream().mapToInt(Workshop::getProducedFurnitureCount).sum();
        if (producedCount == 0){
            return String.format(FACTORY_DO_NOT_PRODUCED, factoryName);
        }
        return String.format(SUCCESSFUL_PRODUCTION, producedCount, factoryName);
    }

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        for (Factory factory : this.factories){
            sb.append("Production by ").append(factory.getName()).append(" factpry:").append(System.lineSeparator());
            if (factory.getWorkshops().isEmpty()){
                sb.append("No workshops were added to produce furniture.").append(System.lineSeparator());
            } else {
                for (Workshop workshop : factory.getWorkshops()){
                    sb.append(workshop.getClass().getSimpleName()).append(": ").append(workshop.getProducedFurnitureCount()).append(" furniture produced")
                            .append(System.lineSeparator());
                }
            }
        }
        return sb.toString();
    }
}
