// M02 - Programming Assignment 2
// Create two rational numbers 

import java.math.BigInteger;
import java.util.Scanner;

public class RunRational {
	
	public static void main(String[] args) {

		// Create scanner to capture user input
		Scanner input = new Scanner(System.in);

		// Prompt user to enter first rational number
		System.out.print("Enter the first rational number: ");
		BigInteger rationalOneNumerator = input.nextBigInteger();		
		BigInteger rationalOneDenominator = input.nextBigInteger();

		// Prompt user to enter second rational number
		System.out.print("Enter the second rational number: ");
		BigInteger rationalTwoNumerator = input.nextBigInteger();		
		BigInteger rationalTwoDenominator = input.nextBigInteger();

		// Close Scanner
		input.close();
		
		// Create two rational numbers rationalOne and rationalTwo
		Rational rationalOne = new Rational(rationalOneNumerator, rationalOneDenominator);
		Rational rationalTwo = new Rational(rationalTwoNumerator, rationalTwoDenominator);

		// Display results using methods from Rational classs
		System.out.println(rationalOne + " + " + rationalTwo + " = " + rationalOne.add(rationalTwo));
		System.out.println(rationalOne + " - " + rationalTwo + " = " + rationalOne.subtract(rationalTwo));
		System.out.println(rationalOne + " * " + rationalTwo + " = " + rationalOne.multiply(rationalTwo));
		System.out.println(rationalOne + " / " + rationalTwo + " = " + rationalOne.divide(rationalTwo));
		System.out.println(rationalTwo + " is " + rationalTwo.doubleValue());
	}
}
