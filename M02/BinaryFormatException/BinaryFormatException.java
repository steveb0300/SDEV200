// M02 - Programming Assignment 3
// BinaryFormatException is an extension of NumberFormatException which checks if a String contains a number
// BinaryFormatException goes one step further and checks if the String is binary (ones and zeros only)

public class BinaryFormatException extends NumberFormatException {

    // Variables
	private String binaryString;

	// Create a BinaryFormatException object
	public BinaryFormatException(String binaryString) {

		// Pass the error message to the super class to output the message
		super(binaryString + " is not a binary string");
		this.binaryString = binaryString;
	}

	// Create getter for BinaryString
	public String getBinaryString() {
		return binaryString;
	}
}