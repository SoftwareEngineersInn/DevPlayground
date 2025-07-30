package org.software.engineers.inn.solid.ok;

/** this interface will be implemented by bird subclasses such Eagle, Ostrich, etc**/
public interface Bird {
    void eat();
    void chirp();
}
/** LSP its getting applied with this approach
 * look how the "father-interface" will provide the common functions to
 * the "child-interface"
 *
 * FlyingBird will be a "child-interface" and will extend from father,
 * so it can inherit eat() and chirp() functions.
 * **/
