package _Exam_14August2024.forgottenBattleships.entities.battleship;

public class RoyalBattleship extends BaseBattleship{
    private static final int AMMO = 100;
    private static final int HIT_STRENGTH = 25;
    public RoyalBattleship(String name, int health) {
        super(name, health, AMMO, HIT_STRENGTH);
    }

    @Override
    public void attack(Battleship battleship) {
        int currentAmmo = getAmmunition() - 25;
        if (currentAmmo < 0){
            currentAmmo = 0;
        }
        super.setAmmunition(currentAmmo);
        battleship.takeDamage(this);
    }

    @Override
    public void takeDamage(Battleship battleship) {
        int currentHealth = getHealth() - battleship.getHitStrength();
        if (currentHealth < 0){
            currentHealth = 0;
        }
        super.setHealth(currentHealth);
    }
}