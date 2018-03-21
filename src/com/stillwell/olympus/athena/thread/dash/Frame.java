package com.stillwell.olympus.athena.thread.dash;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	
	private static final long serialVersionUID = 1L;

	Dasher tick;
	Thread thread;

	public static void main(String[] args)
	{
		new Frame();
	}
	
	public Frame()
	{
		
		tick = new Dasher(10);
		thread = new Thread(tick);
		
		setSize(500, 250);
		addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent e)
			{
				
			}
			
			boolean released1 = false;
			public void keyReleased(KeyEvent e)
			{
				released1 = true;
			}
			
			int lastKeyPressed = 0;
			public void keyPressed(KeyEvent e)
			{
				if(thread.isAlive() && e.getKeyCode() == lastKeyPressed && released1)
				{
					System.out.println("dash");
				}
				else
				{
					thread = new Thread(tick);
					thread.start();
					released1 = false;
				}
				
				lastKeyPressed = e.getKeyCode();
			}
			
		});
		setVisible(true);
	}
	
}
