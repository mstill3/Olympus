package com.stillwell.olympus.athena.time;

public class Millisecond extends TimeUnits
{
	
	private double milliseconds;
	
	public Millisecond()
	{
		set(0);
	}
	
	public Millisecond(double num)
	{
		set(num);
	}

	public double get()
	{
		return milliseconds;
	}
	
	public void set(double num)
	{
		milliseconds = num;
	}

	public double toMilliseconds()
	{
		return get();
	}
	
	public double toSeconds()
	{
		return toMilliseconds() / SECCONDS_TO_MILLISECONDS;
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
		return toWeeks() / WEEKS_TO_MONTHS;
	}
	
	public String toString()
	{
		String str = " millisecond";
		if(get() != 1)
			str += "s";
		return super.toString() + str;
	}
	
}
