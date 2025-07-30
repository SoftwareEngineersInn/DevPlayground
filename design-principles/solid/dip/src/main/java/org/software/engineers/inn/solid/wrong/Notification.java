package org.software.engineers.inn.solid.wrong;

public class Notification {
    private EmailService emailService;

    public Notification() {
        this.emailService = new EmailService();
    }

    public void send(String message) {
        emailService.sendEmail(message);
    }
}
/**
 * In this example, the Notification class is tightly coupled to EmailService,
 * which violates the dependency inversion principle (DIP).
 * **/