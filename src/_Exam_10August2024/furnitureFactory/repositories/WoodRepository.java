package _Exam_10August2024.furnitureFactory.repositories;

import _Exam_10August2024.furnitureFactory.entities.wood.Wood;

public interface WoodRepository {

    void add(Wood wood);

    boolean remove(Wood wood);

    Wood findByType(String type);
}
