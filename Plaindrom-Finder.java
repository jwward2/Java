/*
*Description Palindrom finder
*/

import java.util.Scanner;

public class Palindrom-Finder {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String quit = "";

		System.out.println("Type a word or q to quit: ");
		quit = scan.next();

		while (!quit.equals("q") && !quit.equals("")) {

			String reverse = "";

			for (int i = quit.length() - 1; i >=0; i--){
				reverse = reverse + quit.charAt(i);
			}

			if (quit.equals(reverse)){
				System.out.println("\nYour word is:\n" + quit);
				System.out.println("\nYour reverse word is:\n" + reverse);
				System.out.println("\nYour word is a Palindrom\n");
			}
			else{
				System.out.println("\nYour word is\n:" + quit);
				System.out.println("\nYour reverse word is:\n" + reverse);
				System.out.println("\nYour word is not a Palindrom\n");
			}

		System.out.println("\nType a word or q to quit: ");
		quit = scan.next();

		}
	}
}
