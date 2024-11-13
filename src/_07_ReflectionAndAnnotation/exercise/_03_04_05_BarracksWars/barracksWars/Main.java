package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars;

import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces.Repository;
import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces.Runnable;
import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces.UnitFactory;
import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.Engine;
import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.factories.UnitFactoryImpl;
import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
