package Exams._20240802_examPreparation.restaurant;

import Exams._20240802_examPreparation.restaurant.core.Controller;
import Exams._20240802_examPreparation.restaurant.core.ControllerImpl;
import Exams._20240802_examPreparation.restaurant.core.Engine;
import Exams._20240802_examPreparation.restaurant.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
