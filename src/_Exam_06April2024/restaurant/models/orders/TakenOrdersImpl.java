package _Exam_06April2024.restaurant.models.orders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TakenOrdersImpl implements TakenOrders{
    private Collection<String> ordersList;
    public TakenOrdersImpl(){
        this.ordersList = new ArrayList<>();
    }
    @Override
    public Collection<String> getOrdersList() {
        return this.ordersList;
    }
}
