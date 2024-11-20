package _Exam_09December_2023.harpoonDiver.models.diver;


import _Exam_09December_2023.harpoonDiver.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();

    double getOxygen();

    boolean canDive();

    SeaCatch getSeaCatch();

    void shoot();
}
