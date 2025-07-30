package org.software.engineers.inn.solid.ok.impl;


import org.software.engineers.inn.solid.ok.Bird;

/** Notice hoy Ostrich can only access to eat due to its Bird implementation achieving ISP**/
public class Ostrich implements Bird {
    @Override
    public void eat() {
        //TODO
    }
}
