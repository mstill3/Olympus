package com.stillwell.olympus.athena.polygon.trig;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JPanel;

public class Shape extends JPanel
{

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawOval(10, 10, 10, 10);
	}
	
	private int mean(int[] list)
	{
		int sum = 0;
		for(int num : list)
			sum += num;
		return sum/list.length;
	}
	
}
