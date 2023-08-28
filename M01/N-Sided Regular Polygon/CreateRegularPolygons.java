// M01 - Programming Assignment 4
// Run test program of RegularPolygon 

public class CreateRegularPolygons {
	/** Main method */
	public static void main(String[] args) {

		// Create three RegularPolygon objects
		RegularPolygon regularPolygon1 = new RegularPolygon();
		RegularPolygon regularPolygon2 = new RegularPolygon(6, 4);
		RegularPolygon regularPolygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

		// Display perimeter and area of each object
		System.out.printf("Polygon 1 Parameter: %.2f, Area: %.2f\n", regularPolygon1.getPerimeter(), regularPolygon1.getArea());
		System.out.printf("Polygon 1 Parameter: %.2f, Area: %.2f\n", regularPolygon2.getPerimeter(), regularPolygon2.getArea());
		System.out.printf("Polygon 1 Parameter: %.2f, Area: %.2f\n", regularPolygon3.getPerimeter(), regularPolygon3.getArea());
	}
}
