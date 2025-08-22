package org.software.engineers.inn.design.patterns.creational.ok.validator;

public class BasicValidator implements ReportValidator {
    @Override
    public void validate() {
        System.out.println("Validating by basic...");
    }
}
