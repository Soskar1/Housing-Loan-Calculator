package com.application.housingloancalculator.calculator;

import com.application.housingloancalculator.InputData;

public class LinearCalculator extends Calculator {

    public LinearCalculator(InputData inputData) {
        super(inputData);
    }

    @Override
    protected PaymentData calculatePaymentDataForMonth() {
        return null;
    }
}
