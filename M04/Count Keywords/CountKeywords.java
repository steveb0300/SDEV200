// M04 - Programming Assignment 2
// Exercise 21.3
// COUNT THE KEYWORDS IN JAVA SOURCE CODE

import java.util.*;
import java.io.*;

public class CountKeywords {
	public static void main(String[] args) throws Exception {
		
		// Check command line length
		if (args.length != 1) {
			System.out.println("No File in Argument");
			System.exit(1);
		}

		// Check if file exists and display keyword count
		File file = new File(args[0]);
		if (file.exists()) {
			System.out.println("The number of keywords in " + args[0] 
				+ " is " + countKeywords(file));
		}
		else {
			System.out.println("File " + args[0] + " does not exist");
		}
	}

	/** Method returns the keyword count */
	public static int countKeywords(File file) throws Exception {
		// Array of all Java Keywords + ture, false and null
		String[] keywordString = {"abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "char", "class", "const",
			"continue", "default", "do", "double", "else", "enum",
			"extends", "for", "final", "finally", "float", "goto",
			"if", "implements", "import", "instanceof", "int",
			"interface", "long", "native", "new", "package", "private",
			"protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this",
			"throw", "throws", "transient", "try", "void", "volatile",
			"while", "true", "false", "null"};

		Set<String> keywordSet = 
			new HashSet<>(Arrays.asList(keywordString));
		int count = 0;

		Scanner input = new Scanner(file);

		while (input.hasNext()) {
			String word = input.next();
			if (word.equals("//")) { // Don't count comments
				input.nextLine(); 
			}
			else if (word.contains("\"")) { // Don't count string
				String nextWord;
				do {
					nextWord = input.next();
				} while (!nextWord.contains("\""));
			}
			else if (word.contains("/*")) { // Don't count block comments
				String nextWord;
				do {
					nextWord = input.next();
				} while (!nextWord.contains("*/"));
			}
			else if (keywordSet.contains(word))
				count++;
		}

		return count;
	}
}
