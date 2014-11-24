/*
*Description Creation of two classes to simulate a teacher and a student interacting
*/

import java.util.Scanner;

public class Instructor
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		Student student1 = new Student("Jacob");
		Student student2 = new Student("James");

		int task = 0;

		System.out.println("Hello Instructor");

		while(task != 3)
		{

			System.out.println("Please select a task");
			System.out.println("1 - Ask student's name");
			System.out.println("2 - Calculate student's grade");
			System.out.println("3 - Quit");
			task = scan.nextInt();
			System.out.println();

			if (task == 1)
			{
				System.out.println("Please select a student");
				System.out.println("1 - Student 1");
				System.out.println("2 - Student 2");
				int studentPick = scan.nextInt();
				System.out.println();

				if (studentPick == 1)
				{
					System.out.println(student1.getName());
					System.out.println();
				}
				else
				{
					System.out.println(student2.getName());
					System.out.println();
				}
			}
			else if (task == 2)
			{
				System.out.println("Please select a student");
				System.out.println("1 - Student 1");
				System.out.println("2 - Student 2");
				int studentPick = scan.nextInt();
				System.out.println();

				if (studentPick == 1)
				{
					String grade = student1.calculateFinalGrade();
					System.out.println();
					System.out.println("Thus, the student's grade is an " + grade);
					System.out.println();
				}
				else if (studentPick == 2)
				{
					String grade = (student2.calculateFinalGrade());
					System.out.println();
					System.out.println("Thus, the student's grade is an " + grade);
					System.out.println();
				}
			}
		}
	}
}
