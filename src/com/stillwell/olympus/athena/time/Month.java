package com.stillwell.olympus.athena.time;

public class Month extends TimeUnits
{
	
	private double months;
	
	public Month()
	{
		set(0);
	}

	public Month(double num)
	{
		set(num);
	}
	
	public double get()
	{
		return months;
	}
	
	public void set(double num)
	{
		months = num;
	}
	
	public double toMilliseconds()
	{
		return toSeconds() * SECCONDS_TO_MILLISECONDS;
	}
	
	public double toSeconds()
	{
		return toMinutes() * MINUTES_TO_SECONDS;
	}
	
	public double toMinutes()
	{
		return toHours() * HOURS_TO_MINUTES;
	}
	
	public double toHours()
	{
		return toDays() * DAYS_TO_HOURS;
	}
	
	public double toDays()
	{
		return toWeeks() * DAYS_TO_WEEKS;
	}
	
	public double toWeeks()
	{
		return toMonths() * WEEKS_TO_MONTHS;
	}
	
	public double toMonths()
	{
		return get();
	}
	
	public String toString()
	{
		String str = " month";
		if(get() != 1)
			str += "s";
		return super.toString() + str;
	}
	
}
