package org.software.engineers.inn.design.patterns.creational.wrong;

/**
* This an example of an object being created without using the builder pattern
* **/
public class Email {
    private String to;
    private String subject;
    private String body;
    private boolean isHtml;

    public Email(String to, String subject, String body, boolean isHtml) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.isHtml = isHtml;
    }
}
