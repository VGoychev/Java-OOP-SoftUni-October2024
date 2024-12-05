package _Exam_10August2024.furnitureFactory.entities.workshops;

public class TableWorkshop extends BaseWorkshop{
    private static final int REDUCE_FACTOR = 50;
    public TableWorkshop(int woodQuantity) {
        super(woodQuantity, REDUCE_FACTOR);
    }

    @Override
    public void produce() {
        super.setWoodQuantity(getWoodQuantity() - REDUCE_FACTOR);
        if (getWoodQuantity() <= 0){
            super.setWoodQuantity(0);
        }
        super.setProducedFurnitureCount(getProducedFurnitureCount() + 1);
    }
}
