package com.application.housingloancalculator;

import com.application.housingloancalculator.calculator.Deferral;
import com.application.housingloancalculator.calculator.RepaymentScheduleType;

import java.util.ArrayList;

public class InputData {
    private final double DEAL_AMOUNT;
    private final double ANNUAL_INTEREST;
    private final int TOTAL_MONTHS;
    private final RepaymentScheduleType REPAYMENT_SCHEDULE_TYPE;
    private final ArrayList<Deferral> DEFERRALS = new ArrayList<>();

    public InputData(double dealAmount, double annualInterest, int years, int months, RepaymentScheduleType repaymentScheduleType) {
        DEAL_AMOUNT = dealAmount;
        ANNUAL_INTEREST = annualInterest;
        TOTAL_MONTHS = years * 12 + months;
        REPAYMENT_SCHEDULE_TYPE = repaymentScheduleType;
    }

    public double getDealAmount() {
        return DEAL_AMOUNT;
    }

    public double getAnnualInterest() {
        return ANNUAL_INTEREST;
    }

    public int getTotalMonths() {
        return TOTAL_MONTHS;
    }

    public RepaymentScheduleType getRepaymentScheduleType() {
        return REPAYMENT_SCHEDULE_TYPE;
    }

    public void addDeferral(Deferral deferral) {
        DEFERRALS.add(deferral);
    }

    public ArrayList<Deferral> getDeferrals() {
        return DEFERRALS;
    }
}