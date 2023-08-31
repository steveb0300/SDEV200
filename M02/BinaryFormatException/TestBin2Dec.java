// M02 - Programming Assignment 3
// Test Bin2Dec
// Takes user input and passes it through another class to check if it is binary
// If it is not binary, it will throw an exception

import java.text.Format;
import java.util.Scanner;

public class TestBin2Dec {
	public static void main(String[] args) {
		// Create a Scanner to capture user input
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a binary string
		System.out.print("Enter a binary: ");

        // Check the user input and throw exception if improper entry
		try {
			// Output the result of input.nextLine called by TestBinaryFormatException bin2Dec method
			// if the input is valid
			System.out.println("Decimal Value: " + TestBinaryFormatException.bin2Dec(input.nextLine()));
		}
		catch (NumberFormatException ex) {
			// Output the error message
			System.out.println(ex.getMessage());
		}
	}
}