//  Description: This program takes a file input of numbers and computes information about the set such as the min value
//               and the number of odds.

import java.io.*;
import java.util.*;

public class Number-Input
{
	public static void main(String[] args)
	 {
	   try
	    {
	      ArrayList<Integer> nums = new ArrayList<Integer>();

	      InputStreamReader isr = new InputStreamReader (System.in);
	      BufferedReader br = new BufferedReader (isr);

	      int next = 0;

	      do
	      {
			String in = br.readLine(); //take in info

			try
			{
		  		next = Integer.parseInt(in);
		  		nums.add(next); //add numbers to arraylist
			}
			catch (Exception e){}

	      } while(next != 0);

	      int[] numList = new int[nums.size()];

	      for (int i = 0; i < nums.size(); i++)
	      {
			numList[i] = ((nums.get(i)).intValue()); //convert arrayList of any size to array of ints
		  }
	      br.close();

	      System.out.println("The minimum number is " + findMin(numList, 0, numList.length - 1));
	      System.out.println("The sum of the numbers divisible by 3 is " + computeSumDivisibleBy3(numList, 0, numList.length - 1));
	      System.out.println("The sum of the numbers at odd indexes is " + computeSumAtOdd(numList, 0, numList.length - 1));
	      System.out.println("The total count of positive numbers is " + countPositive(numList, 0, numList.length - 1));
	    }
	    catch (IOException e)
	    {
	      System.out.println(e);
	    }
  }
	public static int findMin(int[] nums, int startIndex, int endIndex)
	{
		int check = 0;

		if(startIndex == endIndex)
		{
			return nums[0];
		}
		else
		{
			check = findMin(nums, startIndex, endIndex - 1);

			if(check <= nums[endIndex])
			{
				return check;
			}

			else
			{
				return nums[endIndex];
			}
		}
	}

	public static int computeSumDivisibleBy3(int[] nums, int startIndex, int endIndex)
	{
		int check = 0;

		if(startIndex == endIndex)
		{
			if ((nums[startIndex] % 3) ==  0)
			{
				check += nums[startIndex];
				return check;
			}
			else
				return check;
		}

		else
		{
			int midIndex = (startIndex + endIndex)/2;
			int left = computeSumDivisibleBy3(nums, startIndex, midIndex);
			int right = computeSumDivisibleBy3(nums, midIndex+1, endIndex);

			check += left + right;

			return check;
		}
	}

	public static int computeSumAtOdd(int[] nums, int startIndex, int endIndex)
	{
		if (endIndex == startIndex)
		{
			return 0;
		}
		if (startIndex % 2 == 0)
		{
			return computeSumAtOdd(nums, startIndex + 1, endIndex);
		}
		else
		{
    		return computeSumAtOdd(nums, startIndex + 1, endIndex) + nums[startIndex];
		}
	}

	public static int countPositive(int[] nums, int startIndex, int endIndex)
	{
		if(startIndex == endIndex)
		{
			if (nums[startIndex] > 0)
			{
				return 1;
			}
			else
				return 0;
		}

		else
		{
			int midIndex = (startIndex + endIndex)/2;
			int left = countPositive(nums, startIndex, midIndex);
			int right = countPositive(nums, midIndex+1, endIndex);

			return left + right;
		}
	}
}
