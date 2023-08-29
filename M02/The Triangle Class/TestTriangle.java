// M02 - Programming Assignment 2
// Test Program of Triangle class

import java.util.Scanner;

public class TestTriangle {
	public static void main(String[] args) {

		// Create scanner to capture user input
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter three sides of the triangle
		System.out.print("Enter three side of the triangle: ");
		double side1 = input.nextDouble();		
		double side2 = input.nextDouble();		
		double side3 = input.nextDouble();

		// Prompt the user to enter a color
		System.out.print("Enter a color: ");
		String color = input.next();

		// Prompt the user for boolean value to indicate whether the trianble is filled
		System.out.print("Is triangle filled (true / false)? ");
		boolean filled = input.nextBoolean();

		// Create a triangle using the Triangle class with three side lengths from user input
		Triangle triangle = new Triangle(side1, side2, side3);

        // Set the triangle color from user input
		triangle.setColor(color);

        // Set the triangle filled boolean from the user input
		triangle.setFilled(filled);

        // Output to terminal the triangles properties
		System.out.println("Area: " + triangle.getArea());
		System.out.println("Perimeter: " + triangle.getPerimeter());
		System.out.println("Color: " + triangle.getColor());
		System.out.println("Triangle is" + (triangle.isFilled() ? "" : " not ") + "filled");
	}
}