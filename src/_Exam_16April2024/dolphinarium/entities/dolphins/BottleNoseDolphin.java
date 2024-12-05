package _Exam_16April2024.dolphinarium.entities.dolphins;

public class BottleNoseDolphin extends BaseDolphin{
    public BottleNoseDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        super.setEnergy(getEnergy() - 190);
        super.jump();
    }
}
