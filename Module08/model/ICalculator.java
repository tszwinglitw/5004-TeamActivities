package model;


import controller.Operation;

public interface ICalculator {
    Number add(Number a, Number b);

    Number subtract(Number a, Number b);

    Number multiply(Number a, Number b);

    Number divide(Number a, Number b);

}