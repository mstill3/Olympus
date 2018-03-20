package com.stillwell.olympus.athena.serialization;

public class StudentTester
{

	public static void main(String[] args)
	{
		StudentHandler handle = new StudentHandler();

//				handle.registerStudent(123, "Alex");
		handle.readStudentFile(123);
		for(String s: handle.getIDsInSystm())
			System.out.println(s);

	}

}
