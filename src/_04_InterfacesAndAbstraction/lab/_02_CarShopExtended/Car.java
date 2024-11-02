package _04_InterfacesAndAbstraction.lab._02_CarShopExtended;

public interface Car {
    int TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
