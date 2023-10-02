package com.application.housingloancalculator.calculator;

public class PaymentData {
    private final int MONTH;
    private final double LOAN_BALANCE;
    private final double MONTHLY_PAYMENT;
    private final double INTEREST;
    private final double CREDIT;

    public PaymentData(int month, double loanBalance, double monthlyPayment, double interest, double credit) {
        MONTH = month;
        LOAN_BALANCE = loanBalance;
        MONTHLY_PAYMENT = monthlyPayment;
        INTEREST = interest;
        CREDIT = credit;
    }

    public int getMonth() {
        return MONTH;
    }

    public double getLoanBalance() {
        return LOAN_BALANCE;
    }

    public double getMonthlyPayment() {
        return MONTHLY_PAYMENT;
    }

    public double getInterest() {
        return INTEREST;
    }

    public double getCredit() {
        return CREDIT;
    }

    public String[] getDataToSave() {
        return new String[]{
                Integer.toString(getMonth()),
                Double.toString(getLoanBalance()),
                Double.toString(getMonthlyPayment()),
                Double.toString(getInterest()),
                Double.toString(getCredit())};
    }
}
