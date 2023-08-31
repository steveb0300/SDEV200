// M02 - Programming Assignment 3
// Test BinaryFormatException
// Pass in a String and check it one char at a time to see if it is binary
// If it is binary, store it in a decimal number

public class TestBinaryFormatException {

	// Checks if String is a binaryString and if not throws an exception
	public static int bin2Dec(String binaryString) throws BinaryFormatException {

		// Initialize a decimal to store converted String
		int decimal = 0;

		// Loop through the String one charactor at a time and check if it is a zero or one
		for (int i = 0, j = binaryString.length() - 1; i < binaryString.length(); i++, j--) {

			// If not zero or one throw exception
			if (binaryString.charAt(i) < '0' || binaryString.charAt(i) > '1')
				throw new BinaryFormatException(binaryString);

			// Get the value of char by passing it into Integer.parseInt
			// Increment decimal using the Math.pow function to convert the binary number to a decimal number
			decimal += (Integer.parseInt(String.valueOf(binaryString.charAt(i)))) * Math.pow(2, j);
		}
		return decimal;
	} 
}
