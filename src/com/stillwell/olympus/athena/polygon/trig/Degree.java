package com.stillwell.olympus.athena.polygon.trig;

public class Degree extends Angle
{

	private double degree;

	public Degree()
	{
		set(0);
	}

	public Degree(double d)
	{
		set(d);
	}

	public void set(double d)
	{
		degree = d;
		modulo360();
	}

	public double get()
	{
		return degree;	
	}
	
	public Degree toRadian()
	{
		return new Degree((get() * Math.PI) / 180);
	}
	
	public double cos()
	{
		return Math.cos(toRadian().get());
	}
	
	public double sin()
	{
		return Math.sin(toRadian().get());
	}
	
	public void increment()
	{
		set(get() + 1);
		modulo360();
	}
	
	public void decrement()
	{
		set(get() - 1);
		modulo360();
	}
	
	public void increment(int n)
	{
		set(get() + n);
		modulo360();
	}
	
	public void decrement(int n)
	{
		set(get() - n);
		modulo360();
	}
	
	public void modulo360()
	{
		while(get() > 360)
			decrement(360);
		while(get() < 0)
			increment(360);
	}
	
	@Override
	public String toString()
	{
		return get() + "°"; //0176
	}

}
