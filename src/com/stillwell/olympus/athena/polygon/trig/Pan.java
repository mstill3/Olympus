package com.stillwell.olympus.athena.polygon.trig;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;

import javax.swing.JPanel;

import com.stillwell.olympus.athena.Geometry;

public class Pan extends JPanel
{
    Degree d = new Degree();
	int height = 50;
	public Triangle tri = new Triangle(new Point(10, height), new Point(20, 5), new Point(70, height));

	public Pan() {
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
//				tri.rotate();
				System.out.println(d);
				System.out.println("cos(theta) " + d.cos());
				System.out.println("sin(theta) " + d.sin());
				d.increment();
				repaint();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void paint(Graphics g)
	{
		tri.paint(g);
	}

}
