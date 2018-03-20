package com.stillwell.olympus.athena.serialization;
import java.io.Serializable;  

public class Student implements Serializable
{  

	private static final long serialVersionUID = -7104036054365076042L;
	int id;  
	String name;  

	public Student(int id, String name)
	{  
		this.id = id;  
		this.name = name;  
	}  

} 