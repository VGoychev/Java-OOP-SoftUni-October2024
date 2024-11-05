package _05_Polymorphism.exercise._01_Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    protected Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public void drive(Double distance) {
        Double totalFuelNeeded = distance * getFuelConsumption();
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        if (super.getFuelQuantity() >= totalFuelNeeded){
            super.setFuelQuantity(super.getFuelQuantity() - totalFuelNeeded);
            System.out.println("Truck travelled " + decimalFormat.format(distance) + " km");
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(Double liters) {
        Double fuelQuantity = super.getFuelQuantity() + (liters * 0.95);
        setFuelQuantity(fuelQuantity);
    }
}
