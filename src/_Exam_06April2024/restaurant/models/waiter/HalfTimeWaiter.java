package _Exam_06April2024.restaurant.models.waiter;

//TODO
public class HalfTimeWaiter  extends BaseWaiter{
    private static final int EFFICIENCY = 4;
    public HalfTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        int currentEfficiency = getEfficiency() - 2;
        if (currentEfficiency < 0){
            super.setEfficiency(0);
        } else {
            super.setEfficiency(currentEfficiency);
        }
    }
}
