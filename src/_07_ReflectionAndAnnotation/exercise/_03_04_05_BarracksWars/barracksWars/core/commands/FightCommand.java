package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.core.commands;

public class FightCommand extends Command{
    protected FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
