package com.stillwell.olympus.athena.thread;

public class GooseThread2
{

	public static void main(String[] args) throws InterruptedException
	{
		Thread thread = new Thread(new Count(), "counter");
		thread.start();
		
		while(thread.isAlive())
		{
			Thread.sleep(1000);
			System.out.println("Waiting...");
		}
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
