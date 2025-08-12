package org.software.engineers.inn.design.patterns.creational;

import org.software.engineers.inn.design.patterns.creational.wrong.Email;

public class Main {
    public static void main(String[] args) {
        //Creating and EmailLombok object without using the builder pattern
        //This approach can be confusing and uninformative
        Email email = new Email("destino@mail.com", "Asunto", "<b>Hola</b>", true);
    }
}