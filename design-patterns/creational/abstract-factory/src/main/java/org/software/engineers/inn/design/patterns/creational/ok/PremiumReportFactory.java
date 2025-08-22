package org.software.engineers.inn.design.patterns.creational.ok;

import org.software.engineers.inn.design.patterns.creational.ok.exporter.PdfExporter;
import org.software.engineers.inn.design.patterns.creational.ok.exporter.ReportExporter;
import org.software.engineers.inn.design.patterns.creational.ok.formatter.HtmlFormatter;
import org.software.engineers.inn.design.patterns.creational.ok.formatter.ReportFormatter;
import org.software.engineers.inn.design.patterns.creational.ok.validator.PremiumValidator;
import org.software.engineers.inn.design.patterns.creational.ok.validator.ReportValidator;
import org.springframework.stereotype.Component;

/**
 * Step 4: Concrete factory: one for each family (Premium Family in this case)
 * **/
@Component("premiumReportFactory")
public class PremiumReportFactory implements ReportFactory {
    @Override
    public ReportExporter createExporter() {
        return new PdfExporter();
    }

    @Override
    public ReportFormatter createFormatter() {
        return new HtmlFormatter();
    }

    @Override
    public ReportValidator createValidator() {
        return new PremiumValidator();
    }
}
