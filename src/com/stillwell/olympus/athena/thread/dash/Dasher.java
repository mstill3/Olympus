package com.stillwell.olympus.athena.thread.dash;

public class Dasher implements Runnable
{

	int timeBetween;
	int count;
	
	public Dasher(int timeBetween)
	{
		this.timeBetween = timeBetween;
		count = 0;
	}

	@Override
	public void run()
	{
		while(count < timeBetween)
		{
			count++;
//			System.out.println(count);
			try
			{
				Thread.sleep(25);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		count = 0;
	}

}
