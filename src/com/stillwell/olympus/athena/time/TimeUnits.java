package com.stillwell.olympus.athena.time;

import java.text.DecimalFormat;

public abstract class TimeUnits
{

	public static final double SECCONDS_TO_MILLISECONDS = 1000.0;
	public static final double MINUTES_TO_SECONDS = 60.0;
	public static final double HOURS_TO_MINUTES = 60.0;
	public static final double DAYS_TO_HOURS = 24.0;
	public static final double DAYS_TO_WEEKS = 7.0;
	public static final double WEEKS_TO_MONTHS = 4.34524;
	public static final double DAYS_TO_MONTHS = 30.4167;
	
	public abstract double get();
	public abstract void set(double num);
	
	public abstract double toMilliseconds();
	public abstract double toSeconds();
	public abstract double toMinutes();
	public abstract double toHours();
	public abstract double toDays();
	public abstract double toWeeks();
	public abstract double toMonths();

	public void add(double num)
	{
		set(get() + num);
	}
	
	public void subtract(double num)
	{
		add(-num);
	}
	
	public boolean isEmpty()
	{
		return get() == 0;
	}
	
	
	//===================================================
	// returns string representation of class
	//===================================================
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#,###,###,###.##");
		return df.format(get());
	}
	
}
