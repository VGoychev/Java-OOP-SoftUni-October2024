package _Exam_16April2024.dolphinarium.entities.dolphins;

public class SpinnerDolphin extends BaseDolphin{
    public SpinnerDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        super.setEnergy(getEnergy() - 40);
        super.jump();
    }
}
