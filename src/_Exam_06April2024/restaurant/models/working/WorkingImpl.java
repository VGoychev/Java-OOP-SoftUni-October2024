package _Exam_06April2024.restaurant.models.working;

import _Exam_06April2024.restaurant.models.client.Client;
import _Exam_06April2024.restaurant.models.waiter.Waiter;

import java.util.Collection;
public class WorkingImpl implements Working{
    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        Collection<String> clientOrders = client.getClientOrders();
        for (Waiter waiter : waiters){
            while (waiter.canWork() && !clientOrders.isEmpty()){
                waiter.work();
                String order = clientOrders.iterator().next();
                waiter.takenOrders().getOrdersList().add(order);
                clientOrders.remove(order);
            }
        }
    }
}
