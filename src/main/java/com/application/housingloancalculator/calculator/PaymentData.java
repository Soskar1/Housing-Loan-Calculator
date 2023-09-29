package com.application.housingloancalculator.calculator;

public class PaymentData {
    private final int MONTH;
    private final int LOAN_BALANCE;
    private final int MONTHLY_PAYMENT;
    private final int INTEREST;
    private final int CREDIT;

    public PaymentData(int month, int loanBalance, int monthlyPayment, int interest, int credit) {
        MONTH = month;
        LOAN_BALANCE = loanBalance;
        MONTHLY_PAYMENT = monthlyPayment;
        INTEREST = interest;
        CREDIT = credit;
    }

    public int getMonth() {
        return MONTH;
    }

    public int getLoanBalance() {
        return LOAN_BALANCE;
    }

    public int getMonthlyPayment() {
        return MONTHLY_PAYMENT;
    }

    public int getInterest() {
        return INTEREST;
    }

    public int getCredit() {
        return CREDIT;
    }
}
