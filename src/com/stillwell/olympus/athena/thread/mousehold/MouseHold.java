package com.stillwell.olympus.athena.thread.mousehold;

public class MouseHold implements Runnable
{

	private boolean pressed;
	
	public MouseHold()
	{
		unpress();
	}
	
	public void press()
	{
		pressed = true;
	}
	
	public void unpress()
	{
		pressed = false;
	}

	@Override
	public void run()
	{
		int pressDelay = 100;
		try
		{
			Thread.sleep(pressDelay);
		}
		catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
		
		while(pressed)
		{
			int refreshRate = 25;
			System.out.println("hold");
			try
			{
				Thread.sleep(refreshRate);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
