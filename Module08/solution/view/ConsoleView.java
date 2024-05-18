package solution.view;

import java.io.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import solution.model.Operation;

public class ConsoleView {
    private static final String PROMPT = "> ";
    private static final String ERROR = "Error: ";
    private static final Console console = System.console();

    public void displayWelcome() {
        console.printf("Welcome to the calculator\n");
        console.printf("Allowed operations: " + Arrays.asList(Operation.values()).stream()
                .map(Operation::getSymbol).collect(Collectors.joining(" ")) + "\n");
        console.printf("Type exit to close calculator.\n");

    }

    public void displayError(String message) {
        console.printf(ERROR + message + "\n");
    }

    public void displayResult(Number result) {
        console.printf("%s\n", result.toString());
    }

    public String getClientOperation() {
        console.printf(PROMPT);
        return console.readLine();
    }

    public void close() {
        console.printf("Goodbye!\n");
    }

    // used to test
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        view.displayWelcome();
        view.displayResult(1);
        view.displayError("Error message");
        view.getClientOperation();
        view.close();
    }

}
