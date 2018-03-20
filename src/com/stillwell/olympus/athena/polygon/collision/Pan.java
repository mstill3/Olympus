package com.stillwell.olympus.athena.polygon.collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;

import javax.swing.JPanel;

import com.stillwell.olympus.athena.Geometry;

public class Pan extends JPanel
{

//	Rectangle r1 = new Rectangle(5, 5, 20, 20);
	Rectangle r2 = new Rectangle(30, 20, 30, 30);
	
	int xPoly[] = {150, 250, 325, 375, 450, 275, 100};
    int yPoly[] = {150, 100, 125, 225, 250, 375, 300};
	Polygon p1 = new Polygon(xPoly, yPoly, xPoly.length);

	public Pan()
	{
		addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseMoved(MouseEvent e)
			{
//				r1.x = e.getX() - r1.width/2;
//				r1.y = e.getY() - r1.height/2;
				
				p1.shiftX(e.getX());
				p1.shiftY(e.getY());
				repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}
		});
	}
	


	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);

		if(Geometry.intersection(p1, r2))
			g.setColor(Color.orange);
		else
			g.setColor(Color.green);

		g.fillPolygon(p1);
//		g.fillRect(r1.x, r1.y, r1.width, r1.height);

		if(Geometry.intersection(p1, r2))
			g.setColor(Color.red);
		else
			g.setColor(Color.blue);
		g.fillRect(r2.x, r2.y, r2.width, r2.height);

	}




}
