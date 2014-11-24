/*
*Description Infinite loop of random numbers
*/

import java.util.Scanner;
import java.util.Random;

public class Magic-Eight-Ball {
	public static void main(String[] args) {

		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		String quit = "";

		while (!quit.equals("q")) {

			int myNumber = random.nextInt(6);
			myNumber++;
			if (myNumber == 1) {
				System.out.println("Your number is 1: you are number 1!");
			} else if (myNumber == 2) {
				System.out.println("Your number is 2: you will have a great day!");
			} else if (myNumber == 3) {
				System.out.println("Your number is 3: you are in for good luck!");
			} else if (myNumber == 4) {
				System.out.println("Your number is 4: you have bad luck!");
			} else if (myNumber == 5) {
				System.out.println("Your number is 5: watch your back!");
			} else {
				System.out.println("Your number is 6: drink lots of water...it's going to get warm!");
			}


			System.out.print("Type anything to continue, or q to quit: ");
			quit = scan.next();
		}
	}
}
