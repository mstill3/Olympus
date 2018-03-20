package com.stillwell.olympus.hades;
public class MyKeyThread implements Runnable
{

	private Thread t;
	private String threadName;
	private char letter;
	private int count;

	public MyKeyThread(char c)
	{
		letter = c;
		count = 0;
	}

	public void run()
	{   
		try
		{
			for(double d = 0; d < 1000000000; d+=.1) 
			{
				Hack.pressKey(letter);
				Thread.sleep(100);
			}
		} 
		catch (InterruptedException e)
		{
			System.out.println("   Thread " +  threadName + " was interrupted.");
		}
		System.out.println("    Thread " +  threadName + " is exiting.");
	}

	public void start ()
	{
		count++;
		threadName = "thr" + count;
		System.out.println("     Starting Thread " +  threadName );
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start ();
		}
	}

}