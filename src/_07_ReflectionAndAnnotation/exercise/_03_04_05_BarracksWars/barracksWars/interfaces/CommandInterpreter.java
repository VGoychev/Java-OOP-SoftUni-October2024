package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
