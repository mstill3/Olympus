package com.stillwell.olympus.athena.shape;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		new Frame();
	}
	
	public Frame()
	{
		setSize(500, 500);
		getContentPane().add(new Panel());
		setVisible(true);
	}
	
	private class Panel extends JPanel
	{
		
		private static final long serialVersionUID = 1L;

		public void paint(Graphics gc)
		{
//			EquilateralTriangle tri = new EquilateralTriangle(60, 60, 60);
//			RightTriangle tri = new RightTriangle(60, 60, 60, 60, false);
			IsoscelesTriangle tri = new IsoscelesTriangle(60, 60, 100, 60, Color.green);
			tri.paint(gc);
		}
		
	}
	
}
