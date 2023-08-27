// M01 - Programming Assignment 3
// Compare two dimensional arrays

// Imports
import java.util.Scanner;
import java.util.Arrays;

public class CompareArrays {

	// Variables
	static Boolean islist1Valid = true;
	static Boolean islist2Valid = true;

	// Main method
	public static void main(String[] args) {

		// Get user input for first array
		System.out.print("Enter list1 (9 numbers): ");
		int[][] list1 = getList1Array();

		// Check if list1 is valid
		while (!islist1Valid) {
			islist1Valid = true;
			System.out.println("Wrong Entry. Enter 9 numbers. Try again");
			System.out.print("Enter list1 (9 numbers): ");
			list1 = getList1Array();
		}

        // Get user input for second array
		System.out.print("Enter list2 (9 numbers): ");
		int[][] list2 = getList2Array();

		// Check if list2 is valid
		while (!islist2Valid) {
			islist2Valid = true;
			System.out.println("Wrong Entry. Must be all numbers. Try again");
			System.out.print("Enter list2 (9 numbers): ");
			list2 = getList1Array();
		}
		
		// Check if the lists are identical or not
		if (Arrays.deepEquals(list1, list2)) {
			System.out.println("The two arrays are identical");
		} else {
			System.out.println("The two arrays are not equal");
		}
	}

	// Initializes list1 array from user input
	public static int[][] getList1Array() {

		Scanner input = new Scanner(System.in);		
		final int ROWS = 3;
		final int COLUMNS = 3;
		int[][] m = new int[ROWS][COLUMNS];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				try {
					m[i][j] = input.nextInt();
				} catch (Exception e) {
						islist1Valid = false;
				}
			}
		}
		return m;
	}

	// Initializes list2 array from user input
	public static int[][] getList2Array() {

		Scanner input = new Scanner(System.in);		
		final int ROWS = 3;
		final int COLUMNS = 3;
		int[][] m = new int[ROWS][COLUMNS];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				try {
					m[i][j] = input.nextInt();
				} catch (Exception e) {
						islist2Valid = false;
				}
			}
		}
		return m;
	}
}
