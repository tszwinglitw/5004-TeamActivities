import controller.CalculatorController;
import model.Calculator;
import view.ConsoleView;
import view.IView;

public class CalcMain {

    public static void main(String[] args) {
        IView view = new ConsoleView();
        Calculator model = new Calculator();
        CalculatorController controller = new CalculatorController(view, model);
        controller.run();
    }
}