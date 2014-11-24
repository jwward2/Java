//  Description: This class processes, stores, and moves data concerning banks and customers

import java.util.*;
import java.io.*;

public class BankSystem implements Serializable
{
  private ArrayList<Customer> customerList;
  private ArrayList<Bank> bankList;

  public BankSystem()
  {
	customerList = new ArrayList<Customer>();	//constructor
	bankList = new ArrayList<Bank>();
  }

  public int customerExists(String ID)
  {
	int result = -1;

	for(Customer x : customerList)				//check every current customer against the given ID
	{
		if(x.getCustomerID().equals(ID))
		{
			result = customerList.indexOf(x);
		}
	}

	return result;
  }

  public boolean addCustomer(String customer)
  {
	CustomerParser c = new CustomerParser();
	Customer temp = c.parseStringToCustomer(customer);		//take in the string and turn it into a customer to be added to the list

	if(customerExists(temp.getCustomerID())== -1)	//is it already a customer?
	{
		customerList.add(temp);
		return true;
	}

	return false;
  }

  public boolean removeCustomer(String customer)
  {
   if(customerExists(customer) != -1)
	{
		customerList.remove(customerExists(customer));	//same as addCustomer but remove
		return true;
	}

	return false;
   }

  public void sortCustomers()	//sort customers
  {
	Sorts s = new Sorts();
	s.sort(customerList);
  }

  public String listCustomers()	//print out all the info for every customer
  {
	String result = "";

	if(customerList.size() != 0)
	{
		for(Customer x : customerList)
		{
			result += x.toString();
		}
	}
	if(customerList.size() == 0)	//as long as the list isn't empty
	{
		result = "no customer\n";
	}

	return result;
  }

  public int bankExists(String name, int ID, String City, String State)	//use bank info and iterate through list to see it it exists
  {
	int result = -1;

	for (Bank x : bankList)
	{
		if((x.getBankName().equals(name)) && (x.getBankID() == ID) && (x.getBankAddress().getCity().equals(City)) && (x.getBankAddress().getState().equals(State)))
		{
			result = bankList.indexOf(x);
		}
	}

	return result;
  }

  public boolean addBank(String bank)
  {
	BankParser c = new BankParser();
	Bank temp = c.parseStringToBank(bank);

	if(bankExists(temp.getBankName(), temp.getBankID(), temp.getBankAddress().getCity(), temp.getBankAddress().getState())== -1)
	{
		bankList.add(temp);
		return true;
	}

	return false;
  }

  public boolean removeBank(String name, int ID, String City, String State)
  {
	if(bankExists(name, ID, City, State)!= -1)
	{
		bankList.remove(bankExists(name, ID, City, State));
		return true;
	}

	return false;
  }

  public void sortBanks()
  {
	Sorts s = new Sorts();
	s.sort(bankList);
  }

  public String listBanks()
  {
	String result = "";

	if(bankList.size() != 0)
	{
		for(Bank x : bankList)
		{
			result += x.toString();
		}
	}
	if(bankList.size() == 0)
	{
		result = "no bank\n";
	}

	return result;
  }

  public void closeBankSystem()	//clear everything
  {
	bankList.clear();
	customerList.clear();
  }
}
