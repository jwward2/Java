// Assignment #: 6
//         Name: Jacob Ward
//    StudentID: 1204795198
//      Lecture: MWF 9-9:50 am
//  Description: This class is a system of java panels that allow a user to select to bank accounts from drop down menus
//				 and transfer a specified amount of money from one account to the other and then display the updated accounts.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class TransferPanel extends JPanel
 {
   private Vector<Account> accountList;
   private JLabel from;
   private JLabel to;					//
   private JLabel amount;				// Create needed GUI parts for user interaction
   private JLabel message;				//
   private JLabel message2;
   private JLabel message3;
   private JTextField amountField;
   private JComboBox fromBox;
   private JComboBox toBox;
   private JPanel total;
   private JButton transaction;

   //Constructor initialize each component and arrange them using
   //certain layouts
   public TransferPanel(Vector<Account> accountList)
     {
      this.accountList = accountList;

      transaction = new JButton("Transfer!");
      transaction.addActionListener(new ButtonListener());		//Create and configure GUI parts and add listener connection

      from = new JLabel("Please choose FROM Accunt for transfer:");
      to = new JLabel("Please choose TO Account for transfer:");
      amount = new JLabel("Enter a Transfer Amount:");
      message = new JLabel("");							//
      message2 = new JLabel("");						//These labels are "invisible" until the user completes an action or error
      message3 = new JLabel("");						//

      amountField = new JTextField();

      total = new JPanel();
      total.setLayout(new GridLayout(10,1));

      fromBox = new JComboBox(accountList);
      toBox = new JComboBox(accountList);

      total.add(from);				//Add GUI parts panel
      total.add(fromBox);
      total.add(to);
      total.add(toBox);
      total.add(amount);
      total.add(amountField);
      total.add(transaction);
      total.add(message);
      total.add(message2);
      total.add(message3);

      add(total); //Add panel


      }

    //This method  refreshes the JComboBoxes with
    //updated vector information
    public void updateAccountList()
     {
       toBox.updateUI();
       fromBox.updateUI();
     }

 //ButtonListener class listens to see the button "Transfer!" is pushed.
 //A user can choose which bank account to transfer from and another account to transfer to,
 //then choose a transfer amount and push the "Transfer" button.
 //This should update both FROM and TO account balances and display them
 //below the "Transfer!" button
 //(You should make use of the toString( ) method of the Account class. )
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
		try
		{
			 int y = toBox.getSelectedIndex();									//Select accounts and find out balances
			 int x = fromBox.getSelectedIndex();
			 double balanceFrom = (accountList.elementAt(x)).getAmount();
			 double balanceTo = (accountList.elementAt(y)).getAmount();

			 double transfer = Integer.parseInt(amountField.getText());  //how much to transfer?

			 balanceFrom = balanceFrom - transfer;			//compute new balance
			 balanceTo = balanceTo + transfer;

			 (accountList.elementAt(x)).setAmount(balanceFrom);		//reset balance to new amount
			 (accountList.elementAt(y)).setAmount(balanceTo);

			 message.setText("The current balances are:");				//show the user the new balance
			 message2.setText((accountList.elementAt(x)).toString());
			 message3.setText((accountList.elementAt(y)).toString());

			 updateAccountList();		//update the dropdown totals
		 }

		 catch(java.lang.NumberFormatException exception)		//check to make sure the fields were filled
		 {
			 message.setText("Please enter a number for the transfer amount");
			 message2.setText("");
			 message3.setText("");
		 }


        }
  }

}
