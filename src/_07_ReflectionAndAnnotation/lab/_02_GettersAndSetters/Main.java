package _07_ReflectionAndAnnotation.lab._02_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class reflectionClass = Reflection.class;

        Method[] allMethods = reflectionClass.getDeclaredMethods();

        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter -> System.out.printf("%s will return class %s%n", getter.getName(), getter.getReturnType()));

        for (Method method : allMethods){
            if (method.getName().startsWith("set")){
                Class[] parameterTypes = method.getParameterTypes();

                System.out.printf("%s and will set field of class %s%n", method.getName(),parameterTypes[0]);
            }
        }
    }
}
