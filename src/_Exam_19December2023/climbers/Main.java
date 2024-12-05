package _Exam_19December2023.climbers;


import _Exam_19December2023.climbers.core.Controller;
import _Exam_19December2023.climbers.core.ControllerImpl;
import _Exam_19December2023.climbers.core.Engine;
import _Exam_19December2023.climbers.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        //TODO
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
