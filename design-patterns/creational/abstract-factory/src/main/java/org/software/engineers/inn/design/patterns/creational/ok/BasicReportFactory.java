package org.software.engineers.inn.design.patterns.creational.ok;

import org.software.engineers.inn.design.patterns.creational.ok.exporter.CvsExporter;
import org.software.engineers.inn.design.patterns.creational.ok.exporter.ReportExporter;
import org.software.engineers.inn.design.patterns.creational.ok.formatter.ReportFormatter;
import org.software.engineers.inn.design.patterns.creational.ok.formatter.TextFormatter;
import org.software.engineers.inn.design.patterns.creational.ok.validator.BasicValidator;
import org.software.engineers.inn.design.patterns.creational.ok.validator.ReportValidator;
import org.springframework.stereotype.Component;

/**
 * Step 4: Concrete factory: one for each family (Basic Family in this case)
 * **/
@Component("basicReportFactory")
public class BasicReportFactory implements ReportFactory {
    @Override
    public ReportExporter createExporter() {
        return new CvsExporter();
    }

    @Override
    public ReportFormatter createFormatter() {
        return new TextFormatter();
    }

    @Override
    public ReportValidator createValidator() {
        return new BasicValidator();
    }
}
