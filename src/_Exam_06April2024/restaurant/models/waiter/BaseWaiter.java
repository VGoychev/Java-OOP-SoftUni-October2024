package _Exam_06April2024.restaurant.models.waiter;

import _Exam_06April2024.restaurant.models.orders.TakenOrders;
import _Exam_06April2024.restaurant.models.orders.TakenOrdersImpl;

import static _Exam_06April2024.restaurant.common.ExceptionMessages.WAITER_EFFICIENCY_LESS_THAN_ZERO;
import static _Exam_06April2024.restaurant.common.ExceptionMessages.WAITER_NAME_NULL_OR_EMPTY;

//TODO
public abstract class BaseWaiter implements Waiter{
    private String name;
    private int efficiency;
    private TakenOrders takenOrders;

    public BaseWaiter(String name, int efficiency) {
        setName(name);
        setEfficiency(efficiency);
        this.takenOrders = new TakenOrdersImpl();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(WAITER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEfficiency(int efficiency) {
        if (efficiency < 0){
            throw new IllegalArgumentException(WAITER_EFFICIENCY_LESS_THAN_ZERO);
        }
        this.efficiency = efficiency;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEfficiency() {
        return this.efficiency;
    }

    @Override
    public boolean canWork() {
        if (this.efficiency > 0){
            return true;
        }
        return false;
    }

    @Override
    public TakenOrders takenOrders() {
        return this.takenOrders;
    }

}
