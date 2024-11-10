package _06_SOLID.exercise._01_CalorieCalculator;

import java.util.List;

public interface Calculator<T extends Product> {

    double sum(List<T> products);

    double average(List<T> products);
}
