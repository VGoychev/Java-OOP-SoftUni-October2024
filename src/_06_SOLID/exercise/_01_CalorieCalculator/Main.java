package _06_SOLID.exercise._01_CalorieCalculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        QuantityCalculatorFood quantityCalculatorFood = new QuantityCalculatorFood();

        Printer printer = new Printer(new QuantityCalculatorDrink());
        Printer printer1 = new Printer(quantityCalculatorFood);
        Printer printer2 = new Printer(new CalorieCalculator());

        quantityCalculatorFood.average(List.of(new Cloud()));
    }
}
