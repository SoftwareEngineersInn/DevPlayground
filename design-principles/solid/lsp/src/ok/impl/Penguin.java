package ok.impl;

import ok.Bird;
import ok.SwimmingBird;

/**
 * Example of how LSP allows this class to use only what it exactly needs.
 * **/
public class Penguin implements Bird, SwimmingBird {

    @Override
    public void eat() {
        System.out.println("I can eat...");
    }

    @Override
    public void chirp() {
        System.out.println("I can chirp...");
    }

    @Override
    public void swim() {
        System.out.println("I can swim...");
    }

}
