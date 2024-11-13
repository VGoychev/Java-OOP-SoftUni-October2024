package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.models.units;

public class Gunner extends AbstractUnit{
    private static final int HEALTH  = 20;
    private static final int DAMAGE = 20;

    protected Gunner() {
        super(HEALTH, DAMAGE);
    }
}
