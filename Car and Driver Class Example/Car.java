/*
*Description: Making classes for a car and driver object
*/

public class Car
{
	private String name;
	private double speed;

	public double getSpeed()
	{
		return this.speed;
	}

	public double distanceTraveled(double time)
	{
		double adjustedTime = time/60.0;
		double distance = speed*adjustedTime;

		return distance;
	}

	public void setSpeed(double speed)
	{
		this.speed = speed;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public Car(String name, double speed)
	{
		this.name = name;
		this.speed = speed;
	}


}
