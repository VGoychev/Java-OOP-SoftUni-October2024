package _07_ReflectionAndAnnotation.exercise._03_04_05_BarracksWars.barracksWars.models.units;

public class Archer extends AbstractUnit {
    private static final int ARCHER_HEALTH = 25;
    private static final int ARCHER_DAMAGE = 7;

    public Archer() {
        super(ARCHER_HEALTH, ARCHER_DAMAGE);
    }
}
