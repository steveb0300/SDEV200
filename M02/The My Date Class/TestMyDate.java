// M02 Programming Assignment 1
// Test the MyDate class

public class TestMyDate {

	public static void main(String[] args) {

		// Create two MyDate objects for testing
		MyDate date1 = new MyDate();
		MyDate date2 = new MyDate(34355555133101L);
        
        // Out to terminal 
		System.out.println("Date1: " + date1.getMonth() + "/" + date1.getDay() + "/" + date1.getYear());
		System.out.println("Date2: " + date2.getMonth() + "/" + date2.getDay() + "/" + date2.getYear());
	}
}