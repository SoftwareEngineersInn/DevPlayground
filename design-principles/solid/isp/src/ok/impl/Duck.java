package ok.impl;

import ok.FlyingBird;
import ok.SwimmingBird;
import wrong.Bird;

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
 * Cada clase solo implementa las interfaces que necesita → ISP
 * Ninguna subclase rompe el contrato de su supertipo → LSP
 * **/
