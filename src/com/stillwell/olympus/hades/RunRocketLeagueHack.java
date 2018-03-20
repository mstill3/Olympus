package com.stillwell.olympus.hades;

public class RunRocketLeagueHack
{

	public static void main(String[] args)
	{
	
		//Click here before 
		
		MyKeyThread th1 = new MyKeyThread('w');
		MyKeyThread th2 = new MyKeyThread('a');
		MyKeyThread th3 = new MyKeyThread('q');
		
		th1.start();
		th2.start();
		th3.start();
		
	}
	
}
