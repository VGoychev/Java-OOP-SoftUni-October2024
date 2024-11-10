package _06_SOLID.exercise._01_CalorieCalculator.products;

import _06_SOLID.exercise._01_CalorieCalculator.Drink;

public class Lemonade implements Drink {

    private static final double CALORIES_PER_100_GRAMS = 53.0;
    private static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    @Override
    public double amountOfCalories() {
        double grams = milliliters * DENSITY;
        return  (CALORIES_PER_100_GRAMS / 100) * grams;
    }

    @Override
    public double amountOfDrinks() {
        return this.milliliters / 1000;
    }
}