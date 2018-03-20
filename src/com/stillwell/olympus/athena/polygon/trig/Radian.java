package com.stillwell.olympus.athena.polygon.trig;

public class Radian extends Angle
{

	private double radian;

	public Radian()
	{
		set(0);
	}

	public Radian(double d)
	{
		set(d);
	}

	public void set(double d)
	{
		radian = d;
		modulo2PI();
	}

	public double get()
	{
		return radian;	
	}
	
	public Degree toDegree()
	{
		return new Degree((get() * 180) / Math.PI);
	}
	
	public double cos()
	{
		return Math.cos(get());
	}
	
	public double sin()
	{
		return Math.sin(get());
	}
	
	public void increment()
	{
		set(get() + 0.0174533);
		modulo2PI();
	}
	
	public void decrement()
	{
		set(get() - 0.0174533);
		modulo2PI();
	}
	
	public void increment(int n)
	{
		set(get() + n);
		modulo2PI();
	}
	
	public void decrement(int n)
	{
		set(get() - n);
		modulo2PI();
	}
	
	public void modulo2PI()
	{
		while(get() > 2)
			decrement(2);
		while(get() < 0)
			increment(2);
	}
	
	@Override
	public String toString()
	{
		return get() + " PI"; //227
	}

}
