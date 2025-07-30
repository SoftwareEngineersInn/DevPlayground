package org.software.engineers.inn.solid.ok;

/** The concrete implementation **/
public class EmailService implements MessageService{

    @Override
    public void sendMessage(String message) {
        System.out.println("Enviando email: " + message);
    }
}
