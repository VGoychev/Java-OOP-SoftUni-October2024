package _02_Encapsulation.exercise._02_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.equals(" ") || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", getName(), getAge(), productPerDay());
    }

    private double calculateProductPerDay(){
        double productPerDay = 0;
        if (getAge() < 6){
            productPerDay = 2.00;
        } else if (getAge() < 12){
            productPerDay = 1.00;
        } else {
            productPerDay = 0.75;
        }
        return productPerDay;
    }
}
