package _Exam_16April2024.dolphinarium.entities.pools;

import _Exam_16April2024.dolphinarium.entities.dolphins.Dolphin;
import _Exam_16April2024.dolphinarium.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static _Exam_16April2024.dolphinarium.common.ExceptionMessages.*;

public abstract class BasePool implements Pool{
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Dolphin> dolphins;

    public BasePool(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.dolphins = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(POOL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public Collection<Dolphin> getDolphins() {
        return this.dolphins;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public void addDolphin(Dolphin dolphin) {
        if (capacity <= this.dolphins.size()){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        if (dolphin.getEnergy() <= 0){
            throw new IllegalArgumentException(DOLPHIN_ENERGY_BELOW_OR_EQUAL_ZERO);
        }

        this.dolphins.add(dolphin);
    }

    @Override
    public void removeDolphin(Dolphin dolphin) {
        this.dolphins.remove(dolphin);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }
}
