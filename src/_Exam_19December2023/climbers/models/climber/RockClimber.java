package _Exam_19December2023.climbers.models.climber;

public class RockClimber extends BaseClimber{
    private static final double STRENGTH = 120;
    public RockClimber(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void climb() {
        double currentStrength = getStrength() - 60;
        if (currentStrength >= 0){
            super.setStrength(currentStrength);
        } else {
            super.setStrength(0);
        }
    }
}
