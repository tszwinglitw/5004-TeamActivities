package solution;


import solution.controller.CalculatorController;
import solution.controller.IController;
import solution.model.Calculator;
import solution.model.ICalculator;
import solution.view.ConsoleView;
import solution.view.IView;
import solution.view.JFrameView;

public class CalculatorApp {

    public static void main(String[] args) {



        ICalculator model = new Calculator();
        IController controller = new CalculatorController(model);
        IView view;
        if (args.length > 0 && args[0].equals("console")) {
            view = new ConsoleView(controller);
        } else {
            view = new JFrameView(controller);
        }


        view.start();

    }
}
