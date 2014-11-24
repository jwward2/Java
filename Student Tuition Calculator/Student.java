// Assignment #: 5
// Name: Jacob Ward
// StudentID: 1204795198
// Lecture: MWF 9:00 am
// Description: This class represents a student in college that has a name, id, tuition, and credits.

import java.text.*;		//package for formating numerical currency values

public abstract class Student
{
	protected String firstName;		//attributes of a student
	protected String lastName;
	protected String studentID;

	protected int creditNum;

	protected double rate;
	protected double tuition;

	//Default constructor for student that initializes variables/attributes

	public Student(String fName, String lName, String id, int credits, double rate)
	{
		firstName = fName;
		lastName = lName;
		studentID = id;

		creditNum = credits;

		this.rate = rate;

		tuition = 0.0;
	}

	//Accessor for the student's number of credits

	public int getCreditNum()
	{
		return creditNum;
	}

	// abstract method that will be made into an over-ride in the sub-classes of student for calculating tuition

	public abstract void computeTuition();

	//prints out relevent information about the student object

	public String toString()
	{
		DecimalFormat fmat = new DecimalFormat("$,##0.00");

		String x = "\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t"
		+ studentID + "\nCredits:\t\t" + creditNum + "\nRate:\t\t\t" + fmat.format(rate) + "\nTuition:\t\t" + fmat.format(tuition) + "\n";

		return x;
	}
}
