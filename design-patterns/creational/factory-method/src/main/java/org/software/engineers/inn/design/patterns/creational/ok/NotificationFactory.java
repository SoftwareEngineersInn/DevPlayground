package org.software.engineers.inn.design.patterns.creational.ok;

import org.springframework.stereotype.Component;

/** Factory Method
 * Step 3: Create your Factory Method
 * **/
@Component
public class NotificationFactory {

    public Notification createNotification(String type) {
        if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailNotification();
        } else if ("SMS".equalsIgnoreCase(type)) {
            return new SmsNotification();
        }
        throw new IllegalArgumentException("Notification Type not supported");
    }

}
