/*
*Description: register program using user input and the scanner import
*/

import java.util.Scanner;

public class Merchant
{
	public void buy()
	{
//Here I have instantiated a new scanner variable called scan

		Scanner scan = new Scanner(System.in);

//Here I have printed out a prompt to the user and used the scan method on the scan variable to read the next line and store it as a string

		System.out.println("Please enter your order (a maximum of 9 please) in the form of:A(quantity) B(quantity ...and so on: ");
		String userInput = scan.nextLine();

//Here I am using the static method getNumericValue from the Character class to get the quantity portion of the user input and store it.

		int numberA = Character.getNumericValue(userInput.charAt(1));
		int numberB = Character.getNumericValue(userInput.charAt(4));
		int numberC = Character.getNumericValue(userInput.charAt(7));
		int numberD = Character.getNumericValue(userInput.charAt(10));

//Here I am establishing the prices of each item as a variable labled price(Item) as a double due to the decimal.

		double priceA = 32.24;
		double priceB = 15.28;
		double priceC = 12.92;
		double priceD = 20.99;

//Here I am using the quantity from the getNumericValue and the above price variables to calculate the cost of each item ordered.

		double costA = priceA * numberA;
		double costB = priceB * numberB;
		double costC = priceC * numberC;
		double costD = priceD * numberD;

//Here I am using the above calculations of each individual item to calculate the total as a double to keep precision.

		double subtotal = costA + costB + costC + costD;

//Here I have declared the taxRate variable given in the instructions.

		double taxRate = .095;

//Here I am calculating the tax by using the taxrate and the subtotal

		double totalTax = taxRate * subtotal;

//Here I have used the total tax and the subtotal to calculate the total price

		double totalPrice = totalTax + subtotal;

/*Here I used a combination of println and printf with concatenation, escape characters, and place holders set to 2 decimal places
*to structure the rows and colums of data out to the terminal
*/

		System.out.println("Jake's Sport Place Order Form\n");
		System.out.println("ITEM\tPRICE\tQUANTITY\tTOTAL PRICE");
		System.out.printf("A\t32.24\t%d\t\t%.2f\n", numberA, costA);
		System.out.printf("B\t15.28\t%d\t\t%.2f\n", numberB, costB);
		System.out.printf("C\t12.92\t%d\t\t%.2f\n", numberC, costC);
		System.out.printf("D\t20.99\t%d\t\t%.2f\n\n", numberD, costD);
		System.out.printf("Subtotal: %.2f\n", subtotal);
		System.out.printf("Sales Tax: %.2f\n", totalTax);
		System.out.printf("Total Price: %.2f\n", totalPrice);
	}
}
