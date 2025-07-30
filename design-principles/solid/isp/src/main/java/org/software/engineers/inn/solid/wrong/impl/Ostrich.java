package org.software.engineers.inn.solid.wrong.impl;

import org.software.engineers.inn.solid.wrong.Bird;

public class Ostrich implements Bird {

    @Override
    public void fly() {
        /** an Ostrich can fly and Bird is letting Ostrich class getting access to an unused function **/
        throw new UnsupportedOperationException();
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
/**
 * Here you violate LSP (because Ostrich cannot fly, but is forced to do so)
 * And you violate ISP (because Ostrich is forced to implement methods he doesn't need)
 * **/