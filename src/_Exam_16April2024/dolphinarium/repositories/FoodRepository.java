package _Exam_16April2024.dolphinarium.repositories;

import _Exam_16April2024.dolphinarium.entities.foods.Food;

//TODO Implement all methods
public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
