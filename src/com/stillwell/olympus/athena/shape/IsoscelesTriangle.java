package com.stillwell.olympus.athena.shape;

import java.awt.Color;

public class IsoscelesTriangle extends Triangle
{
	
	private static final long serialVersionUID = 1L;

	public IsoscelesTriangle(int x, int y, int length, int width, Color c)
	{
		super();
	
		color = c;
		
		xs[0] = x;
		xs[1] = x + width/2;
		xs[2] = x + width;
		
		ys[0] = y + length;
		ys[1] = y;
		ys[2] = y + length;
	}

}
