package _Exam_10August2024.furnitureFactory.entities.workshops;

import _Exam_10August2024.furnitureFactory.entities.wood.Wood;

public interface Workshop {

    int getWoodQuantity();
    int getProducedFurnitureCount();
    int getWoodQuantityReduceFactor();
    void addWood(Wood wood);
    void produce();
}