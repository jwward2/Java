/*
 * Description: This class creates the Game Piece that keeps track of the place on the board and keeps track of movement along the board
 */

 public class GamePiece
 {
	private int currentSpace;

	/*
	 *This method is the constructor that sets the position of the piece off the board
	 */

	public GamePiece()
	{
		currentSpace = 0;
	}

	/*
	 *This method updates the space of the game piece by taking in a value and updating the currentSpace position
	 *
	 *@param <numberOfSpaces> This param. is an integer that enters the method and is added to the current position to simulate movement
	 */

	public void move(int numberOfSpaces)
	{
		currentSpace = currentSpace + numberOfSpaces;
	}

	/*
	 *This method takes in an integer that represents the positions place and sets the param. to the currentSpace variable.
	 *
	 *@param <currentSpace> This param. represents the set position of the piece in relation to the spaces on the board.
	 *
	 */

	public void setCurrentSpace(int currentSpace)
	{
		this.currentSpace = currentSpace;
	}

	/*
	 *This method allows the user to find the current position of the piece
	 *
	 *@return This method returns the int value that relates to the current position of the piece
	 *
	 */

	public int getCurrentSpace()
	{
		return this.currentSpace;
	}
 }
