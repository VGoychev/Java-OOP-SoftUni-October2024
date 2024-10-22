package _01_WorkingWithAbstraction.exercise._06_GreedyTimes;

import java.util.Objects;

public class Item {
    private String name;
    private long amount;
    private ItemType itemType;



    public Item(String name, long amount, ItemType itemType) {
        this.name = name;
        this.amount = amount;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && itemType == item.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, itemType);
    }
}
