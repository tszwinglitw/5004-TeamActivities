package solution.controller;

import java.util.Stack;
import solution.model.ICalculator;
import solution.model.Operation;

public class CalculatorController implements IController {

    private ICalculator model;


    public CalculatorController(ICalculator model) {
        this.model = model;
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
        String[] tokens = operation.split("\\s+");
        Stack<Number> numbers = new Stack<>();
        Stack<Operation> operations = new Stack<>();

        for (String token : tokens) {
            Number number = isNumber(token);
            if (number != null) {
                numbers.push(number);
            } else {
                Operation op = Operation.getOperation(token);
                if (op != null) {
                    while (!operations.isEmpty()
                            && op.getPrecedence() <= operations.peek().getPrecedence()) {
                        Operation prevOp = operations.pop();
                        Number num2 = numbers.pop();
                        Number num1 = numbers.pop();
                        Number result = model.invokeOperation(prevOp, num1, num2);
                        numbers.push(result);
                    }
                    operations.push(op);
                }
            }
        }

        while (!operations.isEmpty()) {
            Operation op = operations.pop();
            Number num2 = numbers.pop();
            Number num1 = numbers.pop();
            Number result = model.invokeOperation(op, num1, num2);
            numbers.push(result);
        }

        return numbers.pop();
    }



}
