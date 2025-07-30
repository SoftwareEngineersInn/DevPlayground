package org.software.engineers.inn.solid.ok.impl;

import org.software.engineers.inn.solid.ok.Bird;
import org.software.engineers.inn.solid.ok.FlyingBird;
import org.software.engineers.inn.solid.ok.SwimmingBird;

/** this is a great example on how to follow ISP
 * Notice how Duck implement little and cohesive interfaces instead of implement one
 * with several responsibilities**/
public class Duck implements Bird, FlyingBird, SwimmingBird {

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
/**
 * Each class only implements the interfaces it needs. → ISP
 * * No subclass breaks the contract of its supertype → LSP
 * **/
