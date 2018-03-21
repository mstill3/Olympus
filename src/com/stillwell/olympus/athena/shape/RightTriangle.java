package com.stillwell.olympus.athena.shape;

public class RightTriangle extends Triangle
{

	private static final long serialVersionUID = 1L;

	public RightTriangle(int x, int y, int length, int width, boolean right)
	{
		super();
		
		xs[0] = x;
		if(right)
			xs[1] = x + width;
		else
			xs[1] = x;
		xs[2] = x + width;

		ys[0] = y + length;
		ys[1] = y;
		ys[2] = y + length;
	}

}
