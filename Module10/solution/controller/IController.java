package solution.controller;

import java.util.List;
import solution.model.Operation;

public interface IController {
    Number processOperation(String operation);



    static List<String> getOperationSymbols() {
        return List.of(Operation.values()).stream().map(Operation::getSymbol).toList();
    }

}
