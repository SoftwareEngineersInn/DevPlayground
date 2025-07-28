package ok.impl;

import ok.FlyingBird;

/**
 * Example of how LSP allows this class to use only what it exactly needs.
 * **/
public class Eagle implements FlyingBird {

    @Override
    public void fly() {
        System.out.println("I can fly...");
    }

    @Override
    public void eat() {
        System.out.println("I can eat...");
    }

    @Override
    public void chirp() {
        System.out.println("I can chirp...");
    }
}
