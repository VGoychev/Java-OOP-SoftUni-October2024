package _07_ReflectionAndAnnotation.lab._01_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflectionClass = Reflection.class;
        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());
        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class cl : interfaces){
            System.out.println(cl);
        }
        Object reflectionObject = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
    }
}
