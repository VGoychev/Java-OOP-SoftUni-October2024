package _03_Inheritance.exercise._06_Animals.animals;

public class Dog extends Animal{
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "Woof!";
    }
}
