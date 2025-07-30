package org.software.engineers.inn.solid.wrong.impl;

import org.software.engineers.inn.solid.wrong.Bird;

/**
 * Duck can implement without any problems the Bird interface
 * but what about the birds that can't fly or swing?
 * **/
public class Duck implements Bird {

    @Override
    public void fly() {
        //TODO
    }

    @Override
    public void swim() {
        //TODO
    }

    @Override
    public void eat() {
        //TODO
    }
}
