package org.software.engineers.inn.solid.ok;

/** "child interface" that will provide the fly functionality on its own
 * but also eat() and chirp() from its "parent-interface"**/
public interface FlyingBird extends Bird{
    void fly();
}
