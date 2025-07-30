package org.software.engineers.inn.solid.ok.impl;

import ok.Bird;
import ok.FlyingBird;
import ok.SwimmingBird;

/**
 * Example of how LSP allows this class to use only what it exactly needs.
 **/
public class Duck implements Bird, FlyingBird, SwimmingBird {

    @Override
    public void fly() {
        System.out.println("I can fly...");
    }

    @Override
    public void swim() {
        System.out.println("I can swim...");
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
