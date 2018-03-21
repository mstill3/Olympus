package com.stillwell.olympus.athena.thread;

public class GooseThread
{

	public static void main(String[] args)
	{
		Thread thread = new Thread(new Count(), "counter");
		thread.start();
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print("how are you?");
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print("he he");
	}
	
	public static void print(String message)
	{
		
		System.out.format("%s: %s%n", Thread.currentThread().getName(), message);
	}
	
	static class Count implements Runnable
	{
		
		public void run()
		{
			print("hi");
			try
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			print("bye");
		}
	
	}
	
}
