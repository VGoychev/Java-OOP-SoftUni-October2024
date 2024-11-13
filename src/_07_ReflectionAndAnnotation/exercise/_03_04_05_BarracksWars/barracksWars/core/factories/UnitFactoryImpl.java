package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.factories;

import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces.Unit;
import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		String className = UNITS_PACKAGE_NAME + unitType;
		Class<Unit> unitClass = (Class<Unit>) Class.forName(className);
		Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		return constructor.newInstance();

	}
}
