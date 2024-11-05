package _05_Polymorphism.lab._03_Animal;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public abstract String explainSelf();

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }
}
