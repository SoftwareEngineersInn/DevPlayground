package org.software.engineers.inn.design.patterns.creational.ok;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Singleton patter applied correctly with Spring
 *
 * Here, Spring assures that exists one instance only of EmailService
 * and it re-utilize where ever it gets injected.
 *
 * **/
@RestController
public class UserController {
    private final EmailService emailService;

    public UserController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public void registerUser(String email) {
        emailService.send(email, "Welcome with Spring Singleton!");
    }
}
/**
 *
 * NOTE: In Spring Boot @Component, @Service, @Repository or @Controller are always default Singletons
 *
 * **/
