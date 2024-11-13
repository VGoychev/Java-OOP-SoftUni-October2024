package _07_ReflectionAndAnnotation.exercise._02_BlackBoxInteger.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        String command = scanner.nextLine();

        Field innerValueField = BlackBoxInt.class.getDeclaredField("innerValue");
        innerValueField.setAccessible(true);

        while (!command.equals("END")){
            String[] commandParts = command.split("_");
            setMethod(commandParts, blackBoxInt);
            System.out.println(innerValueField.getInt(blackBoxInt));
            command = scanner.nextLine();
        }
    }

    private static void setMethod(String[] commandParts, BlackBoxInt blackBoxInt) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method;
        switch (commandParts[0]) {
            case "add" -> {
                method = BlackBoxInt.class.getDeclaredMethod("add", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(commandParts[1]));
            }
            case "subtract" -> {
                method = BlackBoxInt.class.getDeclaredMethod("subtract", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(commandParts[1]));
            }
            case "multiply" -> {
                method = BlackBoxInt.class.getDeclaredMethod("multiply", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(commandParts[1]));
            }
            case "divide" -> {
                method = BlackBoxInt.class.getDeclaredMethod("divide", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(commandParts[1]));
            }
            case "leftShift" -> {
                method = BlackBoxInt.class.getDeclaredMethod("leftShift", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(commandParts[1]));
            }
            case "rightShift" -> {
                method = BlackBoxInt.class.getDeclaredMethod("rightShift", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(commandParts[1]));
            }
        }
    }
}
