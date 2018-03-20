package com.stillwell.olympus.athena.time;

public class TimeTester
{

	public static void main(String[] args)
	{
	
		int milliseconds = 0;
		int seconds = 0;
		int minutes = 20000;
		int hours = 0;
		int days = 0;
		int weeks = 12;
		int months = 0;
		
		Time t = new Time(milliseconds, seconds, minutes, 
				hours, days, weeks, months);
		
		System.out.println(t);
		
	}
	
}
