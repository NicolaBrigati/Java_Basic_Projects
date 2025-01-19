package triangle;

/**
 * Represents a Right Triangle.  
 * Extends abstract class Triangle.
 */
public class RightTriangle extends Triangle {
    public RightTriangle(double sideA, double sideB) {
        super(sideA, sideB, getHypotenuse(sideA, sideB));
    }

    private static double getHypotenuse(double sideA, double sideB) {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }

    @Override
    public double getArea() {
        return (sideA * sideB) / 2;
    }
}
