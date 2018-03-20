package com.stillwell.olympus.athena.polygon.turn;

import java.util.ArrayList;

public class Polygon extends java.awt.Polygon
{
	
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
	
	public void rotate(double theta)
	{
		
		int centerX = mean(xpoints);
		int centerY = mean(ypoints);
		
		System.out.println("X1 " + xpoints[0]);
		System.out.println("Y1 " + ypoints[0]);


	System.out.println("centerX " + centerX);
	System.out.println("centerY " + centerY);
	
	System.out.println("radius to point 1 X" + Math.abs(xpoints[0] - centerX));
	System.out.println("radius to point 1 Y" + Math.abs(ypoints[0] - centerY));
	
	xpoints[0] = (int) (xpoints[0] + Math.abs(xpoints[0] - centerX) * Math.cos(theta));
	ypoints[0] = (int) (ypoints[0] + Math.abs(ypoints[0] - centerY) * Math.sin(theta));

		
		
//		System.out.println("fd");
//		for(int x = 0; x < xpoints.length; x++)
//			xpoints[x] = (int) (xpoints[x] + Math.cos(theta) * 10);
		
//		for(int y = 0; y < ypoints.length; y++)
//			ypoints[y] = (int) (ypoints[y] + Math.sin(theta) * 10);
	}

	private int mean(int[] list)
	{
		int sum = 0;
		for(int num : list)
			sum += num;
		return sum/list.length;
	}
	
}
