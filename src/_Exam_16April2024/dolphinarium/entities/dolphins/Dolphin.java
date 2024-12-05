package _Exam_16April2024.dolphinarium.entities.dolphins;

//TODO Implement all methods


import _Exam_16April2024.dolphinarium.entities.foods.Food;

public interface Dolphin {
    String getName();
    int getEnergy();

    void jump();

    void eat(Food food);
}
