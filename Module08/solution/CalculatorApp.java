package solution;

import solution.controller.CalculatorController;
import solution.controller.IController;
import solution.model.Calculator;
import solution.model.ICalculator;
import solution.view.ConsoleView;
import solution.view.IView;

public class CalculatorApp {

    public static void main(String[] args) {

        ICalculator model = new Calculator();
        IController controller = new CalculatorController(model);
        IView view = new ConsoleView(controller);


        view.start();

    }
}
