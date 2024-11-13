package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.commands;

import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces.Executable;

public abstract class Command implements Executable {
    private String data[];

    protected Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }
}
