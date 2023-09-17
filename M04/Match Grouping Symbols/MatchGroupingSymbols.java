// M04 - Programming Assignment 1
// Exercise 20.11
// Write a program to check whether a Java source-code file has correct pairs of grouping symbols.

import java.io.*;
import java.util.*;

public class MatchGroupingSymbols {
	public static void main(String[] args) throws IOException {
        
		// Check command-line argument
		if (args.length != 1) {
			System.out.println("No File in Argument");
			System.exit(0);
		}

		// Check if file exists
		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("The file " + args[0] + " does not exist!");
			System.exit(1);
		}

		// Create a stack
		Stack<Character> symbols = new Stack<>();

		try ( // Create an input stream for file
				Scanner input = new Scanner(file);
		) {
			// Continuously read chars from input
			while (input.hasNext()) {
				String line = input.nextLine();
				for (int i = 0; i < line.length(); i++) {
					char ch = line.charAt(i);
					// Push symbols (, {, and [ on to the stack
					if (ch == '(' || ch == '{' || ch == '[') {
						symbols.push(ch);
					} // Process stack
					else if (ch == ')' || ch == '}' || ch == ']') {
						processSymbols(symbols, ch);
					}
				}
			}
		}
		
		System.out.println("The Java source-code " +
			(symbols.isEmpty() ? "has" : "does not have") + " correct pairs.");	
	}

	// Method Matchs grouping symbols
	private static void processSymbols(
			Stack<Character> stack, Character ch) {
		// Remove matching symbols from stack
		if ((stack.peek() == '(' && ch == ')') ||
			 (stack.peek() == '[' && ch == ']') ||
			 (stack.peek() == '{' && ch == '}')) {
			stack.pop();	
		}
		else if ((stack.peek() != '(' && ch == ')') ||
			 (stack.peek() != '[' && ch == ']') ||
			 (stack.peek() != '{' && ch == '}')) {
			System.out.println("The Java source-code does not have" 
				+ " correct pairs.");
			System.exit(1);
		}
	}
}