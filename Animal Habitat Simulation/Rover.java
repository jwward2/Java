// Jacob Pitts
// 01/22/02
//
// Rover - The Termites of CritterLand!
// If a critter lies in front, INFECT!  If it can move forward, hop,
// otherwise randomly move right or left.
//
// Extends the Critter interface, defining the getChar and getMove methods.


public class Rover implements Critter
{
	// Returns a character identifier
	public char getChar()
	{
		return 'R';
	}

	// Decides what to do given some simple information
	public Move getMove( Neighbor front, Neighbor back, Neighbor left, Neighbor right )
	{
		// What's in front?  A Wall?
		if ( front == Neighbor.WALL || front == Neighbor.SAME )
		{
			if ( Math.random() < .5 )
				return Move.LEFT;
			else
				return Move.RIGHT;
		}
		else if ( front == Neighbor.OTHER )
			return Move.INFECT;
		else
			return Move.HOP;
	}
}