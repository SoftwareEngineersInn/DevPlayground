package org.software.engineers.inn.solid;

import org.software.engineers.inn.solid.ok.EmailService;
import org.software.engineers.inn.solid.ok.MessageService;
import org.software.engineers.inn.solid.ok.Notification;

public class Main {
    public static void main(String[] args) {
        //TODO
        MessageService service = new EmailService();
        Notification notification = new Notification(service);
        notification.send("Hello and welcome");
    }
}