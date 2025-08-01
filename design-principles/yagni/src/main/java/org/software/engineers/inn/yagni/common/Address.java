package org.software.engineers.inn.yagni.common;

public class Address {
    private String houseNumber;
    private String houseColor;

    public Address() {
    }

    public Address(String houseNumber, String houseColor) {
        this.houseNumber = houseNumber;
        this.houseColor = houseColor;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseColor() {
        return houseColor;
    }

    public void setHouseColor(String houseColor) {
        this.houseColor = houseColor;
    }
}

