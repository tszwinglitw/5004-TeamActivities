package controller;

import model.Calculator;
import view.ConsoleView;
import view.IView;

import java.util.List;
import java.util.Stack;

public class CalculatorController implements ICalculatorController {

    private IView view;
    private Calculator model;


    public CalculatorController(IView view, Calculator model) {
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
                double result = processOperation(operation).doubleValue();
                System.out.println(String.format("Result: %f", result));
                // to add
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

    @Override
    public Number processOperation(String operation) {
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
                    throw new IllegalArgumentException("Not enough numbers for operation: " + token);
                }
                // reversed order of parsing


                Number a = numbers.pop();
                Number b = numbers.pop();

                Number result = invokeOperation(op, a, b);

                numbers.push(result);
            }
        }
        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        return numbers.pop();
    }

    @Override
    public Operation getOperation(String symbol) {
        return Operation.getOperation(symbol);
    }

//    public List<String> getOperationSymbols() {
//        // what am I supposed to do with this?
//        return List.of();
//    }

    @Override
    public Number invokeOperation(Operation op, Number a, Number b) {
        Number result = null;
        switch (op) {
            case ADD:
                result = model.add(a, b);
                break;
            case SUBTRACT:
                result = model.subtract(a, b);
                break;
            case MULTIPLY:
                result = model.multiply(a, b);
                break;
            case DIVIDE:
                result = model.divide(a, b);
                break;
            default:
                break;
        }
        return result;
    }
}


