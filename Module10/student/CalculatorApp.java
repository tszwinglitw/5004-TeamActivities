package student;

import student.controller.CalculatorController;
import student.controller.IController;
import student.model.Calculator;
import student.model.ICalculator;
import student.view.ConsoleView;
import student.view.IView;
import student.view.JFrameView;

import javax.swing.*;

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
