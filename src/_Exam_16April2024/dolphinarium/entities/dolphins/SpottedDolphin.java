package _Exam_16April2024.dolphinarium.entities.dolphins;

public class SpottedDolphin extends BaseDolphin{

    public SpottedDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        super.setEnergy(getEnergy() - 90);
        super.jump();
    }
}
