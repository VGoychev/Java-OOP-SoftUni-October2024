package _04_InterfacesAndAbstraction.lab._03_SayHello;

public class European implements Person{
    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
