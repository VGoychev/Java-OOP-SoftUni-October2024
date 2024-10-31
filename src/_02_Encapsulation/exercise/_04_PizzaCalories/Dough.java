package _02_Encapsulation.exercise._04_PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")){
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories(){
        double flourModifier = 0;
        switch (getFlourType()){
            case "White":
                flourModifier = 1.5;
                break;
            case "Wholegrain":
                flourModifier = 1.0;
        }

        double bakingModifier = 0;
        switch (getBakingTechnique()){
            case "Crispy":
                bakingModifier = 0.9;
                break;
            case "Chewy":
                bakingModifier = 1.1;
                break;
            case "Homemade":
                bakingModifier = 1.0;
                break;
        }

        return (2 * getWeight()) * flourModifier * bakingModifier;
    }
}
