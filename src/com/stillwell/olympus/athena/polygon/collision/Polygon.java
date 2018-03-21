package com.stillwell.olympus.athena.polygon.collision;

import java.util.ArrayList;

public class Polygon extends java.awt.Polygon
{
	
	private static final long serialVersionUID = 1L;

	public Polygon(int[] xpoints, int[] ypoints, int length)
	{
		super(xpoints, ypoints, length);
	}

	public Polygon(ArrayList<Point> points)
	{
		npoints = points.size();
		xpoints = new int[npoints];
		ypoints = new int[npoints];
		for(int i = 0; i < npoints; i++)
		{
			xpoints[i] = points.get(i).getX();
			ypoints[i] = points.get(i).getY();
		}
	}

	public void shiftX(int x)
	{
		int mean = mean(xpoints);
		int[] distanceFromMid = new int[xpoints.length];
		for(int i = 0; i < npoints; i++)
			distanceFromMid[i] = xpoints[i] - mean;
			
		for(int i = 0; i < npoints; i++)
			xpoints[i] = x + distanceFromMid[i];
	}
	
	public void shiftY(int y)
	{
		int mean = mean(ypoints);
		int[] distanceFromMid = new int[ypoints.length];
		for(int i = 0; i < npoints; i++)
			distanceFromMid[i] = ypoints[i] - mean;
		
			
		for(int i = 0; i < npoints; i++)
			ypoints[i] = y + distanceFromMid[i];
	}

	private int mean(int[] list)
	{
		int sum = 0;
		for(int num : list)
			sum += num;
		return sum/list.length;
	}
	
}
