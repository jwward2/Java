/*
 * Description: This program calculates how many digits are in an integer that the user inputs.
 */

import java.util.Scanner;

public class Recursion
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		int number = 0;

		// Loop and get the user input until the user enters 0.
		do
		{
			System.out.println("Enter a number (0 to quit): ");
			number = input.nextInt();

			if (number != 0)
				System.out.println("The number of digits is " + countDigits(number));

			System.out.println();
		}
		while (number != 0);

		input.close();
	}

	public static int countDigits(int number)
	{
		// Implement the code for countDigits here

//Here I have initialized a counter variable that will keep track of how many times the number is divided (numDigits)

		int numDigits = 1;

//Here I have created numCheck to function as my division by ten variable, it will continue to divide number by ten
		int numCheck = number/10;

//Here I have created the base condition for the recursive method that states, when the division by ten is zero (there is one digit left)
// ,come back out of the method and return the counter variable (numDigits)
		if (numCheck == 0)
		{
			return numDigits;
		}
//If the base case is not met, my method will return the number of digits plus the recursive method again (ie. 1+method=2+method=3... until the division equals zero)
		else
		{
			return numDigits + countDigits(number/10);
		}

	}
}
