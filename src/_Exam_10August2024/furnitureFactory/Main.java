package _Exam_10August2024.furnitureFactory;

import _Exam_10August2024.furnitureFactory.core.Engine;
import _Exam_10August2024.furnitureFactory.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}