package com.stillwell.olympus.athena.time;

public class Hour extends TimeUnits
{
	
	private double hours;
	
	public Hour()
	{
		set(0);
	}

	public Hour(double num)
	{
		set(num);
	}

	public double get()
	{
		return hours;
	}

	public void set(double num)
	{
		hours = num;
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
		return get();
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
		return toWeeks() / WEEKS_TO_MONTHS;
	}
	
	public String toString()
	{
		String str = " hour";
		if(get() != 1)
			str += "s";
		return super.toString() + str;
	}
	
}
