// Assignment #: 7
//         Name: Jacob Wolfgang Ward
//    StudentID: 1204795198
//      Lecture: MWF 9:00 - 9:50 a.m
//  Description: This class creates a canvas in a java GUI that allows a user to draw and erase circles of different colors

import java.awt.*;
import javax.swing.*;				//import needed packages
import java.awt.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel
{
   private ArrayList<Circle> circleList;
   private String[] colorList;
   private Color currentColor;
   private Canvas canvas;
   private JPanel topPanel;				//declare variables
   private JButton undo;
   private JButton erase;
   private JComboBox colorBox;
   private int xinitial;
   private int yinitial;
   private ArrayList<Circle> tempList;		//used to store temp circles after erase button is hit
   private ArrayList<Circle> tempList2;
   private boolean ifErase;

   public WholePanel()
    {
      currentColor = Color.black;

      circleList = new ArrayList<Circle>();			//set up panel and variables
      topPanel = new JPanel();
      topPanel.setLayout(new GridLayout(1,3));

      undo = new JButton("Undo");					//link buttons to listeners
      undo.addActionListener(new UndoListener());
      erase = new JButton("Erase");
      erase.addActionListener(new EraseListener());

      String[] colorList = {"Black", "Red", "Yellow", "Blue", "Cyan", "Green", "Magenta", "Gray"}; //color choices

      colorBox = new JComboBox(colorList);
      colorBox.addActionListener(new ColorListener());	//link color choices to their listener

      topPanel.add(undo);
      topPanel.add(erase);		//add the buttons and box
      topPanel.add(colorBox);

      canvas = new Canvas();
      canvas.addMouseListener(new PointListener());				//add listeners
      canvas.addMouseMotionListener(new PointListener());

      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, canvas);

      setLayout(new BorderLayout());
      add(sp);

     }


    private class Canvas extends JPanel
     {

      public void paintComponent(Graphics page)
       {
         super.paintComponent(page);

         setBackground(Color.white);

         for(Circle x: circleList)		//draw all circles in the list
         {
			x.draw(page);
		 }
       }
     }

    private class PointListener implements MouseListener, MouseMotionListener
     {
		 private int xfinal;			//variables used to compute and make circles
		 private int yfinal;
		 private int xtemp;
		 private int ytemp;
		 private int radius;
		 private int diameter;

         public void mousePressed(MouseEvent event)
         {
			ifErase = true;		//used to check if the erase button was hit last

			xinitial = event.getX();
			yinitial = event.getY();

			circleList.add(new Circle( xinitial, yinitial, 0, currentColor, false)); 	//add new circle

         }
         public void mouseReleased(MouseEvent event)
         {
         	xfinal = event.getX();
         	yfinal = event.getY();

         	radius = (int) Math.sqrt(Math.pow((double)(xfinal-xinitial),2) + Math.pow((double)(yfinal-yinitial),2));
			diameter = 2*radius;

			circleList.set(circleList.size() - 1, new Circle(xinitial - radius, yinitial - radius, diameter, currentColor, true));

			repaint();		//modify the initial circle and repaint it as a filled circle

         }
         public void mouseClicked(MouseEvent event) {}
         public void mouseEntered(MouseEvent event) {}
         public void mouseExited(MouseEvent event) {}
         public void mouseDragged(MouseEvent event)
         {
			xtemp = event.getX();
			ytemp = event.getY();			//update the initial circle and make traces of it as the mouse moves.

         	radius = (int) Math.sqrt(Math.pow((double)(xtemp-xinitial),2) + Math.pow((double)(ytemp-yinitial),2));
			diameter = 2*radius;

			circleList.set(circleList.size() - 1, new Circle(xinitial - radius, yinitial - radius, diameter, currentColor, false));
			repaint();

         }
         public void mouseMoved(MouseEvent event) {}

     }

    private class ColorListener implements ActionListener	//check what choice is picked for color
    {
		public void actionPerformed(ActionEvent event)		//compare string selected and set the color to that choice
		{
			if (colorBox.getSelectedItem().equals("Black"))
			{
				currentColor = Color.black;
			}
			if (colorBox.getSelectedItem().equals("Red"))
			{
				currentColor = Color.red;
			}
			if (colorBox.getSelectedItem().equals("Yellow"))
			{
				currentColor = Color.yellow;
			}
			if (colorBox.getSelectedItem().equals("Blue"))
			{
				currentColor = Color.blue;
			}
			if (colorBox.getSelectedItem().equals("Cyan"))
			{
				currentColor = Color.cyan;
			}
			if (colorBox.getSelectedItem().equals("Green"))
			{
				currentColor = Color.green;
			}
			if (colorBox.getSelectedItem().equals("Magenta"))
			{
				currentColor = Color.magenta;
			}
			if (colorBox.getSelectedItem().equals("Gray"))
			{
				currentColor = Color.gray;
			}
		}
	}
	private class UndoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			if(circleList.size() >= 0)		//is the list populated?
			{
				if (ifErase == true && circleList.size() >0)		//if so allow me to remove the last move until it itn't populated
				{
					circleList.remove(circleList.get(circleList.size() - 1));
				}

				if (ifErase == false)		//if erase was hit last then bring back the temp list that stored all the circles and paint it
				{
					circleList = tempList;
					ifErase = true; //reset the check for erase
				}
				else
				{
				}

				repaint();
			}

		}
	}
	private class EraseListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (ifErase == true) // if erase was not hit last
			{
				ifErase = false;						//swap the check value
				tempList = new ArrayList<Circle>();		//swap the content of circles to a new storage place and erase circleList
				tempList2 = new ArrayList<Circle>();
				tempList = circleList;
				circleList = tempList2;
				repaint();					//repaint with a blank screen
			}

		}
	}

}
