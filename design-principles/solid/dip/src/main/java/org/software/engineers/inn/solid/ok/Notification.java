package org.software.engineers.inn.solid.ok;

 /** High level module **/
public class Notification {
    private MessageService messageService;

    /** Dependency Inversion through the construct method**/
    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send(String message){
        messageService.sendMessage(message);
    }

}
