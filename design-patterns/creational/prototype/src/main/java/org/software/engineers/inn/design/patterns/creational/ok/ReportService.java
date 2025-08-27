package org.software.engineers.inn.design.patterns.creational.ok;

import org.springframework.stereotype.Service;

/**
 * Step 2: Use the prototype in a Spring service.
 * **/
@Service
public class ReportService {
    private final Report prototype;

    public ReportService(){
        // We create the prototype only once
        this.prototype = new Report();
    }

    public Report createReport(String title) {
        Report newReport = prototype.clone();
        newReport.setTitle(title);
        return newReport;
    }

}
