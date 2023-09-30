package com.application.housingloancalculator.calculator;

import com.application.housingloancalculator.InputData;

public class AnnuityCalculator extends Calculator {

    public AnnuityCalculator(InputData inputData) {
        super(inputData);
    }

    @Override
    protected PaymentData calculatePaymentDataForMonth() {
        InputData inputData = getInputData();

        //TODO: use formula
        PaymentData paymentData = new PaymentData(0, 0, 0, 0, 0);
        return paymentData;
    }
}
