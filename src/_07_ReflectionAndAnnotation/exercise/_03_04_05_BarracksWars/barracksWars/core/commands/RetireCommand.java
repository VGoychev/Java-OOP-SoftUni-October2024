package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.commands;

import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.Inject;
import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command{

    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException{
        String unitType = getData()[1];

        repository.removeUnit(unitType);
        return String.format("%s retired!", unitType);
    }
}
