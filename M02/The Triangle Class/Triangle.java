// M02 - Programming Assignment 2
// Create a triangle 

public class Triangle extends Geo {

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

        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    // Create accessor methods all 3 data fields
    // Create setter methods
    public void setSide1(double s1) {
        side1 = s1;
    }

    public void setSide2(double s2) {
        side2 = s2;
    }

    public void setSide3(double s3) {
        side3 = s3;
    }

    // Create getter methods
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // Create area method
    public double getArea() {
        return (0.5 * side1) *
    }
}
