// Assignment #: 5
// Name: Jacob Ward
// StudentID: 1204795198
// Lecture: MWF 9:00 am
// Description: This class represents a Online student that has additional features of a student such as computer fees

import java.text.*;		//package for formating numerical currency values

public class OnlineStudent extends Student
{
	private double computingFee;		//additional attributes

	//default constructor for Online student that initializes attributes

	public OnlineStudent(String fName, String lName, String id,  int credits, double rate, double compFee)
	{
		super(fName, lName, id, credits, rate);		//call Student constructor to set other variables
		computingFee = compFee;		//set additional attributes

	}

	//method to compute tuition for student based on having an additional fee

	public void computeTuition()
	{
		tuition = (rate + computingFee) * creditNum;
	}

	//this method prints out relevent information about the online student through the use of the parent toString

	public String toString()
	{
		DecimalFormat fmat = new DecimalFormat("$#.00");

		String x = "\nOnline Student:" + super.toString() + "Computing Fee:\t\t" + fmat.format(computingFee) + "\n";

		return x;
	}
}