package _06_SOLID.exercise._01_CalorieCalculator;

import java.util.List;

public class CalorieCalculator implements Calculator<Product> {

    public CalorieCalculator() {
    }

    @Override
    public double sum(List<Product> products) {
        return products.stream().mapToDouble(Product::amountOfCalories).sum();
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }

}
