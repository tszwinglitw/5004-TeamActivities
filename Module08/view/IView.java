package view;

import controller.ICalculatorController;
import controller.Operation;

import java.io.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

public interface IView {
    void displayWelcome();

    void displayError(String message);

    String getClientOperation();

    void close();
}

