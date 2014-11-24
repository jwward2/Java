/*
*Description: This class is the main driver that asks the user for the paths of two files, checks to see if they exist, and reformats them.
*/

import java.util.Scanner;

public class File-Example {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		FileHandler handler = null;
		System.out.print("Enter the name of input file: ");
		String inputFileName = scan.next();

		System.out.print("Enter the name of output file: ");
		String outputFileName = scan.next();

		if(!isNullOrEmpty(inputFileName) && !isNullOrEmpty(outputFileName))
		{
			handler = new FileHandler();
		}


		try
		{
			handler.copyFile(inputFileName, outputFileName);
		}

		catch(NullPointerException e)
		{
			System.out.println("Error: "+ e.getMessage());
		}


	}

	private static boolean isNullOrEmpty(String input) {
		if(input == null || input.trim().equals(""))
		{
			return true;
		}
		return false;
	}

}
