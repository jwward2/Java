/*
*Description A simple calculator that stores continuous values
*/

import java.util.Scanner;

public class Simple-Calculator {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		String quit = "";
		String userFunction = "";

		String multiply = "*";
		String divide = "/";
		String subtract = "-";
		String add = "+";

		System.out.println("Please enter a real number: ");
		double userInput = scan.nextDouble();

		while (!userFunction.equals("q")) {

			System.out.printf("Please enter a function (ie *5) The value of the Number is currently %.2f type anything to continue\n", userInput);
			String userInput2 = scan2.nextLine();
			userFunction = userInput2.substring(0,1);
			if (!userFunction.equals("q")) {
				String userInputNumber1 = userInput2.substring(1);
				double userInputNumber2 = Double.parseDouble(userInputNumber1);

				if (userFunction.equals(multiply)) {
					userInput = (userInput * userInputNumber2);
				} else if (userFunction.equals(divide)) {
					userInput = (userInput / userInputNumber2);

				} else if (userFunction.equals(subtract)) {
					userInput = (userInput - userInputNumber2);

				} else if (userFunction.equals(add)) {
					userInput = (userInput + userInputNumber2);
				}

			}
		}
	}
}
