package ok;

/**
 * Same approach from the Square class
 * Notice how the get area changes its formula and by this approach
 * Only the shape class will set the way it calculates its own area
 * **/
public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
/**
 * As longer as you create new shapes, you will set the responsibility of calculate
 * each area to each new form instead of modifying a huge 'if' structure as the
 * wrong example shows us.
 * **/