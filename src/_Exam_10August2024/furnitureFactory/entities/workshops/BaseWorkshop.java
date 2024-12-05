package _Exam_10August2024.furnitureFactory.entities.workshops;

import _Exam_10August2024.furnitureFactory.entities.wood.Wood;

public abstract class BaseWorkshop implements Workshop{
    private int woodQuantity;
    private int producedFurnitureCount;
    private int woodQuantityReduceFactor;

    public BaseWorkshop(int woodQuantity, int woodQuantityReduceFactor) {
        setWoodQuantity(woodQuantity);
        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
        this.producedFurnitureCount = 0;

    }

    public void setWoodQuantity(int woodQuantity) {
        this.woodQuantity = woodQuantity;
    }

    public void setProducedFurnitureCount(int producedFurnitureCount) {
        this.producedFurnitureCount = producedFurnitureCount;
    }

    @Override
    public int getWoodQuantity() {
        return this.woodQuantity;
    }

    @Override
    public int getProducedFurnitureCount() {
        return this.producedFurnitureCount;
    }

    @Override
    public int getWoodQuantityReduceFactor() {
        return this.woodQuantityReduceFactor;
    }

    @Override
    public void addWood(Wood wood) {
        if (wood.getClass().getSimpleName().equals("OakWood")){
            setWoodQuantity(getWoodQuantity() + 200);
        }
    }

    @Override
    public void produce() {
        setWoodQuantity(getWoodQuantity() - getWoodQuantityReduceFactor());
        if (getWoodQuantity() <= 0){
            setWoodQuantity(0);
        }
        this.producedFurnitureCount++;
    }
}
