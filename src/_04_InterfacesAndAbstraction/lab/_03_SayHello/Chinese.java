package _04_InterfacesAndAbstraction.lab._03_SayHello;

public class Chinese implements Person{
    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
