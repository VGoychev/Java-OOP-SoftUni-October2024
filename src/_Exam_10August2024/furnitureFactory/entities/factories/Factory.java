package _Exam_10August2024.furnitureFactory.entities.factories;

import _Exam_10August2024.furnitureFactory.entities.workshops.Workshop;

import java.util.Collection;

public interface Factory {

    String getName();

    void addWorkshop(Workshop workshop);

    Collection<Workshop> getWorkshops();

    Collection<Workshop> getRemovedWorkshops();
}
