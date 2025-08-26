package org.software.engineers.inn.design.patterns.creational.ok;

/**
 * Prototype Solution
 *
 * You create a base prototype, and we clone it everytime we need a new Report
 * **/
public class Report implements Cloneable {
    private String title;
    private String content;

    public Report() {
        try {
            Thread.sleep(2000); // heavy load simulation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = "Base Template Content";
    }

    @Override
    public Report clone() {
        try {
            return (Report) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // setters and getters
}
