/*
 * Description: This program will simulate a game of rock paper scissors using methods to create players, generate gestures, and keep score.
 */

// Here I have imported the necessary methods from the util package to take in user input and create numbers(gestures) for the computer.

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors
{
	/**
	 * This method runs the game by taking in user input and using methods to compare the different gestures while keeping score
	 */
	public static void play()
	{
//Here I have created a scanning object to take in input
		Scanner scan = new Scanner(System.in);

//Here I have initialized variables to keep score
		int computerScore = 0;
		int playerScore = 0;
//Here I have created names for the players
		String player1 = "Player 1";
		String player2 = "Computer";

//Here I have created a variable to keep track of the player's selected gesture
		int selection = 0;

//Here I have created a loop that will run the game until the user quits
		do
		{

//Here I have called the menu method to print out the menu

			menu();
			System.out.println();

//Here I am taking in the user's input and storing it as the player's gesture selection
			selection = scan.nextInt();

//Here I have called the generateGesture method and stored the computer's number into a gesture selection variable
			if (selection != -1)
			{
				int computerSelection = generateGesture();

//Here I have called the printGesture method to display the player's names and choices
				System.out.println();
				printGesture(player1, selection);
				printGesture(player2, computerSelection);
				System.out.println();

//Here I have created result, to store the decision found by the resolveRound method
				int result = resolveRound(selection, computerSelection);

//Here I have created an if else if statement that keeps track of the score by using the result variable to check which player won
				if (result == 1)
				{
					playerScore = playerScore + 1;
				}
				else if (result == -1)
				{
					computerScore = computerScore + 1;
				}

	//Here I have printed out the updating scores for each player
				System.out.println();
				System.out.println("Player Score is: " + playerScore);
				System.out.println("Computer Score is: " + computerScore);
				System.out.println();
			}
		}
		while (selection != -1);
		scan.close();
	}


/*
 *This method prints out a menu for the different gestures a player can make
 *
 */
	public static void menu()
	{
		System.out.println("1) show ROCK");
		System.out.println("2) show PAPER");
		System.out.println("3) show SCISSORS");
		System.out.print("Enter a selection (-1 to quit)");
		System.out.println();
	}

/*
 *This method prints out the players name and the players selected gesture so the players can "visualize" the game.
 *
 *@param <playerName> <This takes in the string for the player's name, such as computer, and displays it>
 *@param <gesture> <This parameter corrilates to the menu method and the player's selected gesture (ie. gesture-1=rock)
 *
 */

	public static void printGesture(String playerName, int gesture)
	{
//Here I am using if statements to check which gesure the player used and I am printing it out using concantination
		if (gesture == 1)
		{
			System.out.println(playerName + " shows ROCK");
		}

		else if (gesture == 2)
		{
			System.out.println(playerName + " shows PAPER");
		}

		else if (gesture == 3)
		{
			System.out.println(playerName + " shows SCISSORS");
		}

	}

/*
 * This method compares the player's gestures to see which player won the game.
 *
 *@param <player1gesture> <This parameter takes in an integer that corrilates to a gesture and compares it to the other parameter>
 *@param <player2gesture> <This parameter takes in an integer that corrilates to a gesture and compares it to the previous parameter>
 *
 *@return <This method returns an integer value that corrilates to win, lose, or tie. (1=player 1 wins, 0=tie...etc)>
 *
 */

	public static int resolveRound(int player1Gesture, int player2Gesture)
	{
//Here I have created a variable, result, to reduce the amount of returns I need in the method.

//This series of if statements compares the player's gestures, according to the rules of the game, and stores a value in result.
		int result = 0;

		if (player1Gesture == player2Gesture)
		{
			result = result;
		}
		else if (player1Gesture == 1 && player2Gesture == 2)
		{
			result = -1;
		}
		else if (player1Gesture == 1 && player2Gesture == 3)
		{
			result = 1;
		}
		else if (player1Gesture == 2 && player2Gesture == 1)
		{
			result = 1;
		}
		else if (player1Gesture == 2 && player2Gesture == 3)
		{
			result = -1;
		}
		else if (player1Gesture == 3 && player2Gesture == 2)
		{
			result = 1;
		}
		else if (player1Gesture == 3 && player2Gesture == 1)
		{
			result = 1;
		}
		return result;
	}

/*
 *This method uses a random number generator to "create" the computer's gesture selection
 *
 *@return <This method returns a randomly generated number that corrilates to the computer's selection>
 *
 */

	public static int generateGesture()
	{
//Here I have created a random number object that creates a number between one and three and returns that number
		Random random = new Random();
		int number = random.nextInt(3);
		number++;

		return number;
	}
}
