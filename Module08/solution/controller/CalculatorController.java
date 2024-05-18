package solution.controller;

import java.util.Stack;
import solution.model.Calculator;
import solution.view.ConsoleView;
import solution.model.Operation;

public class CalculatorController {

    private ConsoleView view;
    private Calculator model;


    public CalculatorController(ConsoleView view, Calculator model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        view.displayWelcome();
        while (true) {
            String operation = view.getClientOperation();
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                Number result = processOperation(operation);
                view.displayResult(result);
            } catch (Exception e) {
                view.displayError(e.getMessage());
            }
        }
        view.close();
    }

    private Number isNumber(String token) {
        try {
            Number dbl = Double.parseDouble(token);
            return dbl;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Number processOperation(String operation) {
        Stack<Number> numbers = new Stack<>();

        String[] tokens = operation.split("\\s+");

        for (var i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (token.isEmpty()) {
                continue;
            }
            Number number;
            if ((number = isNumber(token)) != null) {
                numbers.push(number);
            } else {
                Operation op = Operation.getOperation(token);
                if (op == null) {
                    throw new IllegalArgumentException("Invalid operation: " + token);
                }
                if (numbers.size() < 2) {
                    throw new IllegalArgumentException(
                            "Not enough numbers for operation: " + token);
                }
                Number b = numbers.pop();
                Number a = numbers.pop();
                Number result;
                result = doOperation(op, a, b);
                numbers.push(result);
            }
        }
        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        return numbers.pop();
    }

    private Number doOperation(Operation opt, Number a, Number b) {
        switch (opt) {
            case ADD:
                return model.add(a, b);
            case SUBTRACT:
                return model.subtract(a, b);
            case MULTIPLY:
                return model.multiply(a, b);
            case DIVIDE:
                return model.divide(a, b);
            default:
                throw new IllegalArgumentException("Invalid operation: " + opt);
        }
    }

}
