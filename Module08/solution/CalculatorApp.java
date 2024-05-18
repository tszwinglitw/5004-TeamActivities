package solution;

import solution.controller.CalculatorController;
import solution.model.Calculator;
import solution.view.ConsoleView;

public class CalculatorApp {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        Calculator model = new Calculator();
        CalculatorController controller = new CalculatorController(view, model);

        controller.run();

    }
}
