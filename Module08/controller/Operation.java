package controller;

// which package would this go in?

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
