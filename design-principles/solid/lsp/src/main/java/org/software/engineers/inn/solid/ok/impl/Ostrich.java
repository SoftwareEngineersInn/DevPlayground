package org.software.engineers.inn.solid.ok.impl;

import ok.Bird;

public class Ostrich implements Bird {

    @Override
    public void eat() {
        System.out.println("I can eat...");
    }

    @Override
    public void chirp() {
        System.out.println("I can chirp...");
    }
}
