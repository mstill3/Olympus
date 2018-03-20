package com.stillwell.olympus.athena.polygon.trig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Frame extends JFrame
{

	public Frame()
	{
		getContentPane().add(new Pan());

		setVisible(true);
		setBounds(30, 30, 800, 600);
	}
	
}
