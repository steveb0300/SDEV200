// M02 - Programming Assignment 01
// Create My Date class

import java.util.Calendar;

// Create MyDate class
public class MyDate {

	// Variables
	private int year;
	private int month;
	private int day;

	// Constructor for current date
	MyDate() {
		Calendar calander = Calendar.getInstance();
		year = calander.get(Calendar.YEAR);
		month = calander.get(Calendar.MONTH);
		day = calander.get(Calendar.DAY_OF_MONTH);
	}

	// Constructor with a specified elapsed time since Jan 1, 1970 in milliseconds
	MyDate(long elapsedTime) {
		setDate(elapsedTime);
	}

	// Constructor for specified year, month, and day
	MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// Getter for year
	public int getYear() {
		return year;
	}

	// Getter for month
	public String getMonth() {

		// Create a string from month. Add one to offset 0 index
		String m = String.valueOf(month + 1);

		// Check if month is < 9 and not 10 due to 0 index
		// If month is < 9, add 0 to all single digit months else month
		return (month < 9 ? "0" + m : m);
	}

	// Getter for day
	public String getDay() {

		// Create a string from day 
		String d = String.valueOf(day);

		// If day is less 10, add 0 to all single digits else day
		return (day < 10 ? "0" + d : d);
	}

	// Sets date with elapsed time
	public void setDate(long elapsedTime) {
		Calendar calander = Calendar.getInstance();
		calander.setTimeInMillis(elapsedTime);
		year = calander.get(Calendar.YEAR);
		month = calander.get(Calendar.MONTH);
		day = calander.get(Calendar.DAY_OF_MONTH);
	} 
}
