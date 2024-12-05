package _Exam_14August2024.forgottenBattleships.entities.battleship;

import static _Exam_14August2024.forgottenBattleships.common.ExceptionMessages.SHIP_NAME_NULL_OR_EMPTY;

public abstract class BaseBattleship implements Battleship{
    private String name;
    private int health;
    private int ammunition;
    private int hitStrength;

    public BaseBattleship(String name, int health, int ammunition, int hitStrength) {
        setName(name);
        setHealth(health);
        setAmmunition(ammunition);
        this.hitStrength = hitStrength;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(SHIP_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getHitStrength() {
        return this.hitStrength;
    }

    @Override
    public int getAmmunition() {
        return this.ammunition;
    }
}
