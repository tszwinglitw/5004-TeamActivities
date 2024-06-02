package solution.model;

// We selected placing this ni the model
// As it is a enum that represents the type
// of actions the calculator model can perform.

// This is debatable on where!

public enum Operation {
    ADD("+", 0), SUBTRACT("-", 0), MULTIPLY("*", 1), DIVIDE("/", 1);

    private final String symbol;
    private final int precedence;

    Operation(String symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPrecedence() {
        return precedence;
    }

    public static Operation getOperation(String symbol) {
        for (Operation operation : Operation.values()) {
            if (operation.getSymbol().equals(symbol)) {
                return operation;
            }
        }
        return null;
    }
}
