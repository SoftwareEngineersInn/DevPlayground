package org.software.engineers.inn.design.patterns.ok;

/**
 * Same example but applying DI fostering low-coupling
 **/
public class Car {
    private final Engine engine;

    // DI by construct
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.run();
    }
}
