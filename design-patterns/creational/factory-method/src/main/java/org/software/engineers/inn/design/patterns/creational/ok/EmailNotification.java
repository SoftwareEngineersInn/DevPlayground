package org.software.engineers.inn.design.patterns.creational.ok;

/**
 * Step 2: Create your concrete implementations
 * **/
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
