package _04_InterfacesAndAbstraction.lab._02_CarShopExtended;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        setMinRentDay(minRentDay);
        setPricePerDay(pricePerDay);
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    private void setMinRentDay(Integer minRentDay) {
        this.minRentDay = minRentDay;
    }

    private void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Minimum rental period of %d days. Price per day %f%n", this.minRentDay, this.pricePerDay);
    }
}
