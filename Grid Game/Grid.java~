/*
 * Description: This assignment will create a visual representation of a moving point that moves with user input.
 */

import java.util.Scanner;

public class Grid
{
	public void run()
	{
		// Here I have instantiated a new Scanner object named scan

		Scanner scan = new Scanner(System.in);

		// Here I have declared my variables that will be used to control the grid print out and user direction to allow for a wider scope

		int width = 0;
		int length = 0;
		String input = "";
		int userX = 1;
		int userY = 1;
		String userDirection = "";

// Here I am taking in user input for width and length and making sure that it is between 1 and 9, or else setting it to 1

			System.out.println("Please enter a width (1-9)");
			width = scan.nextInt();

			if (width < 1 || width > 9)
			{
				width = 1;
			}

			System.out.println("Please enter a length (1-9)");
			length = scan.nextInt();

			if (length < 1 || length > 9)
			{
				length = 1;
			}


		userDirection = scan.nextLine();

// Here I have created a while loop, that runs until "q" and will serve as the main loop for my program

		while (!userDirection.equals("q"))
			{

/* Here I have created a series of nested for loops that are dependent upon the users width and length, and is related to a two dimensional
cordinate variable called userX and userY that is compared to the counters, i and j. When the counters are equal to the userX and userY,
the program will print an X instead of *, this system function likes a printer that goes along each point one by one and checks its position
using userX and userY
*/

				for (int i = 1; i <= width; i++)
				{
					for (int j = 1; j <= length; j++)
					{
						if (userX == j && userY == i)
						{
							System.out.print(" X ");
						}
						else
						{
							System.out.print(" * ");
						}
					}

					System.out.println();
					System.out.println();
				}

// Here I am taking in the user's input for a direction while also printing out there current position using the x and y counter variables

				System.out.println("Your position is (" + (userX-1) + " , " + (userY-1) + ")");
				System.out.println("Please enter a direction");
				userDirection = scan.nextLine();

// Here I have created a series of if, else if, statements that will check the user's input againts different movements

				if (userDirection.equals("right"))
					{

// This moves the point right by increasing its x position variable by one

						userX = (userX + 1);
					}
				else if (userDirection.equals("left"))
					{

// This works similarly by subtracting one

						userX = (userX - 1);
					}
				else if (userDirection.equals("up"))
					{

// Given my grid system, to go up I must subtract one

						userY = (userY - 1);
					}
				else if (userDirection.equals("down"))
					{

// This moves the point down by increasing its distance by one

						userY = (userY + 1);
					}
				else if (userDirection.equals("q"))
				{
				}
				else if (userDirection.equals(""))
				{
				}
				else
					{
						System.out.println("Error: Please enter a direction");
					}

// This series creates the wrapping motion around the grid

				if (userX > length)
					{

// This case evaluates if the x position is being moved beyond the max length and resets it to one

						userX = 1;
					}
				if (userX < 1)
					{

// SImilarly this checks to see if the position is trying to be moved negatively and sets the counter to the max length

						userX = length;
					}
				if (userY > width)
					{
						userY = 1;
					}
				if (userY < 1)
					{
						userY = width;
					}

				}
			}
		}
