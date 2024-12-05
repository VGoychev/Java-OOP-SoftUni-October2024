package _Exam_19December2023.climbers.models.climber;


import _Exam_19December2023.climbers.models.roster.Roster;

public interface Climber {
    String getName();

    double getStrength();

    boolean canClimb();

    Roster getRoster();


    void climb();
}
