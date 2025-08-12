package org.software.engineers.inn.design.patterns.creational.ok;

import org.software.engineers.inn.design.patterns.creational.ok.lombok.EmailLombok;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendWelcomeEmail(String userEmail) {
        Email email = new Email.Builder()
                .to(userEmail)
                .subject("Bienvenido a nuestro sistema")
                .body("<h1>Hola, gracias por registrarte</h1>")
                .isHtml(true)
                .build();

        // TODO: logic to send the email
    }

    /** Lombok exambple using @Builder**/

    /**
     * if .builder() marks an error
     * check first building your app and see if the build is successful
     * otherwise
     * the IDE is the one that is having issues to process lombok annotations
     * fix: install the lombok plugin to your IDE.
     * **/
    public void sendWelcomeEmailLombok(String userEmail) {
        EmailLombok email = EmailLombok.builder()
                .to("destino@mail.com")
                .subject("Bienvenido")
                .body("Hola usuario")
                .isHtml(false)
                .build();
    }

}
/**
 *
 * Clear improvement against the code used by the not optimized approach
 *
 * Avoiding constructs with so many params
 * the code is more readable
 * EmailLombok object is immutable
 * Now we can validation logic inside the build method()
 *
 * **/