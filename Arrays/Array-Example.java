/*
*Description: Simple array of integers example
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Array-Example {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("input.txt"));

		int[] arr = new int[10];
		for(int i=0; i < 10; i++) {
			arr[i] = scan.nextInt();
		}

		Arrays arrayObject = new Arrays();
		arrayObject.setArray(arr);

		System.out.println("The array is ");
		arrayObject.printArray();
		System.out.println();
		int userInput = -1;
		Scanner scan2 = new Scanner(System.in);
		do {
			System.out.println("Select one of the following operations!");
			System.out.println("1 - Search Number in array");
			System.out.println("2 - Add Number to specified index");
			System.out.println("3 - Find the largest number in array");
			System.out.println("4 - Quit");

			userInput = scan2.nextInt();
			if(userInput == 1) {
				System.out.print("Enter the number to be searched: ");
				int number = scan2.nextInt();
				int pos = arrayObject.search(number);
				System.out.println("Number " + number + " found at position " + pos);
			}
			else if(userInput == 2) {
				System.out.print("Enter the index: ");
				int index = scan2.nextInt();
				System.out.print("Enter the number: ");
				int number = scan2.nextInt();
				arrayObject.addToArray(number, index);
				System.out.println("The array after adding the number is");
				arrayObject.printArray();
				System.out.println();
			}
			else if(userInput == 3) {
				System.out.println("The largest number in the array is " + arrayObject.findLargest());
			}

		}while(userInput != 4);

	}

}
