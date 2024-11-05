package _05_Polymorphism.lab._04_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public boolean canEat(Food food) {
        return true;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return super.getAnimalType() + "[" + super.getAnimalName() + ", " + getBreed() + ", " + decimalFormat.format(getAnimalWeight()) + ", " + getLivingRegion() + ", " + super.getFoodEaten() + "]";
    }
}
