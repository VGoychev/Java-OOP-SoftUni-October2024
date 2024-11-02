package _04_InterfacesAndAbstraction.lab._04_SayHelloExtended;

public class Bulgarian extends BasePerson{
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Здравей");
    }
}
