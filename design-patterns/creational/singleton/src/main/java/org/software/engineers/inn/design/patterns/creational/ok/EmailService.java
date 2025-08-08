package org.software.engineers.inn.design.patterns.creational.ok;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void send(String to, String message){
        System.out.println("Sending email to: " + to);
    }
}
