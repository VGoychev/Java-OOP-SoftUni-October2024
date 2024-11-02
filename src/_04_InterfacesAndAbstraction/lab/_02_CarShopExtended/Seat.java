package _04_InterfacesAndAbstraction.lab._02_CarShopExtended;


public class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced,Double price) {
        super(model, color, horsePower, countryProduced);
        setPrice(price);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%s sells for %f%n", super.getModel(), this.price);
    }

    @Override
    public Double getPrice() {
        return price;
    }

    private void setPrice(Double price) {
        this.price = price;
    }
}
