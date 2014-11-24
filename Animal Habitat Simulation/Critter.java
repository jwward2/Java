//Stuart Reges
//1/26/01
//
// The Critter interface specifies the two methods a class must
// implement to be able to participate in the critter simulation
//
// 1) getChar()should return a character that will be used for
//    displaying the Critter in the window, and the
//
// 2) getMove method should return a legal move given the current neighbors.
//
// The move should be specified using Move.HOP, Move.LEFT, Move,RIGHT,
// or Move.INFECT.
//
// The four parameters to getMove specify what neighbors the critter:
// These choices are Neighbor.WALL, Neighbor.EMPTY, Neighbor.SAME, or
// Neighbor.OTHER
public interface Critter {

	// The character that will represent this Critter in the GUI
	public char getChar();

	// The strategy employed for making a move
	public Move getMove(Neighbor front, Neighbor back, Neighbor right, Neighbor left);
}
