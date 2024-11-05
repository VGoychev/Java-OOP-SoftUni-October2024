package _05_Polymorphism.exercise._02_VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private Double tankCapacity;
    private Double fuelQuantity;
    private Double fuelConsumption;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public void drive(Double distance){
        Double totalFuelNeeded = distance * getFuelConsumption();

        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        if (getFuelQuantity() >= totalFuelNeeded){
            setFuelQuantity(getFuelQuantity() - totalFuelNeeded);
            System.out.println(getClass().getSimpleName() +" travelled " + decimalFormat.format(distance) + " km");
        } else {
            System.out.println(getClass().getSimpleName() + " needs refueling");
        }
    };
    public void refuel(Double liters){
        if(liters > 0) {
            if (liters <= this.tankCapacity - this.fuelQuantity) {
                this.fuelQuantity += liters;
            } else {
                System.out.println("Cannot fit fuel in tank");
            }
        } else {
            System.out.println("Fuel must be a positive number");
        }
    };

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        if (fuelQuantity >= 0) {
            this.fuelQuantity = fuelQuantity;
        } else {
            System.out.println("Fuel must be a positive number");
            this.fuelQuantity = 0.0;
        }
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.fuelQuantity);
    }
}
