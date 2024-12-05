package _Exam_16April2024.dolphinarium.entities.dolphins;

import _Exam_16April2024.dolphinarium.entities.foods.Food;

import static _Exam_16April2024.dolphinarium.common.ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY;

public abstract class BaseDolphin implements Dolphin{
    private String name;
    private int energy;

    public BaseDolphin(String name, int energy) {
        setName(name);
        setEnergy(energy);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(DOLPHIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void jump() {
        this.energy -= 10;
        if (this.energy < 0) {
            setEnergy(0);
        }
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Squid")){
            this.energy += 175;
        } else if (food.getClass().getSimpleName().equals("Herring")){
            this.energy += 200;
        } else if (food.getClass().getSimpleName().equals("Mackerel")){
            this.energy += 305;
        }
    }
}
