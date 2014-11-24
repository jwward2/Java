/*
* The method to perform the recursive search
*/

import java.util.Scanner;

public class Recursive-Search {
	public static void search(int value, int start, int end)
	{

		System.out.println("Searching between " + start + " and " + end);

		if (value == ((start+end)/2))
		{
			System.out.println("Number Found");
		}
		else if (value < ((start+end)/2))
		{
			end = ((start+end)/2);
			search(value, start, end);
		}
		else
		{
			search(value, ((start+end)/2)+1, end);
		}

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // instantiate a new Scanner to take user input
		int num = 0;

		/*
		 * The loop below executes until the user enters -1
		 */

		while(num!=-1)
		{
			System.out.print("Please enter a number: ");
			num = scan.nextInt(); // Take an integer input from the user

			if(num != -1) {

				int start = 0, end = 1000; // Give the initial search range
				search(num, start, end); // Begin the recursion

			}

		}
		scan.close();
	}

}
