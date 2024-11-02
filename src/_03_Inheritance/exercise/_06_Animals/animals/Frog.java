package _03_Inheritance.exercise._06_Animals.animals;

public class Frog extends Animal{
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "Ribbit";
    }
}
