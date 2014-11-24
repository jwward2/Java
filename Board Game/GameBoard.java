/**
 * Name: Jacob Ward
 * Course: CSE 110
 * Lab Section: Lab Section B
 * Date: April 3, 2013
 * Assignment: Programming Project 5 - GameBoard
 * Description: This class creates the visual gameboard, creates the objects associated with the game, and runs the game's rules.
 */

 public class GameBoard
 {
	private int numSpaces;

	private GamePiece playerPiece;

	private Die dieOne;

	private Die dieTwo;


	/*
	 *This method is the base constructor that creates the game objects and sets a base value for numSpaces
	 */

	public GameBoard()
	{
		dieOne = new Die();
		dieTwo = new Die();

		playerPiece = new GamePiece();

		numSpaces = 15;
	}

	/*
	 *This method is the other constructor that functions like the previous GameBoard method, but allows the user to set numSpaces
	 *
	 *@param <numSpaces> This param allows the method to set the numSpaces of the board to a specific value
	 *
	 */

	public GameBoard(int numSpaces)
	{
		this.numSpaces = numSpaces;

		dieOne = new Die();
		dieTwo = new Die();

		playerPiece = new GamePiece();
	}

	/*
	 * This method returns the number of spaces the Gameboard object has
	 *
	 *@return This method returns an int value that relates to the number of "spaces" the board has
	 *
	 */

	public int getNumSpaces()
	{
		return this.numSpaces;
	}

	/*
	 *This method helps the program check to see if the game is over by comparing the position to the number of spaces
	 *
	 *@return This method returns a boolean statement that either ends the game "true" or starts another round "false"
	 *
	 */

	private boolean checkFinished()
	{
		if (playerPiece.getCurrentSpace()>numSpaces)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/*
	 *This method uses a for loop to print out a visual of the game board
	 *
	 */

	public void displayGameBoard()
	{
		int currentSpace = playerPiece.getCurrentSpace();

		for (int i = 1; i <= numSpaces; i++)
		{
			if(currentSpace == i)
			{
				System.out.print(" X ");
			}
			else
			{
				System.out.print(" * ");
			}
		}

		System.out.println("");
	}

	/*
	 *This method is the main component of the game itself and calls the methods associated with GameBoard to actually roll dice,
	 * move the piece, print a new visual board, count the rounds, and check if the game is complete.
	 *
	 */

	public void play()
	{
		//These variables count the number of rounds the game took and the current turn the player is on

		int rounds = 0;
		int turn = 1;

		while (checkFinished() == false)
		{
			System.out.println("");
			System.out.println("Turn: " + turn);
			System.out.println("");

			int one = dieOne.roll();
			int two = dieTwo.roll();
			int spaces = one + two;

			System.out.println("Die one showed: " + one);
			System.out.println("Die two Showed: " + two);
			System.out.println("");
			System.out.println("The total is: " + spaces);
			System.out.println("");

			//This code takes the above die rolls and moves the playerpiece according to the int value of each die summed

			playerPiece.move(spaces);
			displayGameBoard();

			turn = turn + 1;
			rounds = rounds + 1;
		}

		System.out.println("");
		System.out.println("It took " + rounds + " rounds to complete the game.");
	}

 }