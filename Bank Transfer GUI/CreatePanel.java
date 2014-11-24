// Assignment #: 6
//         Name: Jacob Ward
//    StudentID: 1204795198
//      Lecture: MWF 9-9:50 am
//  Description: This class creates a system of java panels that take in information about bank accounts and
//				 shows the account information out to a text area in an updating fashion.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CreatePanel extends JPanel
 {
   private Vector <Account>accountList;
   private JButton accountButton;			//Establish all components for the GUI that will be accessed by listener class
   private TransferPanel transferPanel;
   private JTextField areaID;
   private JTextField areaAmount;
   private JTextArea areaDisplay;
   private JLabel messageLabel;

 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector<Account> accountList, TransferPanel tPanel)
  {
    this.accountList = accountList;
    this.transferPanel = tPanel;

    JPanel totalPanel = new JPanel();
    JPanel leftPanel = new JPanel();		//Create all components and panels to make GUI
    JPanel panelID = new JPanel();
    JPanel panelAmount = new JPanel();
    JPanel panelInfo = new JPanel();
    JPanel panelMessage = new JPanel();
    JPanel panelButton = new JPanel();

    totalPanel.setLayout(new GridLayout(1, 2));
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));		//Set panel layouts to configure GUI
    panelID.setLayout(new GridLayout(1, 2));
    panelAmount.setLayout(new GridLayout(1, 2));
    panelInfo.setLayout(new GridLayout(2,1));
    panelMessage.setLayout(new GridLayout(1,2));

    JLabel labelID = new JLabel("Account ID");		//Create labels to identify textfields
    JLabel labelAmount = new JLabel("Amount");
    messageLabel = new JLabel("");				//make "invisible" message label that will appear if the user completes an action
    messageLabel.setForeground(Color.red);

    areaID = new JTextField();				//Make text areas for input
    areaAmount = new JTextField();

    accountButton = new JButton("Create an Account");
    accountButton.addActionListener(new ButtonListener()); //Connect button to listener

    areaDisplay = new JTextArea(30,30);
    areaDisplay.setBorder(BorderFactory.createLineBorder(Color.black));		//Make and configure account display area
    areaDisplay.setEditable(false);
    areaDisplay.setText("No account");

	panelButton.add(accountButton);

	panelMessage.add(messageLabel);

    panelID.add(labelID);
    panelID.add(areaID);

    panelAmount.add(labelAmount);
    panelAmount.add(areaAmount);			//Add all panels together in needed order

    panelInfo.add(panelID);
    panelInfo.add(panelAmount);

	leftPanel.add(panelMessage);
    leftPanel.add(panelInfo);
    leftPanel.add(panelButton);

    totalPanel.add(leftPanel);
    totalPanel.add(areaDisplay);

    add(totalPanel);
}

public void printAccounts()		//method used when tabs are switched to update the account display list after a transfer occurs
{								// If transfer occurs, the banks are updated in createpanel without clicking to add a new account
	if(!(accountList.size() == 0))		//checks to make sure the list contains accounts
	{
		areaDisplay.setText("");		//clears the text area to re populate

		for(Account x: accountList)	//adds account info
		{
			areaDisplay.setText(areaDisplay.getText() + x.toString() + "\n");
		}
	}
	else
	{
		areaDisplay.setText("No account");	//if list is empty
	}
}


  //ButtonListener is a listener class that listens to
  //see if the buttont "Create an account" is pushed.
  //When the event occurs, it adds an account information from
  //the text fields to the text. It also creates an Account object
  //using these two information and add it to the accountList.
  //It also does error checking.

  private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
     {
		if (!((areaID.getText()).length()== 0) && !((areaAmount.getText()).length()== 0)) //are the areas both filled?
		{
			try
			{
				messageLabel.setText("Account Added");		//create and add account
				areaDisplay.setText("");
				accountList.addElement(new Account(areaID.getText(), Integer.parseInt(areaAmount.getText())));

			   for(Account x: accountList)
				{
					areaDisplay.setText(areaDisplay.getText() + x.toString() + "\n");
				}
			}

			catch(java.lang.NumberFormatException exception) //are the areas filled correctly?
			{
				areaDisplay.setText("No account");
				messageLabel.setText("Please enter a number for the amount");
			}
		 }

		 else
		 {
			 messageLabel.setText("Please fill both id and amount");	//if not filled...
		 }
     }
  }

}
