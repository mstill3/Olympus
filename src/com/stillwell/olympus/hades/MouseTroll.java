package com.stillwell.olympus.hades;

public class MouseTroll
{

	public static void main(String[] args)
	{

		MyMouseThread th1 = new MyMouseThread(MyMouseThread.NORTH);
		MyMouseThread th2 = new MyMouseThread(MyMouseThread.WEST);

		th1.start();
		th2.start();

	}

}
