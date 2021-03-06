// Assignment #: 8
//         Name: Jacob Wolfgang Ward
//    StudentID: 1204795198
//      Lecture: MWF 9:00 - 9:50 am
//  Description:The Address class describes city and state of a bank.
//  It will be used as an aggregate object of the Bank class. It has following attributes:

import java.io.*;

public class Address implements Serializable, Comparable
 {
   // instance variables
   private String city;
   private String state;

   /************************************************************************
   Constructor method to initialize intance variables.
   ************************************************************************/
   public Address()
    {
     city = new String("?");
     state= new String("?");
    }

   /************************************************************************
   Accessor method:
   This method returns the city of the address.
   ************************************************************************/
   public String getCity()
    {
     return city;
    }

   /************************************************************************
   Accessor method:
   This method returns the state of the address.
   ************************************************************************/
   public String getState()
    {
     return state;
    }

   /************************************************************************
   Modifier method:
   This method sets the city of the address given by its parameter.
   ************************************************************************/
   public void setCity(String city)
    {
     this.city = city;
    }

   /************************************************************************
   Modifier method:
   This method sets the state of the address by its parameter.
   ************************************************************************/
   public void setState(String state)
    {
      this.state = state;
    }

   /************************************************************************
   This method return a string containing the attribute information in address
   ************************************************************************/
   public String toString()
    {
     String result;
     result = city + "," + state;

      return result;
    }
   public int compareTo(Object other)	//check state, then check city
   {

		int result = (this.getState().compareTo(((Address)other).getState()));
		if(result == 0)
		{
			result = (this.getCity().compareTo(((Address)other).getCity()));
		}
		return result;
   }

}
