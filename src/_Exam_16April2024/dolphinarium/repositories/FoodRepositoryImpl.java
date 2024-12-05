package _Exam_16April2024.dolphinarium.repositories;

import _Exam_16April2024.dolphinarium.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository{
    private Collection<Food> foods;

    public FoodRepositoryImpl(){
        this.foods = new ArrayList<>();
    }
    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        if (this.foods.contains(food)){
            this.foods.remove(food);
            return true;
        }
        return false;
    }

    @Override
    public Food findByType(String type) {
        return this.foods.stream().filter(food -> food.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }
}
