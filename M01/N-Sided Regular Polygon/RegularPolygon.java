// M01 - Programming Assignment 4
// Design N-Sided Regular Polygon

public class RegularPolygon {

	// Variables
	private int n;
	private double side;
	private double x;
	private double y;

	// No-arg Constructor with default values
	RegularPolygon() {
		n = 3;
		side = 1;
		x = 0;
        y = 0;
	}

	// Constructor for regular polygon with number of sides and length
	RegularPolygon(int newNumSides, double newSideLength) {
		n = newNumSides;
		side = newSideLength;
		x = 0;
        y = 0;
	}

	// Constructor for regular polygon with number of sides, length,and x and y cordinate
	RegularPolygon(int newNumSides, double newSideLength, double newX, double newY) {
		n = newNumSides;
		side = newSideLength;
		x = newX;
		y = newY;
	}

	// Gets the perimeter of the polygon
	public double getPerimeter() {
		return side * n;
	}

	// Gets the area of the polygon
	public double getArea() {
		return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
	}
}
