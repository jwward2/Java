/**
 * Name: Jacob Ward
 * Course: CSE 110
 * Lab Section: Section B
 * Date: April 28, 2013
 * Assignment: Programming Project 7 - Porcupine.java
 * Description: This class creates a "Bee" creature that stings from behind while flying around randomly creating "hives"
 *
 * This class is supposed to simulate one of the cutest and dangerous animals out there; the porcupine.
 * The idea behind this class was to simply create something that infected from all sides and didn't move much. This stemmed from the
 * fly trap idea that won the "game" every time. All in all I wanted something that had defenses from all sides and did not concern
 * itself with speed or fancy movements, but that kept out of the war zones and was only acting in defence. There for, I made it inect
 * from all sides and simply move forwards until it hit a wall. This is supposed to seem like a little porcupine walking around for food
 * until it reaches the end of its habitat and decides to look else were. This class is short, sweet, and to the POINT with simple movements.
 */

public class Porcupine implements Critter
{
	/*
	 *This method returns the symbol that will represent the creature in the terminal.
	 *
	 *@return <char> this return is the char symbol that will show up on the screen in the simulation.
	 */

	public char getChar()
	{
		return '*';
	}

	/*
	 *This method dictates the movements of the porcupine creatures
	 *
	 *@param1 <front> this tells the creature what is in front of it
	 *@param2 <back> this tells the creature what is behind it
	 *@param3 <left> this tells the creature what is to its left
	 *@param4 <right> this tells the creature what is to its right
	 *
	 *@return <Move> this tells the creature were and what to do next
	 */

	public Move getMove(Neighbor front, Neighbor back, Neighbor left, Neighbor right)
	{
		if (back == Neighbor.OTHER)
		{
			return Move.INFECT;
		}
		if (front == Neighbor.OTHER)
		{
			return Move.INFECT;
		}
		if (left == Neighbor.OTHER)
		{
			return Move.INFECT;
		}
		if (right == Neighbor.OTHER)
		{
			return Move.INFECT;
		}

		else
		{
			return Move.HOP;
		}
	}
}