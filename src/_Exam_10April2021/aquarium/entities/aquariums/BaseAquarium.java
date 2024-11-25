package _Exam_10April2021.aquarium.entities.aquariums;




import _Exam_10April2021.aquarium.entities.decorations.Decoration;
import _Exam_10April2021.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static _Exam_10April2021.aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static _Exam_10April2021.aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (this.name == null || this.name.trim().isEmpty()){
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void addFish(Fish fish) {
        if (capacity <= this.fish.size()){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);


    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(":").append(System.lineSeparator());
        sb.append("Fish: ");
        if (this.fish.isEmpty()){
            sb.append("none");
        } else {
            for (Fish fish : this.fish){
                sb.append(String.format("%s ", fish.getName()));
            }
        }
        sb.append(System.lineSeparator());
        sb.append("Decorations: ").append(this.decorations.size()).append(System.lineSeparator());
        sb.append("Comfort: ").append(calculateComfort()).append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return Collections.unmodifiableCollection(this.fish);
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return Collections.unmodifiableCollection(this.decorations);
    }
}
