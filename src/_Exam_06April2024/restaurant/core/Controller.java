package _Exam_06April2024.restaurant.core;

public interface Controller {
    String addWaiter(String type, String waiterName);

    String addClient(String clientName, String... orders);

    String removeWaiter(String waiterName);

    String removeClient(String clientName);

    String startWorking(String clientName);

    String getStatistics();


}
