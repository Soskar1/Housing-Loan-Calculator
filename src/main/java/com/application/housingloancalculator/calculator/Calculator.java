package com.application.housingloancalculator.calculator;

import com.application.housingloancalculator.InputData;

import java.util.ArrayList;

public abstract class Calculator {
    private final InputData INPUT_DATA;

    public Calculator(InputData inputData) {
        INPUT_DATA = inputData;
    }

    public abstract ArrayList<PaymentData> calculateAllPaymentData();

    protected InputData getInputData() {
        return INPUT_DATA;
    }
}
