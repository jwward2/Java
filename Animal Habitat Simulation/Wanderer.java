/**
 * Name: Jacob Ward
 * Course: CSE 110
 * Lab Section: Section B
 * Date: April 28, 2013
 * Assignment: Programming Project 7 - Wanderer.java
 * Description: This class impliments a "wandering" creature that randomly moves forwards left and right about the board.
 */


public class Wanderer implements Critter
{
	/*
	 *
	 *This method returns the desired symbol for the Wanderer creature
	 *
	 *@return <char> this method returns a char type that will be put out to the terminal to show the motion of this creature
 	 */

	public char getChar()
	{
		return 'W';
	}

	/*
	 *This method uses the random package to create semi-random movements for the wanderer object through a series of if statements
	 *
	 *@param1 <front> this is the input for what is in front of the creature (a wall a creature, etc..)
	 *@param2 <back> this is the input that tells the creature what is behind it
	 *@param3 <left> this tells the creature what is to its left
	 *@param4 <right> this tells the creature what is to its right
	 *
	 *@return <Move> this method returns a "Move" that tells the creature where to go next.
	 *
	 */

	public Move getMove(Neighbor front, Neighbor back, Neighbor left, Neighbor right)
	{
		if (front == Neighbor.OTHER)
		{
			return Move.INFECT;
		}

		else if (Math.random() < .5)
		{
			if (Math.random() < .5)
			{
				return Move.LEFT;
			}

			else
			{
				return Move.RIGHT;
			}
		}

		else
		{
			return Move.HOP;
		}
	}
}