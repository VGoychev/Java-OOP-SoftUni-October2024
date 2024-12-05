package _Exam_10August2024.furnitureFactory.entities.workshops;

public class DeckingWorkshop extends BaseWorkshop{
    private static final int REDUCE_FACTOR = 150;

    public DeckingWorkshop(int woodQuantity) {
        super(woodQuantity, REDUCE_FACTOR);
    }

    @Override
    public void produce() {
        super.setWoodQuantity(getWoodQuantity() - REDUCE_FACTOR);
        if (getWoodQuantity() <= 0){
            setWoodQuantity(0);
        }
        super.setProducedFurnitureCount(getProducedFurnitureCount() + 1);
    }
}
