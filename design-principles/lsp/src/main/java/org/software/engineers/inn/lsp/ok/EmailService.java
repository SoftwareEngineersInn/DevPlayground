package org.software.engineers.inn.lsp.ok;

/** Accomplishing the Least surprise principle **/
public class EmailService {
    public void send(String emailAddress, String message) {
        // The logic is clear: Sending an email is expected and there are no surprises
        System.out.println("Sending email to: " + emailAddress);
    }
}
/** In this class the name method "send " cleary indicates what's going to happen
 * without any surprises **/