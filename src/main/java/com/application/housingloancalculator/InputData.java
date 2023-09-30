package com.application.housingloancalculator;

import com.application.housingloancalculator.calculator.RepaymentScheduleType;

public class InputData {
    private final int DEAL_AMOUNT;
    private final int ANNUAL_INTEREST;
    private final int YEARS;
    private final int MONTHS;
    private final RepaymentScheduleType REPAYMENT_SCHEDULE_TYPE;

    public InputData(int dealAmount, int annualInterest, int years, int months, RepaymentScheduleType repaymentScheduleType) {
        DEAL_AMOUNT = dealAmount;
        ANNUAL_INTEREST = annualInterest;
        YEARS = years;
        MONTHS = months;
        REPAYMENT_SCHEDULE_TYPE = repaymentScheduleType;
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

    public RepaymentScheduleType getRepaymentScheduleType() {
        return REPAYMENT_SCHEDULE_TYPE;
    }
}
