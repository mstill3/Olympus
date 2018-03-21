package com.stillwell.olympus.athena.polygon.trig;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Shape extends JPanel
{

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawOval(10, 10, 10, 10);
	}
	
	public int mean(int[] list)
	{
		int sum = 0;
		for(int num : list)
			sum += num;
		return sum/list.length;
	}
	
}
