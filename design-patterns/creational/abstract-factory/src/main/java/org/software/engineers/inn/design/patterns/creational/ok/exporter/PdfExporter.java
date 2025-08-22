package org.software.engineers.inn.design.patterns.creational.ok.exporter;

/**
 * Step 2: Concrete implementations
 * **/
/** Premium Family **/
public class PdfExporter implements ReportExporter {
    @Override
    public void export() {
        System.out.println("Exporting on PDF format...");
    }
}
