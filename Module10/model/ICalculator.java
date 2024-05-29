package solution.model;

import java.util.List;

public interface ICalculator {

    Number invokeOperation(Operation operation, Number a, Number b);

    // yes, interfaces may have static methods

    static Operation getOperation(String symbol) {
        return Operation.getOperation(symbol);
    }

    static List<String> getOperationSymbols() {
        return List.of(Operation.values()).stream().map(Operation::getSymbol).toList();
    }


}
