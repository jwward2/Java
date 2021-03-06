/*
*Description: This is the mainclass that will run the program and populate the student list class with student objects, as well as
*	      print the list.
*/

import java.util.ArrayList;
import java.util.Scanner;


public class Student-List-Driver {

	public static void main(String[] args) {

		StudentList studentList = new StudentList();
		Scanner scan = new Scanner(System.in);
		int input = -1;
		do {
			System.out.println("Please enter one of the following options");
			System.out.println("1. Add a new student to list");
			System.out.println("2. Get student name from list");
			System.out.println("3. Quit");

			input = scan.nextInt();

			switch(input) {
				case 1: System.out.print("Enter name of new student: ");
						String name = scan.next();
						System.out.print("Enter id of new student: ");
						String id = scan.next();
						studentList.addStudentToList(name, id);
						break;
				case 2: System.out.print("Enter the id of the required student: ");
						String id1 = scan.next();
						System.out.println("The name of student is " + studentList.getStudentName(id1));
						break;
				case 3: break;
				default: System.out.println("Invalid option!");
						break;

			}

			System.out.println("The current list is ");
			printList(studentList.getList());

		}while(input != 3);
	}

	/**
	 *This method is responsible for printing the list of students in the array at any given time.
	 *
	 *@param <arraylist> this param consists of a studentlist arraylist that is populated with student objects that will be called upon
	 * by this method to provide and print out the name and id of each student pbject.
	 */

	public static void printList(ArrayList<Student> list)
	{
		for (Student student: list)
		{
			System.out.println("Student name: " +  student.getName()+ " Student I.D: " + student.getId());
			System.out.println();
		}
	}
}
