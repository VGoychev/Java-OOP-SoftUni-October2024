package _05_Polymorphism.lab._04_WildFarm;

public class Zebra extends Mammal{
    protected Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
