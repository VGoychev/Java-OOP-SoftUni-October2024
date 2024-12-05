package _Exam_14August2024.forgottenBattleships.entities.battleship;

public interface Battleship {

    String getName();

    int getHealth();

    int getHitStrength();

    int getAmmunition();

    void attack(Battleship battleship);

    void takeDamage(Battleship battleship);


}
