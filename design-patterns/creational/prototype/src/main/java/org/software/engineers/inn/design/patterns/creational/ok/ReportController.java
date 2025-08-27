package org.software.engineers.inn.design.patterns.creational.ok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Step 3: Use in a Controller.
 * **/
@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{title}")
    public Report getReport(@PathVariable String title) {
        return reportService.createReport(title);
    }
}
