package _Exam_06April2024.restaurant.models.waiter;

import _Exam_06April2024.restaurant.models.orders.TakenOrders;

public interface Waiter {
    String getName();

    int getEfficiency();

    boolean canWork();

    TakenOrders takenOrders();


    void work();
}
