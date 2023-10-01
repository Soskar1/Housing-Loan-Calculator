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

    protected double round(double value) {
        return Math.round(value * 100) / 100.0;
    }

    protected ArrayList<PaymentData> calculateDeferral(double loanBalance, Deferral deferral) {
        ArrayList<PaymentData> deferralPaymentData = new ArrayList<>();

        double fixedInterest = deferral.getInterest() / 100;
        double interest = round(loanBalance * fixedInterest);

        for (int i = 0; i < deferral.getDuration(); ++i) {
            PaymentData paymentData = new PaymentData(deferral.getStartMonth() + i, loanBalance, interest, interest, 0);
            deferralPaymentData.add(paymentData);
        }

        return deferralPaymentData;
    }
}
