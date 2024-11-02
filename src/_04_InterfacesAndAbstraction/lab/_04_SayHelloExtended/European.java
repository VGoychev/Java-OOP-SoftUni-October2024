package _04_InterfacesAndAbstraction.lab._04_SayHelloExtended;

public class European extends BasePerson{
    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Hello");
    }

}
