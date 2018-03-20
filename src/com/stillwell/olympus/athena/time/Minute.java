package com.stillwell.olympus.athena.time;

public class Minute extends TimeUnits
{
	
	private double minutes;
	
	public Minute()
	{
		set(0);
	}

	public Minute(double num)
	{
		set(num);
	}
	
	public double get()
	{
		return minutes;
	}
	
	public void set(double num)
	{
		minutes = num;
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
		return get();
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
		String str = " minute";
		if(get() != 1)
			str += "s";
		return super.toString() + str;
	}
	
}
