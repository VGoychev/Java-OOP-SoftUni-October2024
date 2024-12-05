package _Exam_14August2024.forgottenBattleships.core;

import _Exam_14August2024.forgottenBattleships.entities.battleship.Battleship;
import _Exam_14August2024.forgottenBattleships.entities.battleship.PirateBattleship;
import _Exam_14August2024.forgottenBattleships.entities.battleship.RoyalBattleship;
import _Exam_14August2024.forgottenBattleships.entities.battlezone.BattleZone;
import _Exam_14August2024.forgottenBattleships.entities.battlezone.BattleZoneImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static _Exam_14August2024.forgottenBattleships.common.ConstantMessages.*;
import static _Exam_14August2024.forgottenBattleships.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private Collection<BattleZone> battleZones;

    public ControllerImpl(){
        this.battleZones = new ArrayList<>();
    }
    //TODO Implement all the methods below

    @Override
    public String addBattleZone(String battleZoneName, int capacity) {
        BattleZone battleZone = this.battleZones.stream().filter(b -> b.getName().equals(battleZoneName))
                .findFirst().orElse(null);
        if (battleZone != null){
            throw new IllegalArgumentException(BATTLE_ZONE_EXISTS);
        }
        BattleZone battleZone1 = new BattleZoneImpl(battleZoneName, capacity);
        this.battleZones.add(battleZone1);

        return String.format(SUCCESSFULLY_ADDED_BATTLE_ZONE, battleZoneName);
    }

    @Override
    public BattleZone getBattleZoneByName(String battleZoneName) {
        return this.battleZones.stream().filter(battleZone -> battleZone.getName().equals(battleZoneName))
                .findFirst().orElse(null);
    }

    @Override
    public String addBattleshipToBattleZone(String battleZoneName, String shipType, String shipName, int health) {
        BattleZone battleZone = getBattleZoneByName(battleZoneName);
        if (battleZone == null){
            throw new NullPointerException(BATTLE_ZONE_DOES_NOT_EXISTS);
        }
        Battleship battleship;
        if (shipType.equals("RoyalBattleship")){
            battleship = new RoyalBattleship(shipName, health);
        } else if (shipType.equals("PirateBattleship")){
            battleship = new PirateBattleship(shipName, health);
        } else {
            throw new IllegalArgumentException(INVALID_SHIP_TYPE);
        }

        Battleship ship = battleZone.getBattleshipByName(shipName);
        if (ship != null){
            throw new IllegalArgumentException(SHIP_EXISTS);
        }

        battleZone.addBattleship(battleship);
        return String.format(SUCCESSFULLY_ADDED_SHIP, shipType, shipName, battleZoneName);
    }

    @Override
    public String startBattle(String battleZoneName, String attackingShip, String shipUnderAttack) {
        BattleZone battleZone = getBattleZoneByName(battleZoneName);
        if (battleZone.getShips().size() < 2){
            throw new IllegalArgumentException(INSUFFICIENT_COUNT);
        }
        Battleship attacking = battleZone.getBattleshipByName(attackingShip);
        Battleship underAttack = battleZone.getBattleshipByName(shipUnderAttack);
        if (attacking.getClass().getSimpleName().equals("PirateBattleship")){
            if (underAttack.getClass().getSimpleName().equals("RoyalBattleship")){
                if (attacking.getAmmunition() >= 10) {
                    attacking.attack(underAttack);
                }
            }
        } else if (attacking.getClass().getSimpleName().equals("RoyalBattleship")){
            if (attacking.getAmmunition() >= 25){
                attacking.attack(underAttack);
            }
        }

        if (attacking.getHealth() <= 0){
            battleZone.removeBattleShip(attacking);
        }
        if (underAttack.getHealth() <= 0){
            battleZone.removeBattleShip(underAttack);
        }

        return String.format(BATTLE_CONTINUES, battleZoneName, battleZone.getShips().stream()
                .map(Battleship::getName)
                .collect(Collectors.joining(", ")) );
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (BattleZone battleZone : this.battleZones){
            sb.append(String.format(SHIPS_IN_BATTLE_ZONE, battleZone.getName())).append(System.lineSeparator());
            if (battleZone.getShips().size() >= 2){
                for (Battleship battleship : battleZone.getShips()){
                    sb.append(String.format(SHIP_INFO, battleship.getName(), battleship.getHealth(), battleship.getAmmunition())).append(System.lineSeparator());
                }
            } else {
                for (Battleship battleship : battleZone.getShips()){
                    sb.append(String.format(SHIP_WINS, battleship.getName())).append(System.lineSeparator());
                    break;
                }
            }
        }
        return sb.toString();
    }
}
