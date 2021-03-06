/*
*Description Methods for two functions
*/

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		double userTime = 0;

		while (userTime != -1)
		{
			System.out.println("Please enter a speed for car 1 (miles/hour)");
			double userInput1 = scan.nextDouble();
			System.out.println();

			System.out.println("Please enter a speed for car 2 (miles/hour)");
			double userInput2 = scan.nextDouble();
			System.out.println();

			System.out.println("Please enter a time, or -1 to quit");
			userTime = scan.nextDouble();
			System.out.println();

			Car Car1 = new Car("Car1", userInput1);
			Car Car2 = new Car("Car2", userInput2);

			double distance1 = Car1.distanceTraveled(userTime);
			double distance2 = Car2.distanceTraveled(userTime);

			System.out.printf("Distance traveled by Car 1 is: %.2f Miles", distance1);
			System.out.println();

			System.out.printf("Distance traveled by Car 2 is: %.2f Miles", distance2);
			System.out.println();

		}
	}
}
