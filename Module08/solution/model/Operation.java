package solution.model;

// We selected placing this ni the model
// As it is a enum that represents the type
// of actions the calculator model can perform.

// This is debatable on where!

public enum Operation {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
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
