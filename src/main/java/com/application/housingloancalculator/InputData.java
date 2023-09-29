package com.application.housingloancalculator;

public class InputData {
    private final int DEAL_AMOUNT;
    private final int ANNUAL_INTEREST;
    private final int YEARS;
    private final int MONTHS;

    public InputData(int dealAmount, int annualInterest, int years, int months) {
        DEAL_AMOUNT = dealAmount;
        ANNUAL_INTEREST = annualInterest;
        YEARS = years;
        MONTHS = months;
    }

    public int getDealAmount() {
        return DEAL_AMOUNT;
    }

    public int getAnnualInterest() {
        return ANNUAL_INTEREST;
    }

    public int getYears() {
        return YEARS;
    }

    public int getMonths() {
        return MONTHS;
    }
}
