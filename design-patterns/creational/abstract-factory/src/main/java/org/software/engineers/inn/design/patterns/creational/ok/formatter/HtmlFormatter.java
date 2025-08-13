package org.software.engineers.inn.design.patterns.creational.ok.formatter;

/** Step 2: Concrete implementations **/
/** Premium Family **/
public class HtmlFormatter implements ReportFormatter {
    @Override
    public void format() {
        System.out.println("Html formatting...");
    }
}
