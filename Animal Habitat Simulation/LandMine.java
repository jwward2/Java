// Jacob Pitts
// 01/22/02
//
// LandMine - The lazy sun of a gun!
// If a critter lies in front, INFECT!  Otherwise, INFECT!  (Turn if it's a wall.)
//
// Extends the Critter interface, defining the getChar and getMove methods.


public class LandMine implements Critter
{
	// Returns a character identifier
	public char getChar() {
		return 'L';
	}

	// Decides what to do given some simple information
	public Move getMove(Neighbor front, Neighbor back, Neighbor left, Neighbor right) {
		// What's in front?  A Wall?
		if ( front == Neighbor.WALL )
			return Move.LEFT;
		else
			return Move.INFECT;
	}
}