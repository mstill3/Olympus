package com.stillwell.olympus.athena.thread.keys;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame
{

	private static final long serialVersionUID = 1L;

	KeyListen lis, lis2, lis3;
	Thread thread1, thread2, thread3;

	public static void main(String[] args)
	{
		new Frame();
	}
	
	public Frame()
	{
		
		lis = new KeyListen(this);
//		lis2 = new KeyListen(this, 2);
//		lis3 = new KeyListen(this, 3);		
		
		thread1 = new KeyListenThread(lis, 1);
		thread2 = new KeyListenThread(lis, 2);
//		thread3 = new KeyListenThread(lis3, "tres");
		
		thread1.start();
//		thread2.start();
//		thread3.start();
		
		setSize(500, 250);
		setVisible(true);
	}
	
	public class Pan extends JPanel
	{
	
		private static final long serialVersionUID = 1L;

		public void paint(Graphics gc)
		{
//			gc.setColor(Color);
		}
	}
	
}
