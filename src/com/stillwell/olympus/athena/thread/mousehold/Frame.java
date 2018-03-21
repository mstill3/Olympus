package com.stillwell.olympus.athena.thread.mousehold;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class Frame extends JFrame
{

	private static final long serialVersionUID = 1L;

	MouseHold hold;
	Thread thread;

	public static void main(String[] args)
	{
		new Frame();
	}
	
	public Frame()
	{
		
		hold = new MouseHold();
		thread = new Thread(hold);
		
		setSize(500, 250);
		
		addMouseListener(new MouseListener()
		{
			
			public void mousePressed(MouseEvent e)
			{
				hold.press();
				
				thread = new Thread(hold);
				thread.start();
			}
			
			public void mouseReleased(MouseEvent e) 
			{
				hold.unpress();
			}
			
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
		setVisible(true);
	}
	
}
