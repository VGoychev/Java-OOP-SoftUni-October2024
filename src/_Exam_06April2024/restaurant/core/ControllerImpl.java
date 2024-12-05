package _Exam_06April2024.restaurant.core;

import _Exam_06April2024.restaurant.models.client.Client;
import _Exam_06April2024.restaurant.models.client.ClientImpl;
import _Exam_06April2024.restaurant.models.waiter.FullTimeWaiter;
import _Exam_06April2024.restaurant.models.waiter.HalfTimeWaiter;
import _Exam_06April2024.restaurant.models.waiter.Waiter;
import _Exam_06April2024.restaurant.models.working.Working;
import _Exam_06April2024.restaurant.models.working.WorkingImpl;
import _Exam_06April2024.restaurant.repositories.ClientRepository;
import _Exam_06April2024.restaurant.repositories.WaiterRepository;

import static _Exam_06April2024.restaurant.common.ConstantMessages.*;
import static _Exam_06April2024.restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private WaiterRepository waiterRepository;
    private ClientRepository clientRepository;
    private int clientServed;
    public ControllerImpl(){
        this.waiterRepository = new WaiterRepository();
        this.clientRepository = new ClientRepository();
        this.clientServed = 0;
    }

    public int getClientServed() {
        return this.clientServed;
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter;
        if (type.equals("FullTimeWaiter")){
            waiter = new FullTimeWaiter(waiterName);
        } else if (type.equals("HalfTimeWaiter")) {
            waiter = new HalfTimeWaiter(waiterName);
        } else {
            throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }

        this.waiterRepository.add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
            for (String order : orders) {
                client.getClientOrders().add(order);
            }
        this.clientRepository.add(client);

        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = this.waiterRepository.byName(waiterName);
        if (waiter == null){
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }
        this.waiterRepository.remove(waiter);
        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = this.clientRepository.byName(clientName);
        if (client == null){
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }
        this.clientRepository.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        if (this.waiterRepository.getCollection().isEmpty()){
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        Working working = new WorkingImpl();
        Client client = this.clientRepository.byName(clientName);
        working.takingOrders(client, this.waiterRepository.getCollection());
        this.clientServed++;
        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_CLIENTS_COUNT, getClientServed())).append(System.lineSeparator());
        sb.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());
        for (Waiter waiter : this.waiterRepository.getCollection()){
            sb.append(String.format(FINAL_WAITER_NAME, waiter.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency())).append(System.lineSeparator());
            if (waiter.takenOrders().getOrdersList().isEmpty()) {
                sb.append(String.format(FINAL_WAITER_ORDERS, "None")).append(System.lineSeparator());
            } else {
                sb.append(String.format(FINAL_WAITER_ORDERS, String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList()))).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
