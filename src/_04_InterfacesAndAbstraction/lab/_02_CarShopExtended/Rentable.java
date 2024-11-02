package _04_InterfacesAndAbstraction.lab._02_CarShopExtended;

public interface Rentable extends Car{

    Integer getMinRentDay();

    Double getPricePerDay();
}
