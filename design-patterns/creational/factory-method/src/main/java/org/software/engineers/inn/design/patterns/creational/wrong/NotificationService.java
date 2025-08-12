package org.software.engineers.inn.design.patterns.creational.wrong;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String type, String message) {
        if ("EMAIL".equalsIgnoreCase(type)) {
            EmailNotification email = new EmailNotification();
            email.send(message);
        } else if ("SMS".equalsIgnoreCase(type)) {
            SmsNotification sms = new SmsNotification();
            sms.send(message);
        }
    }

}
/**
 * Problems here:
 * - This service is coupled to EmailNotification and SmsNotification classes
 * - If I add PushNotification tomorrow, I will need to modify this method
 * - Bad adherence to OCP and SRP (Open to modification and the service has more than one reason to change
 * **/
