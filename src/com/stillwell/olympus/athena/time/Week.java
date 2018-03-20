package com.stillwell.olympus.athena.time;

public class Week extends TimeUnits
{
	
	private double weeks;
	
	public Week()
	{
		set(0);
	}

	public Week(double num)
	{
		set(num);
	}

	public double get()
	{
		return weeks;
	}
	
	public void set(double num)
	{
		weeks = num;
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
		return get();
	}
	
	public double toMonths()
	{
		return toWeeks() * WEEKS_TO_MONTHS;
	}
	
	public String toString()
	{
		String str = " week";
		if(get() != 1)
			str += "s";
		return super.toString() + str;
	}
	
}
