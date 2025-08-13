package org.software.engineers.inn.design.patterns.creational.ok.formatter;

/** Step 2: Concrete implementations **/
/** Basic Family **/
public class TextFormatter implements ReportFormatter {
    @Override
    public void format() {
        System.out.println("Text formatting...");
    }
}
