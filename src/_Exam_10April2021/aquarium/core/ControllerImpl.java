package _Exam_10April2021.aquarium.core;


import _Exam_10April2021.aquarium.entities.aquariums.Aquarium;
import _Exam_10April2021.aquarium.entities.aquariums.FreshwaterAquarium;
import _Exam_10April2021.aquarium.entities.aquariums.SaltwaterAquarium;
import _Exam_10April2021.aquarium.entities.decorations.Decoration;
import _Exam_10April2021.aquarium.entities.decorations.Ornament;
import _Exam_10April2021.aquarium.entities.decorations.Plant;
import _Exam_10April2021.aquarium.entities.fish.Fish;
import _Exam_10April2021.aquarium.entities.fish.FreshwaterFish;
import _Exam_10April2021.aquarium.entities.fish.SaltwaterFish;
import _Exam_10April2021.aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static _Exam_10April2021.aquarium.common.ConstantMessages.*;
import static _Exam_10April2021.aquarium.common.ExceptionMessages.*;


public class ControllerImpl implements Controller{
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl(){
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }
    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")){
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")){
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Ornament")){
            decoration = new Ornament();
        } else if (type.equals("Plant")){
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null){
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        for (Aquarium aquarium : this.aquariums){
            if (aquarium.getName().equals(aquariumName)){
                aquarium.addDecoration(decoration);
                this.decorations.remove(decoration);
                break;
            }
        }
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        Aquarium aquarium = this.aquariums.stream().filter(aquarium1 -> aquarium1.getName().equals(aquariumName))
                .findFirst().orElse(null);
        if (fishType.equals("FreshwaterFish")){
            fish = new FreshwaterFish(fishName, fishSpecies, price);
            if (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")){
                return String.format(WATER_NOT_SUITABLE);
            }
        } else if (fishType.equals("SaltwaterFish")){
            fish = new SaltwaterFish(fishName, fishSpecies, price);
            if (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")){
                return String.format(WATER_NOT_SUITABLE);
            }
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        aquarium.addFish(fish);

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream()
                .filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);

        aquarium.feed();

        return String.format(FISH_FED,aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        double decorationValue = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double fishValue = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double aquariumValue = decorationValue + fishValue;

        return String.format(VALUE_AQUARIUM, aquariumName, aquariumValue);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : this.aquariums){
            sb.append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
