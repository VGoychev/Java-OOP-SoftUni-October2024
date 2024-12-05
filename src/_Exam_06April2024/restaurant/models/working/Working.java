package _Exam_06April2024.restaurant.models.working;

import _Exam_06April2024.restaurant.models.client.Client;
import _Exam_06April2024.restaurant.models.waiter.Waiter;

import java.util.Collection;

public interface Working {
    void takingOrders(Client client, Collection<Waiter> waiters);

}
