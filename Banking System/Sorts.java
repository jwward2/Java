// Assignment #: 8
//         Name: Jacob Wolfgang Ward
//    StudentID: 1204795198
//      Lecture: MWF 9:00 - 9:50 am
//  Description: This is a utility class that sorts an arraylist of objects and compares them using the compare to interface

import java.util.*;
import java.io.*;

public class Sorts
{
	public static void sort(ArrayList objects)	//insertion sort
	{
		for(int index = 1; index < objects.size(); index++)
		{
			Comparable key = (Comparable)objects.get(index);	//make comparable
			int position = index;

			while(position > 0 && ((Comparable)objects.get(position - 1)).compareTo(key) > 0)
			{
				objects.set(position, objects.get(position - 1));
				position--;
			}

			objects.set(position, key);
		}
	}
}