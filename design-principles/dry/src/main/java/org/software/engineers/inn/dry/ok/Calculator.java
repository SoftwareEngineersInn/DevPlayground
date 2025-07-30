package org.software.engineers.inn.dry.ok;

/**
 * The logic here is centralized. If the rate changes, you only need to modify it in one place.
 * **/
public class Calculator {

    private static final double VAT_RATE = 0.13;

    public double calculateVAT(double price) {
        return price * VAT_RATE;
    }

    public double totalCalculationIncludingVAT(double price) {
        return price + calculateVAT(price);
    }
}
