package _Exam_06April2024.restaurant.models.client;

import java.util.Collection;

public interface Client {

    Collection<String> getClientOrders();

    String getName();
}
