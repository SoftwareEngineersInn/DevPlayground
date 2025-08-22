package org.software.engineers.inn.design.patterns.creational.wrong;

import org.software.engineers.inn.design.patterns.creational.wrong.basic.BasicValidator;
import org.software.engineers.inn.design.patterns.creational.wrong.basic.CsvExporter;
import org.software.engineers.inn.design.patterns.creational.wrong.basic.TextFormatter;
import org.software.engineers.inn.design.patterns.creational.wrong.premium.HtmlFormatter;
import org.software.engineers.inn.design.patterns.creational.wrong.premium.PdfExporter;
import org.software.engineers.inn.design.patterns.creational.wrong.premium.PremiumValidator;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    //TODO
    public void generateReport(String clientType) {
        if ("PREMIUM".equals(clientType)) {
            PdfExporter exporter = new PdfExporter();
            HtmlFormatter formatter = new HtmlFormatter();
            PremiumValidator validator = new PremiumValidator();

            // ... use this objects

        } else if ("BASIC".equals(clientType)) {
            CsvExporter exporter = new CsvExporter();
            TextFormatter formatter = new TextFormatter();
            BasicValidator validator = new BasicValidator();

            // ... use these objects
        }
    }
}

/**
 * Problems:
 * - Client code full of if/else to instance concrete classes
 * - This class will require modification if you decide to add a new family of reports -> Breaks OCP
 * - Hard to test, highly coupled
 * **/