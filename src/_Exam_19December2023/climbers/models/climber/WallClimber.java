package _Exam_19December2023.climbers.models.climber;

public class WallClimber extends BaseClimber{
    private static final double STRENGTH = 90;
    public WallClimber(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void climb() {
        double currentStrength = getStrength() - 30;
        if (currentStrength >= 0){
            super.setStrength(currentStrength);
        } else {
            super.setStrength(0);
        }
    }
}
