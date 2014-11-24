// Assignment #: 6
//         Name: Jacob Ward
//    StudentID: 1204795198
//      Lecture: MWF 9-9:50 am
//  Description: The Bank Transfer class creates a Tabbed Pane with
//               two tabs, one for Account creation and one for
//               Account transfer. and adds it as its Applet content
//               and also sets its size.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Bank-Transfer extends JApplet
 {

   private int APPLET_WIDTH = 500, APPLET_HEIGHT = 200;

   private JTabbedPane tPane;
   private CreatePanel createPanel;
   private TransferPanel transferPanel;
   private Vector accountList;

   //The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
     //list of accounts to be used in every panel
     accountList = new Vector();

     //register panel uses the list of accounts
     transferPanel = new TransferPanel(accountList);

     createPanel = new CreatePanel(accountList, transferPanel);

     //create a tabbed pane with two tabs
     tPane = new JTabbedPane();
     tPane.addTab("Account creation", createPanel);
     tPane.addTab("Account transfer", transferPanel);
     tPane.addChangeListener(new TabListener()); //add a listener to see when tabs are changed

     tPane.addChangeListener(new TabListener());

     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }

	private class TabListener implements ChangeListener //listens to see if the user changes tabs between create and transfer
	{
	    public void stateChanged(ChangeEvent event)
	    {
			createPanel.printAccounts(); // if tabs are changed update the output for accounts
		}
	}
}

