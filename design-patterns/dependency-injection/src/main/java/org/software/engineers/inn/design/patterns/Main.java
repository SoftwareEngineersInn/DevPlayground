package org.software.engineers.inn.design.patterns;

import org.software.engineers.inn.design.patterns.ok.Car;
import org.software.engineers.inn.design.patterns.ok.DieselEngine;
import org.software.engineers.inn.design.patterns.ok.Engine;

public class Main {
    public static void main(String[] args) {
        /** Example on how you can instance your concrete implementations **/
        Engine diesel = new DieselEngine(); // it can be an electric one too

        /**
         * DI applied here, notice how Car gets created and how DI provides its Engine Dependency
         * through the construct method
         * and the class Car doesn't create or instance the Engine Dependency inside
         * **/
        Car car = new Car(diesel);

        /**
         * Car will start running a Diesel engine
         * **/
        car.start();
    }
}