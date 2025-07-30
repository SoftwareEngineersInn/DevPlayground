package org.software.engineers.inn.dry.wrong;

/**
 * The VAT calculation is repeated. If the rate is changed from 13% to 15%, it must be done in two places.
 * This violates DRY.
 * **/
public class Calculator {

    public double calculateVAT(double price) {
        return price * 0.13;
    }

    public double totalCalculationIncludingVAT(double price) {
        double vat = price * 0.13; // -> logic duplication
        return price + vat;
    }
}
