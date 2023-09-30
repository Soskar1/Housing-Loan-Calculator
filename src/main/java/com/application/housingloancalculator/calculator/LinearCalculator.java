package com.application.housingloancalculator.calculator;

import com.application.housingloancalculator.InputData;

import java.util.ArrayList;
import java.util.HashMap;

public class LinearCalculator extends Calculator {
    private final HashMap<Integer, Integer> DAYS_IN_MONTHS = new HashMap<>() {{
        put(0, 31);
        put(1, 28);
        put(2, 31);
        put(3, 30);
        put(4, 31);
        put(5, 30);
        put(6, 31);
        put(7, 31);
        put(8, 30);
        put(9, 31);
        put(10, 30);
        put(11, 31);
        }};
    private final int DAYS_IN_YEAR = 365;

    public LinearCalculator(InputData inputData) {
        super(inputData);
    }

    @Override
    public ArrayList<PaymentData> calculateAllPaymentData() {
        ArrayList<PaymentData> paymentDataList = new ArrayList<>();
        InputData inputData = getInputData();

        int totalMonths = inputData.getMonths() + inputData.getYears() * 12;
        double annualInterest = inputData.getAnnualInterest() / 100.0;
        double monthInterest = annualInterest / 12.0;

        double balance = inputData.getDealAmount();

        for (int i = 0; i < totalMonths; ++i) {
            int daysInMonth = DAYS_IN_MONTHS.get(i % 12);
            double monthPayment = balance / (totalMonths - i) + balance * annualInterest * daysInMonth / DAYS_IN_YEAR;
            monthPayment = Math.round(monthPayment * 100) / 100.0;

            double interest = balance * monthInterest;
            interest = Math.round(interest * 100) / 100.0;

            double credit = monthPayment - interest;
            credit = Math.round(credit * 100) / 100.0;

            PaymentData paymentData = new PaymentData(i + 1, balance, monthPayment, interest, credit);
            paymentDataList.add(paymentData);

            balance -= credit;
            balance = Math.round(balance * 100) / 100.0;
        }

        return paymentDataList;
    }
}
