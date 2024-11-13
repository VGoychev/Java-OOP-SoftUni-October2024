package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.commands;

import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.Inject;
import _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.interfaces.Repository;

public class ReportCommand extends Command{
    @Inject
    private Repository repository;

    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String output = repository.getStatistics();
        return output;
    }
}
