package view;

import controller.ICalculatorController;
import controller.Operation;

import java.io.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ConsoleView implements IView {
    private static final String PROMPT = "> ";
    private static final String ERROR = "Error: ";
    private static final Console console = System.console();

    public ConsoleView() {}

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


}