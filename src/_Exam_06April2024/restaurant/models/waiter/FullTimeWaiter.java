package _Exam_06April2024.restaurant.models.waiter;

//TODO
public class FullTimeWaiter extends BaseWaiter{
    private static  final int EFFICIENCY = 8;
    public FullTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        int currentEfficiency = getEfficiency() - 1;
        if (currentEfficiency < 0){
            super.setEfficiency(0);
        } else {
            super.setEfficiency(currentEfficiency);
        }
    }
}
