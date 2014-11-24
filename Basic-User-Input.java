/*
*Description User Input and Booleans
*/

import java.util.Scanner;

public class Basic-User-Input {
	public static void main(String [] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a series of text: ");
		String response1 = scan.nextLine();

		System.out.println("You typed: " + response1);

		System.out.println("Please enter a second series of text: ");
		String response2 = scan.nextLine();

		System.out.println("You typed: " + response2);

		int length1 = response1.length();
		int length2 = response2.length();

		boolean result = length1==length2;

		System.out.println("Result: True = the characters of each statement are equal, False = they are unequal in length: " + result);
	}
}

