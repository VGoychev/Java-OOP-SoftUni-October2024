package _02_Encapsulation.exercise._04_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (!name.trim().isEmpty() && name.length() <= 15){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    private void setToppings(int toppings) {
        if (toppings >= 0 && toppings <= 10){
            this.toppings = new ArrayList<>(toppings);
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void addTopping(Topping topping){
            this.toppings.add(topping);
    }

    public double getOverallCalories(){
        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }

}
