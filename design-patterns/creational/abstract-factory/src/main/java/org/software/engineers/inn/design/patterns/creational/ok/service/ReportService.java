package org.software.engineers.inn.design.patterns.creational.ok.service;

import org.software.engineers.inn.design.patterns.creational.ok.ReportFactory;
import org.software.engineers.inn.design.patterns.creational.ok.exporter.ReportExporter;
import org.software.engineers.inn.design.patterns.creational.ok.formatter.ReportFormatter;
import org.software.engineers.inn.design.patterns.creational.ok.validator.ReportValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Step 5: Service using the abstract factory pattern
 **/
@Service
public class ReportService {

    private final ReportFactory reportFactory;

    public ReportService(@Qualifier("premiumReportFactory") ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }

    public void generateReport() {
        ReportExporter exporter = reportFactory.createExporter();
        ReportFormatter formatter = reportFactory.createFormatter();
        ReportValidator validator = reportFactory.createValidator();

        validator.validate();
        formatter.format();
        exporter.export();
    }
}
/**
 * Spring boot advantages
 * - El @Qualifier allows to easily  change the injected family according to the context (profile, config, environment).
 * - There are no if/else with concrete classes.
 * - Easy to add new families without touching the Service code.
 * **/
