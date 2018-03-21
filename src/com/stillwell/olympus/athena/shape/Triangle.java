package com.stillwell.olympus.athena.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class Triangle extends JPanel
{

	private static final long serialVersionUID = 1L;

	protected int[] xs;
	protected int[] ys;
	protected Color color;
	
	public Triangle()
	{
		xs = new int[3];
		ys = new int[3];
		color = Color.black;
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void paint(Graphics gc)
	{
		gc.setColor(color);
		gc.fillPolygon(new Polygon(xs, ys, 3));
	}
	
}
