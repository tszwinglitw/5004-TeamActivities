package solution.view;

import java.io.Console;
import java.util.stream.Collectors;
import solution.controller.IController;



public class ConsoleView implements IView {
    private static final String PROMPT = "> ";
    private static final String ERROR = "Error: ";
    private static final Console CONSOLE = System.console();
    private IController actions;


    public ConsoleView(IController actions) {
        this.actions = actions;
    }

    public void start() {
        displayWelcome();
        while (true) {
            String operation = getClientOperation();
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                Number result = actions.processOperation(operation);
                displayResult(result);
            } catch (Exception e) { // let the view decide how it wants so show errors
                displayError(e.getMessage());
            }
        }
        close();
    }

    public void displayWelcome() {
        CONSOLE.printf("Welcome to the calculator\n");
        CONSOLE.printf("Allowed operations: "
                + IController.getOperationSymbols().stream().collect(Collectors.joining(" "))
                + "\n");
        CONSOLE.printf("Type exit to close calculator.\n");

    }

    public void displayError(String message) {
        CONSOLE.printf("%s", ERROR + message + "\n");
    }

    public void displayResult(Number result) {
        CONSOLE.printf("%s\n", result.toString());
    }

    public String getClientOperation() {
        CONSOLE.printf(PROMPT);
        return CONSOLE.readLine();
    }

    public void close() {
        CONSOLE.printf("Goodbye!\n");
    }

    // used to test

}
