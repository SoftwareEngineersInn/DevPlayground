package org.software.engineers.inn.solid.ok;

/**
 * With this approach each Shape class will be able to implement the getArea method
 * and this method will be able to use the attributes from the self class
 * such side attribute in this case.
 * **/
public class Square implements Shape{
    /** Attribute to complete the get area formula **/
    private double side;

    /** Construct that initializes the radius **/
    public Square(double radius) {
        this.side = radius;
    }

    /** method that will calcule the area implemented from the shape interface **/
    public double getArea() {
        return side * side;
    }
}
/**
 * Check my comments on the Square Class
 * **/
