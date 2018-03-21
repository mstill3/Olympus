package com.stillwell.olympus.athena.shape;

public class EquilateralTriangle extends Triangle
{
	
	private static final long serialVersionUID = 1L;

	public EquilateralTriangle(int x, int y, int length)
	{
		super();
	
		xs[0] = x;
		xs[1] = x + length/2;
		xs[2] = x + length;
		
		int leg = (int) Math.sqrt(Math.pow(length, 2) - Math.pow(length/2, 2)); 
		
		ys[0] = y + leg;
		ys[1] = y;
		ys[2] = y + leg;
	}

}
