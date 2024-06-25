package model;

import controller.Operation;
import model.ICalculator;

public class Calculator implements ICalculator {


    @Override
    public Number add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    @Override
    public Number subtract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    @Override
    public Number multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    @Override
    public Number divide(Number a, Number b) {
        return a.doubleValue() / b.doubleValue();
    }


}