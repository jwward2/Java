/*
*Description: This program utilizes methods that act on an array to perform search functions and manipulation functions
*/
public class Arrays {

	private int[] array;

	public void setArray(int[] array) {
		this.array = array;
	}

	public void printArray() {
		for(int i=0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public int search(int number)
	{
		int counter = -1;

		for (int i = 0; i < array.length; i++)
		{
			if (number == array[i])
			{
				counter = i;
			}
		}

		return counter;
	}

	public void addToArray(int number, int index)
	{
		array[index] = number;
	}

	public int findLargest()
	{
		int counter = 0;

		for (int i = 0; i < array.length; i++)
		{
			if (counter < array[i])
			{
				counter = array[i];
			}
		}

		return counter;
	}

}
