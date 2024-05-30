package student;

import student.controller.CalculatorController;
import student.controller.IController;
import student.model.Calculator;
import student.model.ICalculator;
import student.view.ConsoleView;
import student.view.IView;

public class CalculatorApp {

    public static void main(String[] args) {

        ICalculator model = new Calculator();
        IController controller = new CalculatorController(model);
        IView view = new ConsoleView(controller);


        view.start();

    }
}
