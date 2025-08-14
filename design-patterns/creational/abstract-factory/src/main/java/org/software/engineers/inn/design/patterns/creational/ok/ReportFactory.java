package org.software.engineers.inn.design.patterns.creational.ok;

import org.software.engineers.inn.design.patterns.creational.ok.exporter.ReportExporter;
import org.software.engineers.inn.design.patterns.creational.ok.formatter.ReportFormatter;
import org.software.engineers.inn.design.patterns.creational.ok.validator.ReportValidator;

/**
 * Step 3: Abstract factory
 * **/
public interface ReportFactory {
    ReportExporter createExporter();
    ReportFormatter createFormatter();
    ReportValidator createValidator();
}
