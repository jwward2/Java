/*
*Description: Methods for factorial and area of triangles
*/

import java.util.Scanner;

public class Factorial-and-Area-Calculator {
	public static void main(String[] args)
	{
		String function = "";

		while (!function.equals("q"))
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter a function (factorial or area) or q to quit");
			function = scan.nextLine();

			if (function.equals("factorial"))
			{
				System.out.println("Please enter a number");
				int userNum = scan.nextInt();
				System.out.println("Your result is " + factorial(userNum));
			}
			if (function.equals("area"))
			{
				System.out.println("Please enter a width");
				int width = scan.nextInt();
				System.out.println("Please enter a length");
				int length = scan.nextInt();
				System.out.println("Your result is " + area(width, length));

			}
		}
	}

	public static int factorial(int num1)
	{
		int fact = 1;
		for (int i = 1; i <= num1; i++)
		{
			fact = (fact * i) ;
		}
		return fact;
	}
	public static int area(int num1, int num2)
	{
		int area = num1 * num2;
		return area;
	}
}
