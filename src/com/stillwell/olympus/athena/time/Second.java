package com.stillwell.olympus.athena.time;

public class Second extends TimeUnits
{
	
	private double seconds;
	
	public Second()
	{
		set(0);
	}
	
	public Second(double num)
	{
		set(num);
	}

	public double get()
	{
		return seconds;
	}
	
	public void set(double num)
	{
		seconds = num;
	}
	
	public double toMilliseconds()
	{
		return toSeconds() * SECCONDS_TO_MILLISECONDS;
	}
	
	public double toSeconds()
	{
		return get();
	}
	
	public double toMinutes()
	{
		return toSeconds() / MINUTES_TO_SECONDS;
	}
	
	public double toHours()
	{
		return toMinutes() / HOURS_TO_MINUTES;
	}
	
	public double toDays()
	{
		return toHours() / DAYS_TO_HOURS;
	}
	
	public double toWeeks()
	{
		return toDays() / DAYS_TO_WEEKS;
	}
	
	public double toMonths()
	{
		return toWeeks() * WEEKS_TO_MONTHS;
	}
	
	public String toString()
	{
		String str = " second";
		if(get() != 1)
			str += "s";
		return super.toString() + str;
	}
	
}
