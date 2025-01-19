package triangle;

public abstract class Triangle {
    protected double sideA, sideB, sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (!Triangle.hasValidSize(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Triangle sides not valid.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private static boolean hasValidSize(double sideA, double sideB, double sideC) {
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public abstract double getArea();

    public static void run() {
        System.out.println("--------------------------------------------");
        EquilateralTriangle et = new EquilateralTriangle(1);
        System.out.println("Equilateral Triangle's sides are: " + et.sideA + ", "+ et.sideB + ", " + et.sideC);
        System.out.println("Equilateral Triangle's area is: " + et.getArea());
        System.out.println("Equilateral Triangle's perimeter is: " + et.getPerimeter());
        System.out.println("--------------------------------------------");

        RightTriangle rt = new RightTriangle(2, 2);
        System.out.println("Right Triangle's sides are: " + rt.sideA + ", "+ rt.sideB + ", " + rt.sideC);
        System.out.println("Right Triangle's area is: " + rt.getArea());
        System.out.println("Right Triangle's perimeter is: " + rt.getPerimeter());
        System.out.println("--------------------------------------------");
    }

    public static void main(String args[]) {
        Triangle.run();
    }
}
