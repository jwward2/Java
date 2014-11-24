// Assignment #: 5
// Name: Jacob Ward
// StudentID: 1204795198
// Lecture: MWF 9:00 am
// Description: This class represents a student that is considered on campus and computes the tuition for that student
//				based on the specific fees associated with being on campus.

import java.text.*;		// package for formating numerical outputs.

public class OnCampusStudent extends Student
{
	private boolean resident;			// attributes of the Oncampus sub-class
	private int creditUpperbound;
	private double studentProgramFee;

	// default constructor that assigns variables such as name, credits, and additional fees.

	public OnCampusStudent(String fName, String lName, String id, int credits, double rate, boolean resident, double programFee)
	{
		super(fName, lName, id, credits, rate);		// call student constructor

		studentProgramFee = programFee;		// assign additional attributes for Oncampus student
		this.resident = resident;

		if (resident == true)		//check to see if resident
		{
			creditUpperbound = 7;		//set upperbound
		}

		else
		{
			creditUpperbound = 12;		//set upperbound
		}
	}

	//This method calculates the tuition for the student based off of credit stipulations

	public void computeTuition()
	{
		if (creditNum >= creditUpperbound)
		{
			tuition = rate*creditUpperbound + studentProgramFee;
		}

		else
		{
			tuition = (rate*creditNum) + studentProgramFee;
		}
	}

	//prints out relevent information about the student

	public String toString()
	{
		DecimalFormat fmat = new DecimalFormat("$,##0.00");		//Formats currency values

		String x = "?";		//string to be returned by method

		if(resident == true)
		{

			x = "\nOnCampus Student:" + "\nResident Status" + super.toString() + "Student Program Fee:\t"
			+ fmat.format(studentProgramFee) + "\n";

		}

		else
		{
			x = "\nOnCampus Student:" + "\nNonResident Status" + super.toString() + "Student Program Fee:\t"
			+ fmat.format(studentProgramFee) + "\n";
		}

		return x;
	}
}