package org.software.engineers.inn.lsp.wrong;

/**
 * Even if the method is called send, it also modifies the state of other system (database) without its name or
 * documentation indicates it.
 *
 * This breaks the least surprise principle
 *
 * **/
public class EmailService {
    public void send(String emailAddress, String message) {
        // sends the email
        System.out.println("Sending email to: " + emailAddress);

        // saves the email in the db
        saveToDatabase(emailAddress, message);
    }

    private void saveToDatabase(String emailAddress, String message) {
        //TODO
    }
}
