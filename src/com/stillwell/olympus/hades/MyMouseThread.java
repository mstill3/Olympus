package com.stillwell.olympus.hades;
public class MyMouseThread implements Runnable
{

	public static final int NORTH = 0, EAST = 1, WEST = 2, SOUTH = 3; 
	private int direction;
	private Thread t;

	public MyMouseThread(int direction)
	{
		this.direction = direction;
	}

	public void run()
	{   
		
		
		if(direction == NORTH)
			moveNorth();
		else if(direction == EAST)
			moveEast();
		else if(direction == WEST)
			moveWest();
		else if(direction == SOUTH)
			moveSouth();
		else
			System.out.println("Invalid Input (0 - 3)");
	}

	private void moveNorth()
	{
		try
		{
			for(double d = 0; d < 1000000000; d+=.1) 
			{
				Hack.moveMouse(Hack.getMouseX(), Hack.getMouseY()+1);
				Thread.sleep(10000);
			}
		} 
		catch (InterruptedException e)
		{}
	}

	private void moveEast()
	{
		try
		{
			for(double d = 0; d < 1000000000; d+=.1) 
			{
				Hack.moveMouse(Hack.getMouseX()+1, Hack.getMouseY());
				Thread.sleep(10000);
			}
		} 
		catch (InterruptedException e)
		{}
	}

	private void moveWest()
	{
		try
		{
			for(double d = 0; d < 1000000000; d+=.1) 
			{
				Hack.moveMouse(Hack.getMouseX()-1, Hack.getMouseY());
				Thread.sleep(100);
			}
		} 
		catch (InterruptedException e)
		{}
	}

	private void moveSouth()
	{
		try
		{
			for(double d = 0; d < 1000000000; d+=.1) 
			{
				Hack.moveMouse(Hack.getMouseX(), Hack.getMouseY()-1);
				Thread.sleep(100);
			}
		} 
		catch (InterruptedException e)
		{}
	}

	public void start ()
	{
		if (t == null)
		{
			t = new Thread (this);
			t.start ();
		}
	}

}