package org.software.engineers.inn.solid.wrong;

/** Dependency of Notification class **/
public class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email:" + message);
    }
}
