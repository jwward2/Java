public class Bee implements Critter
{
	public char getChar()
	{
		return '%';
	}

	public Move getMove(Neighbor front, Neighbor back, Neighbor left, Neighbor right)
	{
		if (back == Neighbor.OTHER)
		{
			return Move.INFECT;
		}

		else if (left == Neighbor.Same && right == Neighbor.Same)
		{
			if (Math.random() < .5)
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
		}

		else
		{
			return Move.HOP;
		}
	}
}
