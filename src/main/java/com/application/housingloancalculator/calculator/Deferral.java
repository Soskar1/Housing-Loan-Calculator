package com.application.housingloancalculator.calculator;

public class Deferral {
    private final int START_MONTH;
    private final int DURATION;
    private final double INTEREST;

    public Deferral(int startMonth, int duration, double interest) {
        START_MONTH = startMonth;
        DURATION = duration;
        INTEREST = interest;
    }

    public int getStartMonth() {
        return START_MONTH;
    }

    public int getDuration() {
        return DURATION;
    }

    public double getInterest() {
        return INTEREST;
    }
}