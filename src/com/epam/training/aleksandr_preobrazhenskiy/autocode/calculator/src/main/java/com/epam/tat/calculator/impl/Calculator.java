package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_DOWN;

public class Calculator implements ICalculator {

    private int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        if (a == Double.MAX_VALUE && b == Double.MAX_VALUE)
            return Double.POSITIVE_INFINITY;
        if(a == -Double.MAX_VALUE && b == -Double.MAX_VALUE)
            return Double.NEGATIVE_INFINITY;

        return BigDecimal.valueOf(a + b).setScale(precision, HALF_DOWN).doubleValue();
    }

    @Override
    public double subtract(double a, double b) {
        if(a == -Double.MAX_VALUE && b == Double.MAX_VALUE){
            return Double.NEGATIVE_INFINITY;
        }

        if(a == Double.MAX_VALUE && b == -Double.MAX_VALUE){
            return Double.POSITIVE_INFINITY;
        }

        return BigDecimal.valueOf(a - b).setScale(precision, HALF_DOWN).doubleValue();
    }

    @Override
    public double multiply(double a, double b) {
        if(a == -Double.MAX_VALUE && b == Double.MAX_VALUE || (a == Double.MAX_VALUE && b == -Double.MAX_VALUE)) {
            return Double.NEGATIVE_INFINITY;
        }

        if (a == Double.MAX_VALUE && b == Double.MAX_VALUE) {
            return Double.POSITIVE_INFINITY;
        }

        return BigDecimal.valueOf(a * b).setScale(precision, HALF_DOWN).doubleValue();
    }

    @Override
    public double divide(double a, double b) {
        if(b == 0) {
            if (a > 0) {
                return Double.POSITIVE_INFINITY;
            } else if (a < 0) {
                return Double.NEGATIVE_INFINITY;
            } else {
                return Double.NaN;
            }
        }
        return BigDecimal.valueOf(a / b).setScale(precision, HALF_DOWN).doubleValue();
    }
}
