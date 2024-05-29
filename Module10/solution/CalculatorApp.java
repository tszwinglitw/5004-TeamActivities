package solution;

import javax.swing.UIManager;
import solution.controller.CalculatorController;
import solution.controller.IController;
import solution.model.Calculator;
import solution.model.ICalculator;
import solution.view.ConsoleView;
import solution.view.IView;
import solution.view.JFrameView;

public class CalculatorApp {

    public static void main(String[] args) {

        // this sets it to match the operating system (sort of - light mode only, no dark mode
        // unless using a third party library)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

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
