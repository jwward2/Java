//  Description: The Assignment 11 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;
import java.util.*;

public class Sorting-Algorithm
 {
  public static void main (String[] args)
   {
     char input1;
     String inputInfo = new String();
     String line = new String();

     Sorting sort1 = new Sorting();

     try
      {
       // print out the menu
       printMenu();

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.print("What action would you like to perform?\n");
         line = stdin.readLine().trim();  //read a line
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)   //check if a user entered only one character
          {
           switch (input1)
            {
             case 'A':   //Add A Number
               System.out.print("Please enter an integer to add:\n");
               inputInfo = stdin.readLine().trim();
               int num = Integer.parseInt(inputInfo);
               sort1.addToMainQueue(num);
               System.out.print("number added\n");
               break;
             case 'L':   //List Numbers
               System.out.print(sort1.listMainQueue());
               break;
             case 'Q':   //Quit
               break;
             case 'S':  //Sort Numbers
               sort1.sortNumbers();
               System.out.print("numbers sorted\n");
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
      }
     catch (IOException exception)
      {
        System.out.print("IO Exception\n");
      }
  }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd An Integer\n" +
                      "L\t\tList Numbers\n" +
                      "Q\t\tQuit\n" +
                      "S\t\tSort Numbers\n" +
                      "?\t\tDisplay Help\n\n");
  }
}
