// Jacob Pitts
// 01/22/02
//
// Food - A.K.A. Dead Meat
// When in doubt, blindly turn left.
//
// Extends the Critter interface, defining the getChar and getMove methods.


public class Food implements Critter
{
	// Returns a character identifier
	public char getChar() {
		return 'F';
	}

	// Decides what to do given some simple information
	public Move getMove(Neighbor front, Neighbor back, Neighbor left, Neighbor right) {
		// Left.
		return Move.LEFT;
	}
}