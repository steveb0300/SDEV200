// M02 - Programming Assignment 2
// Circle class that extends GeometricObject

// KEY NOTES HERE
// Class extends GeometryObject to utilize its methods
// Class implements Comparable<Circle> to complare object of the same class with an instance of that class
public class Circle extends GeometricObject implements Comparable<Circle> {
	private double radius;

    // Circle method
	public Circle() {
	}

    // Circle method with radius
	public Circle(double radius) {
		this.radius = radius;
	}

    // Circle method with radius, color, and filled
	public Circle(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	// Gets the radius
	public double getRadius() {
		return radius;
	}

	// Sets the radius
	public void setRadius(double radius) {
		this.radius = radius;
	}

    // Overrides GeometryObject and gets area
	@Override 
	public double getArea() {
		return radius * radius * Math.PI;
	}

	// Gets diameter
	public double getDiameter() {
		return 2 * radius;
	}

    // Overrides GeometryObject and gets perimeter
	@Override 
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

    // Overrides GeometryObject and compares objects
	@Override 
	public boolean equals(Object obj) {
		return this.compareTo((Circle)obj) == 0;
	}

    // Overrides GeometryObject and compares radi
	@Override 
	public int compareTo(Circle obj) {
		if (this.radius > obj.radius)
			return 1;
		else if (this.radius < obj.radius)
			return -1;
		else
			return 0;
	}

    // Overrides GeometryObject and forms string of date and radius
	@Override
	public String toString() {
		return super.toString() + "\nCircle Created" +
			"\nRadius: " + radius;
	}
}
