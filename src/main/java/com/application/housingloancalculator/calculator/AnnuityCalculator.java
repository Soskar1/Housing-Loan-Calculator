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
            double monthPayment = inputData.getDealAmount() * monthInterest * tmp / (tmp - 1);
            PaymentData paymentData = new PaymentData(i + 1, balance, monthPayment, 0, 0);
            paymentDataList.add(paymentData);
            System.out.println(monthPayment);
        }

        return paymentDataList;
    }
}
