package _05_Polymorphism.exercise._02_VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    private final static double ADDITIONAL_AC_CONSUMPTION = 1.4;
    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(Double distance) {
        super.setFuelConsumption(super.getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION);
        super.drive(distance);
    }

    public void driveEmpty (Double distance) {
        Double totalFuelNeeded = distance * getFuelConsumption();

        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        if (getFuelQuantity() >= totalFuelNeeded){
            setFuelQuantity(getFuelQuantity() - totalFuelNeeded);
            System.out.println(getClass().getSimpleName() +" travelled " + decimalFormat.format(distance) + " km");
        } else {
            System.out.println(getClass().getSimpleName() + " needs refueling");
        }
    }
}
