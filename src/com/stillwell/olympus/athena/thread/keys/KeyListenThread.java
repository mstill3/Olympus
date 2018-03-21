package com.stillwell.olympus.athena.thread.keys;

public class KeyListenThread extends Thread
{

	KeyListen listen;
	int type;
	
	public KeyListenThread(KeyListen l, int type)
	{
		listen = new KeyListen(l.frame, type);
		this.type = type;
	}
	
	public synchronized void start()
	{
		run();
	}
	
	public void run()
	{
		listen.run();
	}
	
}
