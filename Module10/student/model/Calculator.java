package student.model;

public class Calculator implements ICalculator {
    public Number add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    public Number subtract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    public Number multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    public Number divide(Number a, Number b) {
        return a.doubleValue() / b.doubleValue();
    }

    @Override
    public Number invokeOperation(Operation operation, Number a, Number b) {
        switch (operation) {
            case ADD:
                return add(a, b);
            case SUBTRACT:
                return subtract(a, b);
            case MULTIPLY:
                return multiply(a, b);
            case DIVIDE:
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    public static void main(String[] args) {
        // Simple main to test the calculator

        Calculator calculator = new Calculator();
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.subtract(1, 2));
        System.out.println(calculator.multiply(1, 2));
        System.out.println(calculator.divide(1, 2));

        System.out.println(calculator.add(3.14, 2));
        System.out.println(calculator.subtract(1, 3.14));
        System.out.println(calculator.multiply(3.14, 2));
        System.out.println(calculator.divide(1, 3.14));
    }
}
