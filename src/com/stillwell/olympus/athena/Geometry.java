package com.stillwell.olympus.athena;
import java.awt.Shape;
import java.awt.geom.Area;

public class Geometry
{

	public static boolean intersection(Shape shapeA, Shape shapeB)
	{
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
		return !areaA.isEmpty();
	}
	
}
