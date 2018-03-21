package com.stillwell.olympus.athena.polygon.turn;

import javax.swing.JFrame;

public class Frame extends JFrame
{

	private static final long serialVersionUID = 1L;

	public Frame()
	{
		getContentPane().add(new Pan());

		setVisible(true);
		setBounds(30, 30, 800, 600);
	}
	
}
