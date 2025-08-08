package org.software.engineers.inn.design.patterns.creational.wrong;

/**
 * In some controller or service
 * **/
public class UserController {
    /**
     * This approach will create the instance of email service everytime this class get reached
     * **/
    private EmailService emailService = new EmailService();

    public void registerUser(String email) {
        emailService.send(email, "Welcome!");
    }
}
/**
 *
 * WRONG: This class is instancing several times manually (No singleton nor injection)
 *
 * **/