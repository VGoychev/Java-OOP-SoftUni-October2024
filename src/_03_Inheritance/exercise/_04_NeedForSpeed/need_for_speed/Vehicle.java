package _03_Inheritance.exercise._04_NeedForSpeed.need_for_speed;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        setFuel(fuel);
        setHorsePower(horsePower);
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    private void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers){
        double consumedFuel =  kilometers * this.getFuelConsumption();
        if (consumedFuel <= this.getFuel()){
            double leftFuel = this.fuel - consumedFuel;
            this.setFuel(leftFuel);
        }
    }
}
