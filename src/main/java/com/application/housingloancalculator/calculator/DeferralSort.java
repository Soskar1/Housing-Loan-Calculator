package com.application.housingloancalculator.calculator;

import java.util.Comparator;

public class DeferralSort implements Comparator<Deferral> {
    @Override
    public int compare(Deferral d1, Deferral d2) {
        return d1.getStartMonth() - d2.getStartMonth();
    }
}
