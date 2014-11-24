// Assignment #: 5
// Name: Jacob Ward
// StudentID: 1204795198
// Lecture: MWF 9:00 am
// Description: This class reads in information about a student and creates a new student object with the information

public class StudentParser
{
	/*
			 *Default constructor that takes in the String to be parsed
			 *@return
	 */
	public static Student parseStringToStudent(String lineToParse)
	{
		String[] words = new String[8];		// creates string array to store individual strings from the larger string
		words = lineToParse.split("/");		// seperates strings from the parent string with / breaks

		if (words[0].equalsIgnoreCase("Online")) // checks to see if the student is an Onlinestudent and makes one if true
		{
			OnlineStudent oS = new OnlineStudent(words[1], words[2], words[3], Integer.parseInt(words[4]),
			Double.parseDouble(words [5]), Double.parseDouble(words[6]));	//must convert strings to appropriate data type using .parse

			return oS;
		}

		else		// makes on campus student if not an Online student
		{
			OnCampusStudent cS = new OnCampusStudent(words[1], words[2], words[3], Integer.parseInt(words[4]),
			Double.parseDouble(words [5]), words[6].equalsIgnoreCase("resident"), Double.parseDouble(words[7]));

			return cS;
		}
	}
}