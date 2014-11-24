//  Description: This class represents a circle that will be drawn on a GUI canvas

import java.awt.*;
import javax.swing.*;			//import needed packages
import java.awt.event.*;
import java.util.ArrayList;

public class Circle
{
	private int x;
	private int y;				//declare characteristics of a circle
	private int diameter;
	private Color color;
	private boolean trace;	//use this to check if its a final filled circle or a updating unfilled circle "trace"

	public Circle( int x, int y, int diameter, Color color, boolean trace)
	{
		this.x = x;
		this.y = y;
		this.diameter = diameter;			//make constructor for Circle
		this.color = color;
		this.trace = trace;
	}

	public void draw(Graphics page)
	{
		page.setColor(color);
		if (trace == true)					//set color of circle
		{							// is it a filled or unfilled circle?
			page.fillOval(x, y, diameter, diameter);	// draw accordingly
		}
		else
		{
			page.drawOval(x, y, diameter, diameter);
		}

	}
}
