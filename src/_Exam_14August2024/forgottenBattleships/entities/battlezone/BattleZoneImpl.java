package _Exam_14August2024.forgottenBattleships.entities.battlezone;

import _Exam_14August2024.forgottenBattleships.entities.battleship.Battleship;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static _Exam_14August2024.forgottenBattleships.common.ExceptionMessages.*;

public class BattleZoneImpl implements BattleZone{
    private String name;
    private int capacity;
    private Collection<Battleship> ships;

    public BattleZoneImpl(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.ships = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(BATTLE_ZONE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void addBattleship(Battleship ship) {
        if (this.capacity <= this.ships.size()){
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        if (ship.getHealth() <= 0){
            throw new IllegalArgumentException(SHIP_HEALTH_NULL_OR_EMPTY);
        }
        this.ships.add(ship);
    }

    @Override
    public Battleship getBattleshipByName(String battleshipName) {
        return this.ships.stream().filter(battleship -> battleship.getName().equals(battleshipName))
                .findFirst().orElse(null);
    }

    @Override
    public void removeBattleShip(Battleship ship) {
        this.ships.remove(ship);
    }

    @Override
    public Collection<Battleship> getShips() {
        return this.ships;
    }
}
