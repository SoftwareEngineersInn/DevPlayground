package org.software.engineers.inn.design.patterns.wrong;

/** Here this class is creating its own dependency
 * This will difficult changing the implementation of the Engine motor
 * or simulate it for tests
 * **/
public class Car {
    private Engine engine;

    public Car() {
        this.engine = new Engine(); // The Car class relies on the Engine class DIRECTLY
    }
}
/**
 *
 * This class is instancing the Engine class use "new" this will
 * make this a highly coupled code since the Car class its creating its own dependencies
 * and not receiving them from an external source as the DI pattern demands
 *
 * **/