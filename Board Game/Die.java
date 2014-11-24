/**
 * Name: Jacob Ward
 * Course: CSE 110
 * Lab Section: Lab Section B
 * Date: April 3, 2013
 * Assignment: Programming Project 5 - Die
 * Description: This class creates the Die objects that will determine how many places a player moves.
 */

 import java.util.Random;

 public class Die
 {
	private int faceValue;

	Random random = new Random();

	/*
	 *This method is the base constructor that sets the die value to one
	 */

	public Die()
	 {
		 faceValue = 1;
	 }

	/*
	 * This method uses a random generator to give the face value of the die a number between 1 and 6
	 *@return This method returns an integer value that is set to the face value of the die
	 */

	public int roll()
	{
		faceValue = random.nextInt(6);
		faceValue++;
		return faceValue;
	}

	/*
	 *This method is a getter method for the facevalue of the die
	 *@return This method returns the int value currently stored in the face value of the die
	 */

	public int getFaceValue()
	{
		return this.faceValue;
	}
}