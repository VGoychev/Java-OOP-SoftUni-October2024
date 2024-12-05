package _Exam_06April2024.restaurant;

import _Exam_06April2024.restaurant.core.Controller;
import _Exam_06April2024.restaurant.core.ControllerImpl;
import _Exam_06April2024.restaurant.core.Engine;
import _Exam_06April2024.restaurant.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        //TODO
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
