package com.stillwell.olympus.athena.thread.working;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Frame extends JFrame
{

	private static final long serialVersionUID = 1L;

	public static Thread thread;
	
	public static void main(String[] args)
	{
		new Frame();
		thread = new Thread(new Dasher());
	}
	
	public Frame()
	{
		
		setSize(500, 250);
		addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent arg0){}
			public void keyReleased(KeyEvent arg0) {}
			
			public void keyPressed(KeyEvent e)
			{
				System.out.println(e.getKeyCode());
				thread.start();
			}
		});
		setVisible(true);
	}
	
}
