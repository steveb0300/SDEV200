// M02 - Programming Assignment 2
// Create a triangle 

public class Triangle extends GeometricObject {

    // Data fields
    private double side1;
    private double side2;
    private double side3;

    // No-arg constructor to create default triangle
    Triangle() {
        
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }
    
    // Constructor with specified side lengths
    Triangle(double s1, double s2, double s3) {

        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }

    // Create accessor methods all 3 data fields
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // Create area method and return using Heron's formula
    // A = √ s(s-a)(s-b)(s-c)
    public double getArea() {

        // s = half the parameter or the sum of sides divided by 2
        double s = (side1 + side2 + side3) / 2;

        // return the result of Heron's formula
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Create perimeter method and return
    public double getPerimeter() {

        // Add the three sides of triangle and return parimeter
        return side1 + side2 + side3;
    }

    // Create a method to return a string of each side length
    public String toString() {

        return "Triangle: side1 = " + side1 + 
                        " side2 = " + side2 +
                        " side3 = " + side3;
    }
}
