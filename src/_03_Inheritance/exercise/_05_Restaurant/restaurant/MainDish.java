package _03_Inheritance.exercise._05_Restaurant.restaurant;

import java.math.BigDecimal;

public class MainDish extends Food{
    public MainDish(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}