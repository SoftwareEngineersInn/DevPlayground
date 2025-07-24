package wrong;

/**
 * This is an example where you can recur to OCP
 * This class can became huge for each shape that will be required to calculate its area.
 * So the main 'if' structure, will become huge and difficult to maintain.
 * An this approach will break the OCP
 * **/
public class ShapeAreaCalculator {
    public double area(Object shape) {
        if (shape instanceof Circle){
            /** Calculates the area of a Circle shape **/
            return 1;
        } else if (shape instanceof  Square){
            /** Calculates the area of a Square shape **/
            return 2;
        }
        return 0;
    }
}
