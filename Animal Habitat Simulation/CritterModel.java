import java.util.Hashtable;

//Stuart Reges
//1/26/00
//
//Class CritterModel keeps track of the state of the critter simulation.

enum Neighbor {
	// Surroundings constants passed as arguments
	// front == Neighbor.WALL is true if a wall is in front of this critter
	// left == Neighbor.OTHER is true, there is a Critter to the left of
	// this Critter object that is NOT of the same class.
	WALL, EMPTY, SAME, OTHER;
}

enum Move {
	// move constants to be returned by getMove
	HOP, LEFT, RIGHT, INFECT;
}

class CritterModel {
	private int myHeight;
	private int myWidth;
	private Critter[][] myGrid;
	Hashtable<Critter, Position> myList;

	private static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;

	public CritterModel(int width, int height) {
		myWidth = width;
		myHeight = height;
		myGrid = new Critter[width][height];
		myList = new Hashtable<Critter, Position>();
	}

	public void add(int number, Class<?> critter) {
		if (myList.size() + number > myWidth * myHeight)
			throw new RuntimeException("adding too many critters");
		for (int i = 0; i < number; i++) {
			Critter next;
			try {
				next = (Critter) critter.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("" + e);
			}
			int x, y;
			do {
				x = randomInt(0, myWidth - 1);
				y = randomInt(0, myHeight - 1);
			} while (myGrid[x][y] != null);
			myGrid[x][y] = next;
			myList.put(next, new Position(x, y, randomInt(0, 3)));
		}
	}

	private int randomInt(int low, int high) {
		return low + (int) (Math.random() * (high - low + 1));
	}

	public int getWidth() {
		return myWidth;
	}

	public int getHeight() {
		return myHeight;
	}

	public char getChar(int x, int y) {
		if (myGrid[x][y] == null)
			return '.';
		else
			return myGrid[x][y].getChar();
	}

	public Position getOther(Position p) {
		Position other = new Position(p.x, p.y, p.direction);
		if (p.direction == NORTH)
			other.y--;
		else if (p.direction == EAST)
			other.x++;
		else if (p.direction == SOUTH)
			other.y++;
		else if (p.direction == WEST)
			other.x--;
		else
			throw new RuntimeException("illegal direction");
		return other;

	}

	private boolean inBounds(int x, int y) {
		return (x >= 0 && x < myWidth && y >= 0 && y < myHeight);
	}

	private boolean inBounds(Position p) {
		return inBounds(p.x, p.y);
	}

	private Neighbor getStatus(int x, int y, Class<? extends Critter> original) {
		if (!inBounds(x, y))
			return Neighbor.WALL;
		else if (myGrid[x][y] == null)
			return Neighbor.EMPTY;
		else if (myGrid[x][y].getClass() == original)
			return Neighbor.SAME;
		else
			return Neighbor.OTHER;
	}

	public void update() {
		Object[] list = myList.keySet().toArray();
		shuffle(list);
		for (int i = 0; i < list.length; i++) {
			Critter next = (Critter) list[i];
			Position p = (Position) myList.get(next);
			if (p == null) // happens when creature was infected earlier in
				// this round
				continue;
			Position other = getOther(p);

			// the following tricky code gets the info about surrounding
			// neighbors
			// the xs and ys arrays along with the expressions involving % 4
			// handle
			// direction
			int xs[] = { p.x, p.x + 1, p.x, p.x - 1 };
			int ys[] = { p.y - 1, p.y, p.y + 1, p.y };
			Class<? extends Critter> mine = next.getClass();
			Move move = next.getMove(
					getStatus(xs[p.direction], ys[p.direction], mine),
					getStatus(xs[(2 + p.direction) % 4],
							ys[(2 + p.direction) % 4], mine),
					getStatus(xs[(1 + p.direction) % 4],
							ys[(1 + p.direction) % 4], mine),
					getStatus(xs[(3 + p.direction) % 4],
							ys[(3 + p.direction) % 4], mine));
			if (move == Move.LEFT)
				p.direction = (p.direction + 3) % 4;
			else if (move == Move.RIGHT)
				p.direction = (p.direction + 1) % 4;
			else if (move == Move.HOP) {
				if (inBounds(other) && myGrid[other.x][other.y] == null) {
					myGrid[other.x][other.y] = myGrid[p.x][p.y];
					myGrid[p.x][p.y] = null;
					myList.put(next, other);
				}
			} else if (move == Move.INFECT) {
				if (inBounds(other)
						&& myGrid[other.x][other.y] != null
						&& myGrid[other.x][other.y].getClass() != myGrid[p.x][p.y]
								.getClass()) {
					myList.remove(myGrid[other.x][other.y]);
					try {
						myGrid[other.x][other.y] = (Critter) myGrid[p.x][p.y]
								.getClass().newInstance();
					} catch (Exception e) {
						throw new RuntimeException("" + e);
					}
					myList.put(myGrid[other.x][other.y], other);
				}
			}
		}
	}

	private void shuffle(Object[] list) {
		for (int i = 0; i < list.length; i++) {
			int j = randomInt(0, list.length - 1);
			Object temp = list[i];
			list[i] = list[j];
			list[j] = temp;
		}
	}

	private class Position {
		public Position(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public int x;

		public int y;

		public int direction;
	}
}
