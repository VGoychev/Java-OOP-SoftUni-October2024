package _03_Inheritance.exercise._05_Restaurant.restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{
    private static final double COFFEE_MILLILITERS = 50;
    private static final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        setCaffeine(caffeine);
    }

    public double getCaffeine() {
        return caffeine;
    }

    protected void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }


}
