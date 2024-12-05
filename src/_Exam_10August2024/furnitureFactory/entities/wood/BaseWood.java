package _Exam_10August2024.furnitureFactory.entities.wood;

public abstract class BaseWood implements Wood{
    private int woodQuantity;

    public BaseWood(int woodQuantity) {
        this.woodQuantity = woodQuantity;
    }

    @Override
    public int getWoodQuantity() {
        return this.woodQuantity;
    }
}
