package org.software.engineers.inn.design.patterns.creational.ok;

import org.springframework.stereotype.Service;

/**
 * Step 4: We use the factory in our service.
 * **/
@Service
public class NotificationService {

    private final NotificationFactory notificationFactory;

    public NotificationService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void sendNotification(String type, String message) {
        Notification notification = notificationFactory.createNotification(type);
        notification.send(message);
    }

}
/**
 *
 * Advantages:
 * - Notification service doesn't know which concrete classes exist.
 * - If I add PushNotification, I can only modify the factory, not the service.
 * - Easier to test and extend.
 * **/
