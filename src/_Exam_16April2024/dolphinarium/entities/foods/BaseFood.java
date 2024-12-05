package _Exam_16April2024.dolphinarium.entities.foods;

public abstract class BaseFood implements Food{
    private int calories;

    public BaseFood(int calories) {
        this.calories = calories;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

}
