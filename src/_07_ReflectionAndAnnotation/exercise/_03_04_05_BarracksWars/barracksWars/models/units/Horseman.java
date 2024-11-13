package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.models.units;

public class Horseman extends AbstractUnit{
    private static final int HEALTH  = 50;
    private static final int DAMAGE = 10;

    protected Horseman() {
        super(HEALTH, DAMAGE);
    }
}
