package _Exam_10August2024.furnitureFactory.repositories;

import _Exam_10August2024.furnitureFactory.entities.workshops.Workshop;

public interface WorkshopRepository {

    void add(Workshop workshop);

    boolean remove(Workshop workshop);

    Workshop findByType(String type);
}
