package com.stillwell.olympus.athena.polygon.turn;

public class Point
{

	private int x;
	private int y;
	
	public Point()
	{
		setX(0);
		setY(0);
	}
	
	public Point(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	public Point(Point p)
	{
		setX(p.x);
		setY(p.y);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
}
