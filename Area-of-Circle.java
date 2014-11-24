/*
*Description: Area Calculations
*/

import java.util.Scanner;

public class Area-of-Circle {
	public static void main(String [] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a radius for circle one and press Enter:");
		double radius1 = scan.nextDouble();

		System.out.println("Please enter a radius for circle two and press Enter:");
		double radius2 = scan.nextDouble();

		System.out.println("Please enter a radius for circle three and press Enter:");
		double radius3 = scan.nextDouble();

		double area1 = Math.PI*Math.pow(radius1,2);
		double area2 = Math.PI*Math.pow(radius2,2);
		double area3 = Math.PI*Math.pow(radius3,2);

		System.out.println(" The areas are " + area1 + " and " + area2 + " and " + area3);
		System.out.println(" The average of these areas is " + ((area1+area2+area3)/3));
	}
}
