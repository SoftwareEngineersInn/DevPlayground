package org.software.engineers.inn.solid.ok;

/**
 * the getArea method will be the common function between shapes
 * so let's create an interface that can be implemented by any Shape Class
 * **/
public interface Shape {
    double getArea();
}
/**
 * This method will guarantee the use of OCP
 * since each shape will be implemented it to calculate the area,
 * and it will not affect already-proved code.
 */