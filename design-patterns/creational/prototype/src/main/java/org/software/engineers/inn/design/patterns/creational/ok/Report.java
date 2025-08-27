package org.software.engineers.inn.design.patterns.creational.ok;

/**
 * Prototype Solution
 *
 * Step 1: Implements Cloneable
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
