package _Exam_09December_2023.harpoonDiver;


import _Exam_09December_2023.harpoonDiver.core.Controller;
import _Exam_09December_2023.harpoonDiver.core.ControllerImpl;
import _Exam_09December_2023.harpoonDiver.core.Engine;
import _Exam_09December_2023.harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
