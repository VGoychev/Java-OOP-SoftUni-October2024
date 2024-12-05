package _Exam_19December2023.climbers.models.climber;



import _Exam_19December2023.climbers.models.roster.Roster;
import _Exam_19December2023.climbers.models.roster.RosterImpl;

import static _Exam_19December2023.climbers.common.ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY;
import static _Exam_19December2023.climbers.common.ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseClimber implements Climber{
    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        setName(name);
        setStrength(strength);
        this.roster = new RosterImpl();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public void setStrength(double strength) {
        if (strength < 0){
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }

        this.strength = strength;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public boolean canClimb() {
        if (this.strength > 0){
            return true;
        }
        return false;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }
}
