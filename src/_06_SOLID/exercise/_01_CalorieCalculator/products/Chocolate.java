package _06_SOLID.exercise._01_CalorieCalculator.products;

import _06_SOLID.exercise._01_CalorieCalculator.Food;

public class Chocolate implements Food {

    private static final double CALORIES_PER_100_GRAMS = 575.0;

    private double grams;

    public Chocolate(double grams) {
        this.grams = grams;
    }

    @Override
    public double amountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * grams;
    }

    @Override
    public double amountOfFood() {
        return this.grams / 1000;
    }
}
