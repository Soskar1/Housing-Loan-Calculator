package com.application.housingloancalculator.calculator;

import com.application.housingloancalculator.InputData;

import java.util.ArrayList;

public abstract class Calculator {
    private final InputData INPUT_DATA;

    public Calculator(InputData inputData) {
        INPUT_DATA = inputData;
    }

    public ArrayList<PaymentData> calculateAllPaymentData() {
        ArrayList<PaymentData> paymentData = new ArrayList<>();

        int totalMonths = INPUT_DATA.getYears() * 12 + INPUT_DATA.getMonths();

        for (int i = 0; i < totalMonths; ++i) {
            paymentData.add(calculatePaymentDataForMonth());
        }

        return paymentData;
    }

    protected abstract PaymentData calculatePaymentDataForMonth();

    protected InputData getInputData() {
        return INPUT_DATA;
    }
}
