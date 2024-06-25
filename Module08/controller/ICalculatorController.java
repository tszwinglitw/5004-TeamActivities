package controller;

import java.util.List;

public interface ICalculatorController {

    Operation getOperation(String symbol);

    // List<String> getOperationSymbols();

    Number invokeOperation(Operation operation, Number a, Number b);

    Number processOperation(String operation);


}
