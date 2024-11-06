package _05_Polymorphism.exercise._04_Calculator;

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new ExtensionInputInterpreter(engine);
    }
}
