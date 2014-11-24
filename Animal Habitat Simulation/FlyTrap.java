// Jacob Pitts
// 01/22/02
//
// FlyTrap - The deadly proximity bomb!
// If a critter lies in front, INFECT!  Otherwise, rotate left.
//
// Extends the Critter interface, defining the getChar and getMove methods.


public class FlyTrap implements Critter
{
	// Returns a character identifier
	public char getChar() {
		return 'T';
	}

	// Decides what to do given some simple information
	public Move getMove(Neighbor front, Neighbor back, Neighbor left, Neighbor right) {
		// What's in front?  A CRITTER?!?
		if ( front == Neighbor.OTHER )
			return Move.INFECT;
		else
			return Move.LEFT;
	}
}