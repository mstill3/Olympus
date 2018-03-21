package com.stillwell.olympus.athena.thread.keys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen implements Runnable, KeyListener
{

	Frame frame;
	int n;
	
	public KeyListen(Frame f)
	{
		frame = f;
		n = 0;
	}
	
	public KeyListen(Frame f, int i)
	{
		frame = f;
		n = i;
	}
	
	public void run()
	{
		frame.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e)
	{
		if(n == 1)
		{ 
			if(e.getKeyCode() == 87)
				System.out.println("w");
			else if(e.getKeyCode() == 68)
				System.out.println("s");
			else if(e.getKeyCode() == 65)
				System.out.println("a");
			else if(e.getKeyCode() == 83)
				System.out.println("d");
		}
		else if(n == 2)
		{ 
			if(e.getKeyCode() == 38)
				System.out.println("u");
			else if(e.getKeyCode() == 40)
				System.out.println("d");
			else if(e.getKeyCode() == 37)
				System.out.println("l");
			else if(e.getKeyCode() == 39)
				System.out.println("r");
		}
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
