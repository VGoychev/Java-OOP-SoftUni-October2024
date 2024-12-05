package _Exam_16April2024.dolphinarium.core;

import _Exam_16April2024.dolphinarium.entities.dolphins.BottleNoseDolphin;
import _Exam_16April2024.dolphinarium.entities.dolphins.Dolphin;
import _Exam_16April2024.dolphinarium.entities.dolphins.SpinnerDolphin;
import _Exam_16April2024.dolphinarium.entities.dolphins.SpottedDolphin;
import _Exam_16April2024.dolphinarium.entities.foods.Food;
import _Exam_16April2024.dolphinarium.entities.foods.Herring;
import _Exam_16April2024.dolphinarium.entities.foods.Mackerel;
import _Exam_16April2024.dolphinarium.entities.foods.Squid;
import _Exam_16April2024.dolphinarium.entities.pools.DeepWaterPool;
import _Exam_16April2024.dolphinarium.entities.pools.Pool;
import _Exam_16April2024.dolphinarium.entities.pools.ShallowWaterPool;
import _Exam_16April2024.dolphinarium.repositories.FoodRepository;
import _Exam_16April2024.dolphinarium.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static _Exam_16April2024.dolphinarium.common.ConstantMessages.*;
import static _Exam_16April2024.dolphinarium.common.ExceptionMessages.*;

//TODO Implement all methods
public class ControllerImpl implements Controller{
    private FoodRepository foodRepository;
    private Collection<Pool> pools;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.pools = new ArrayList<>();
    }
    @Override
    public String addPool(String poolType, String poolName) {
        Pool pool;
        if (poolType.equals("DeepWaterPool")){
            pool = new DeepWaterPool(poolName);
        } else if (poolType.equals("ShallowWaterPool")) {
            pool = new ShallowWaterPool(poolName);
        } else {
            throw new NullPointerException(INVALID_POOL_TYPE);
        }
        for (Pool currentPool : this.pools){
            if (currentPool.getName().equals(poolName)){
                throw new NullPointerException(POOL_EXISTS);
            }
        }
        this.pools.add(pool);
        return String.format(SUCCESSFULLY_ADDED_POOL_TYPE, poolType, poolName);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Squid")){
            food = new Squid();
        } else if (foodType.equals("Herring")){
            food = new Herring();
        } else if (foodType.equals("Mackerel")){
            food = new Mackerel();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        this.foodRepository.add(food);
        return String.format(SUCCESSFULLY_BOUGHT_FOOD_TYPE, foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null){
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        Pool pool = this.pools.stream().filter(pool1 -> pool1.getName().equals(poolName)).findFirst()
                .orElse(null);

        pool.addFood(food);
        this.foodRepository.remove(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_POOL, foodType, poolName);
    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {
        Dolphin dolphin;
        Pool pool = this.pools.stream().filter(pool1 -> pool1.getName().equals(poolName)).findFirst()
                .orElse(null);

        if (dolphinType.equals("BottleNoseDolphin")){
            if (pool.getClass().getSimpleName().equals("ShallowWaterPool")){
                return String.format(POOL_NOT_SUITABLE);
            }
            dolphin = new BottleNoseDolphin(dolphinName, energy);

        } else if (dolphinType.equals("SpottedDolphin")){
            dolphin = new SpottedDolphin(dolphinName, energy);

        } else if (dolphinType.equals("SpinnerDolphin")) {
            if (pool.getClass().getSimpleName().equals("DeepWaterPool")){
                return String.format(POOL_NOT_SUITABLE);
            }
            dolphin = new SpinnerDolphin(dolphinName, energy);

        } else {
            throw new IllegalArgumentException(INVALID_DOLPHIN_TYPE);
        }

        for (Dolphin dolphin1 : pool.getDolphins()){
            if (dolphin1.getName().equals(dolphinName)){
                throw new IllegalArgumentException(DOLPHIN_EXISTS);
            }
        }
        pool.addDolphin(dolphin);
        return String.format(SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
    }

    @Override
    public String feedDolphins(String poolName, String food) {
        Pool pool = this.pools.stream().filter(pool1 -> pool1.getName().equals(poolName)).findFirst()
                .orElse(null);

        Food currFood = pool.getFoods().stream().filter(food1 -> food1.getClass().getSimpleName().equals(food))
                .findFirst().orElse(null);
        if (currFood == null){
            throw new IllegalArgumentException(NO_FOOD_OF_TYPE_ADDED_TO_POOL);
        }
        for (Dolphin dolphin : pool.getDolphins()) {
            dolphin.eat(currFood);
        }
        pool.getFoods().remove(currFood);
        return String.format(DOLPHINS_FED, pool.getDolphins().size(), poolName);
    }

    @Override
    public String playWithDolphins(String poolName) {
        int removed = 0;
        Pool pool = this.pools.stream().filter(pool1 -> pool1.getName().equals(poolName)).findFirst()
                .orElse(null);
        if (pool.getDolphins().isEmpty()){
            throw new IllegalArgumentException(NO_DOLPHINS);
        }

        Iterator<Dolphin> iterator = pool.getDolphins().iterator();
        while (iterator.hasNext()) {
            Dolphin dolphin = iterator.next();
            dolphin.jump();
            if (dolphin.getEnergy() == 0) {
                iterator.remove();
                removed++;
            }
        }

        return String.format(DOLPHINS_PLAY, poolName, removed);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Pool pool : this.pools){
            sb.append(String.format(DOLPHINS_FINAL, pool.getName())).append(System.lineSeparator());
            if (pool.getDolphins().isEmpty()){
                sb.append(NONE).append(System.lineSeparator());
            } else {
                for (Dolphin dolphin : pool.getDolphins()){
                    sb.append(String.join(DELIMITER, String.format("%s - %s", dolphin.getName(), dolphin.getEnergy()))).append(System.lineSeparator());
                }
            }
        }
        return sb.toString();
    }
}
