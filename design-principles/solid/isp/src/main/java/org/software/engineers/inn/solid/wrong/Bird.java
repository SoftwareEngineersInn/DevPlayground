package org.software.engineers.inn.solid.wrong;

/** This is approach will break the ISP
 * because the interface contains functions that a maybe/can not be
 * used by all birds
 * **/
public interface Bird {
    void fly();
    void swim();
    void eat();
}
