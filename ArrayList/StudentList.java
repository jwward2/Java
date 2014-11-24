/*
*Description: This class, Student List, createst the array list that will store and work on all of the student objects I create
*/

import java.util.ArrayList;


public class StudentList
{

	private ArrayList<Student> list;

	public StudentList()

	{
		list = new ArrayList<Student>();
	}
	/**
	 *
	 * @return list
	 */
	public ArrayList<Student> getList()
	{
		return list;
	}

	/**
	 *
	 * @param list
	 */
	public void setList(ArrayList<Student> list)
	{
		this.list = list;
	}


	/**
	 *This method creates the new student and adds it to the arraylist
	 *
	 *@param <name> this param is the string name of the student
	 *@param <id> this param is the id number associated with each student.
	 */

	public void addStudentToList(String name, String id)
	{
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		list.add(student);
	}

	public String getStudentName(String id)
	{
		String name = "not found";

		for (Student student: list)
		{
			String num = student.getId();

			if (num.equals(id))
			{
				name = student.getName();
			}

		}

		return name;

	}


}
