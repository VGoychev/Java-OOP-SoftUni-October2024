package _05_Polymorphism.exercise._01_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle{
    protected Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }

    @Override
    public void drive(Double distance) {
        Double totalFuelNeeded = distance * getFuelConsumption();
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        if (super.getFuelQuantity() >= totalFuelNeeded){
            super.setFuelQuantity(super.getFuelQuantity() - totalFuelNeeded);
            System.out.println("Car travelled " + decimalFormat.format(distance) + " km");
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(Double liters) {
        Double fuelQuantity = super.getFuelQuantity() + liters;
        setFuelQuantity(fuelQuantity);
    }
}
