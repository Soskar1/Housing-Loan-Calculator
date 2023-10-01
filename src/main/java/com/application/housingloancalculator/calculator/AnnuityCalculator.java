package com.application.housingloancalculator.calculator;

import com.application.housingloancalculator.InputData;

import java.util.ArrayList;

public class AnnuityCalculator extends Calculator {
    public AnnuityCalculator(InputData inputData) {
        super(inputData);
    }

    @Override
    public ArrayList<PaymentData> calculateAllPaymentData() {
        ArrayList<PaymentData> paymentDataList = new ArrayList<>();
        InputData inputData = getInputData();

        int totalMonths = inputData.getMonths() + inputData.getYears() * 12;
        double monthInterest = inputData.getAnnualInterest() / 100.0 / 12.0;
        double tmp = Math.pow(monthInterest + 1, totalMonths);
        double balance = inputData.getDealAmount();

        for (int i = 0; i < totalMonths; ++i) {
            double monthPayment = round(inputData.getDealAmount() * monthInterest * tmp / (tmp - 1));
            double interest = round(balance * monthInterest);
            double credit = round(monthPayment - interest);

            PaymentData paymentData = new PaymentData(i + 1, balance, monthPayment, interest, credit);
            paymentDataList.add(paymentData);

            balance -= credit;
            balance = round(balance);
        }

        return paymentDataList;
    }
}