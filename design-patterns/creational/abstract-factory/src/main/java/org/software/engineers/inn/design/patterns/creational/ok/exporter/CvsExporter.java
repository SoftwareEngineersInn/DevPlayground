package org.software.engineers.inn.design.patterns.creational.ok.exporter;

/** Step 2: Concrete implementations **/
/** Basic Family **/
public class CvsExporter implements ReportExporter {
    @Override
    public void export() {
        System.out.println("Exporting on CVS format...");
    }
}
