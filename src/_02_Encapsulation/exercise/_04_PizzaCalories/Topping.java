package _02_Encapsulation.exercise._04_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") ||
                toppingType.equals("Veggies") ||
                toppingType.equals("Cheese")||
                toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String
                    .format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(String
                    .format("%s weight should be in the range [1..50].", getToppingType()));
        }
    }

    public double calculateCalories(){
        double modifier = 0;
        switch (getToppingType()){
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
        }
        return (2 * getWeight()) * modifier;
    }
}
