package com.stillwell.olympus.athena.time;

public class Time
{

	private Month months;
	private Week weeks;
	private Day days;
	private Hour hours;
	private Minute minutes;
	private Second seconds;
	private Millisecond milliseconds;

	public Time()
	{
		setMonths(new Month());
		setWeeks(new Week());
		setDays(new Day());		
		setHours(new Hour());
		setMinutes(new Minute());
		setSeconds(new Second());
		setMilliseconds(new Millisecond());
	}

	public Time(Millisecond milliseconds, Second seconds, Minute minutes, Hour hours, Day days, Week weeks, Month months)
	{
		setMonths(months);
		setWeeks(weeks);
		setDays(days);
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
		setMilliseconds(milliseconds);
		fixUp();
	}

	public Time(double milliseconds, double seconds, double minutes, double hours, double days, double weeks, double months)
	{
		setMonths(new Month(months));
		setWeeks(new Week(weeks));
		setDays(new Day(days));
		setHours(new Hour(hours));
		setMinutes(new Minute(minutes));
		setSeconds(new Second(seconds));
		setMilliseconds(new Millisecond(milliseconds));
		fixUp();
	}
	
	public Time(int milliseconds, int seconds, int minutes, int hours, int days, int weeks, int months)
	{
		setMonths(new Month(months));
		setWeeks(new Week(weeks));
		setDays(new Day(days));
		setHours(new Hour(hours));
		setMinutes(new Minute(minutes));
		setSeconds(new Second(seconds));
		setMilliseconds(new Millisecond(milliseconds));
		fixUp();
	}

	public Time(Second seconds, Minute minutes, Hour hours)
	{
		setMonths(new Month());
		setWeeks(new Week());
		setDays(new Day());
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
		fixUp();
	}

	public Time(int seconds, int minutes, int hours)
	{
		setMonths(new Month());
		setWeeks(new Week());
		setDays(new Day());
		setHours(new Hour(hours));
		setMinutes(new Minute(minutes));
		setSeconds(new Second(seconds));
		fixUp();
	}

	public Millisecond getMilliseconds()
	{
		return milliseconds;
	}
	
	public Second getSeconds()
	{
		return seconds;
	}

	public Minute getMinutes()
	{
		return minutes;
	}

	public Hour getHours()
	{
		return hours;
	}

	public Day getDays()
	{
		return days;
	}

	public Week getWeeks()
	{
		return weeks;
	}

	public Month getMonths()
	{
		return months;
	}
	
	public void setMilliseconds(Millisecond milliseconds)
	{
		this.milliseconds = milliseconds;
	}
	
	public void setSeconds(Second seconds)
	{
		this.seconds = seconds;
	}

	public void setMinutes(Minute minutes)
	{
		this.minutes = minutes;
	}

	public void setHours(Hour hours)
	{
		this.hours = hours;
	}

	public void setDays(Day days)
	{
		this.days = days;
	}

	public void setWeeks(Week weeks)
	{
		this.weeks = weeks;
	}

	public void setMonths(Month months)
	{
		this.months = months;
	}
	
	private void fixUp()
	{

		boolean run0 = true;

		while(run0)
		{
			if(milliseconds.get() >= 1000)
			{
				milliseconds.subtract(1000);
				seconds.add(1);
			}
			else
			{
				run0 = false;
			}
		}
		
		boolean run1 = true;

		while(run1)
		{
			if(seconds.get() >= 60)
			{
				seconds.subtract(60);
				minutes.add(1);
			}
			else
			{
				run1 = false;
			}
		}

		boolean run2 = true;

		while(run2)
		{
			if(minutes.get() >= 60)
			{
				minutes.subtract(60);
				hours.add(1);
			}
			else
			{
				run2 = false;
			}
		}

		boolean run3 = true;

		while(run3)
		{
			if(hours.get() >= 24)
			{
				hours.subtract(24);
				days.add(1);
			}
			else
			{
				run3 = false;
			}
		}

		boolean run4 = true;

		while(run4)
		{
			if(days.get() >= 7)
			{
				days.subtract(7);
				weeks.add(1);
			}
			else
			{
				run4 = false;
			}
		}
		
		boolean run5 = true;

		while(run5)
		{
			if(weeks.get() >= 4)
			{
				weeks.subtract(4);
				months.add(1);
			}
			else
			{
				run5 = false;
			}
		}

	}

	public String toString()
	{
		
		String str = "";

		if(!months.isEmpty())
			str += months + "     ";
		
		if(!weeks.isEmpty())
			str += weeks + "     ";
		
		if(!days.isEmpty())
			str += days + "     ";

		if(!hours.isEmpty())
			str += hours + "     ";
		
		if(!minutes.isEmpty())
			str += minutes + "     ";
		
		if(!seconds.isEmpty())
			str += seconds + "     ";
		
		if(!milliseconds.isEmpty())
			str += milliseconds + "     ";
		
		return str;
		
	}
	
	
	public static void sleepy(TimeUnits time)
	{
		try {
			System.out.println(time.toMilliseconds());
			Thread.sleep((int) time.toMilliseconds());
			System.out.println("Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
