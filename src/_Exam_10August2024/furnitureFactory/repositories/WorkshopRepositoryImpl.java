package _Exam_10August2024.furnitureFactory.repositories;

import _Exam_10August2024.furnitureFactory.entities.workshops.Workshop;

import java.util.ArrayList;
import java.util.Collection;

import static _Exam_10August2024.furnitureFactory.common.ExceptionMessages.*;

public class WorkshopRepositoryImpl implements WorkshopRepository{
    private Collection<Workshop> workshops;

    public WorkshopRepositoryImpl(){
        this.workshops = new ArrayList<>();
    }

    @Override
    public void add(Workshop workshop) {
        Workshop workshop1 = this.workshops.stream().filter(w -> w.getClass().getSimpleName().equals(workshop.getClass().getSimpleName()))
                .findFirst().orElse(null);
        if (workshop1 != null){
            throw new IllegalArgumentException(WORKSHOP_EXISTS_IN_REPOSITORY);
        }
        if (workshop.getWoodQuantity() <= 0){
            throw new IllegalArgumentException(WORKSHOP_WOOD_QUANTITY_BELOW_OR_EQUAL_ZERO);
        }
        this.workshops.add(workshop);
    }

    @Override
    public boolean remove(Workshop workshop) {
        if (this.workshops.contains(workshop)){
            this.workshops.remove(workshop);
            return true;
        }
        return false;
    }

    @Override
    public Workshop findByType(String type) {
        return this.workshops.stream().filter(w -> w.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }
}
