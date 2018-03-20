package com.stillwell.olympus.athena.time;

public class Day extends TimeUnits
{
	
	private double days;
	
	public Day()
	{
		set(0.0);
	}

	public Day(double num)
	{
		set(num);
	}
	
	public double get()
	{
		return days;
	}
	
	public void set(double num)
	{
		days = num;
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
		return get();
	}
	
	public double toWeeks()
	{
		return toDays() / DAYS_TO_WEEKS;
	}
	
	public double toMonths()
	{
		return toWeeks() / WEEKS_TO_MONTHS;
	}
	
	public String toString()
	{
		String str = " day";
		if(get() != 1)
			str += "s";
		return super.toString() + str;
	}
	
}
