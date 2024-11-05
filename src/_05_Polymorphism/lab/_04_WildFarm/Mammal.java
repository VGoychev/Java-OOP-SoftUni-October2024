package _05_Polymorphism.lab._04_WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;


    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public boolean canEat(Food food) {
        return food.getClass().getSimpleName().equals("Vegetable");
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return super.getAnimalType() + "[" + super.getAnimalName() + ", " + decimalFormat.format(getAnimalWeight()) + ", " + getLivingRegion() + ", " + super.getFoodEaten() + "]";
    }
}
