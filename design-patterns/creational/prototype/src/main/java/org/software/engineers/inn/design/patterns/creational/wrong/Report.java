package org.software.engineers.inn.design.patterns.creational.wrong;

/**
 * Imagine that we have this Report class that needs to connect to an external service and load large templates
 * before you can use the object
 * **/
public class Report {
    private String title;
    private String content;

    public Report() {
        // Expensive initialization simulation
        try {
            Thread.sleep(2000); //heavy load on the object
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = "Base Template Content";
    }

    // getters and setters
}
