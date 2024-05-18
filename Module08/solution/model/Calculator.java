package solution.model;

public class Calculator {
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
