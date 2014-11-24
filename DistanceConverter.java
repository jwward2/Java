/*
*Description: This is our first project covering variables and simple java programs with the math class to make unit conerters
*/

public class DistanceConverter {
	public static void main(String [] args){

//Here I am declaring two constants as double variables to hold their decimals, they will be used as my conversion factors.

		final double Kilometers_To_Lightyears = 1.057E-13;
		final double Miles_To_Kilometers = 1.609;

// Next I will declare my distance to be converted as an int variable seeing as how it has no decimals.

		int distance = 1000000;
// Next I will use simple arithmatic to take my above variable and store it, in converted units, in double variables to keep the decimals of the constants.

		double distanceInKm = distance * Miles_To_Kilometers;
		double distanceInLy = distanceInKm * Kilometers_To_Lightyears;

// FInally, I will use the System.out.println, which concatenated the string in "" with the calculated variables, to print to the terminal.

		System.out.println("Distance in Miles " + distance);
		System.out.println("Distance in Kilometers " + distanceInKm);
		System.out.println("Distance in Lightyears " + distanceInLy);
	}
}

