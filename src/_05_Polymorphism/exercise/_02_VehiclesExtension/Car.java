package _05_Polymorphism.exercise._02_VehiclesExtension;

public class Car extends Vehicle {
    private final static double ADDITIONAL_AC_CONSUMPTION = 0.9;
    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(super.getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION);
    }
}
