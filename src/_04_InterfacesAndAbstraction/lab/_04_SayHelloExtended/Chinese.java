package _04_InterfacesAndAbstraction.lab._04_SayHelloExtended;

public class Chinese extends BasePerson{
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Djydjybydjy");
    }
}
