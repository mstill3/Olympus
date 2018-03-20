package com.stillwell.olympus.athena.polygon.trig;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Triangle extends JPanel
{

	private Point p1, p2, p3;

	public Triangle(Point p1, Point p2, Point p3)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public int[] getXPoints()
	{
		int[] xs = new int[3];
		xs[0] = p1.getX();
		xs[1] = p2.getX();
		xs[2] = p3.getX();
		return xs;
	}

	public int[] getYPoints()
	{
		int[] ys = new int[3];
		ys[0] = p1.getY();
		ys[1] = p2.getY();
		ys[2] = p3.getY();
		return ys;
	}

	public void rotate()
	{

//		System.out.println(Math.cos(cen));
		int FACTOR = 1;

		p1.setX((int) (p1.getX() + (Math.cos(mean(getXPoints()) - p1.getX()) * FACTOR)));
		p1.setY((int) (p1.getY() + (Math.sin(mean(getYPoints()) - p1.getY()) * FACTOR)));

//		p2.setX((int) (p2.getX() + (Math.cos(theta) * FACTOR)));
//		p2.setY((int) (p2.getY() + (Math.sin(theta) * FACTOR)));
//		
//		p3.setX((int) (p3.getX() + (Math.cos(theta) * FACTOR)));
//		p3.setY((int) (p3.getY() + (Math.sin(theta) * FACTOR)));
		
		//		System.out.println(p1.getX());
		//		
		//		p2.setX((int) (p2.getX() + (Math.cos(theta) * FACTOR)));
		//		p2.setY((int) (p2.getY() + (Math.sin(theta) * FACTOR)));
		//		
		//		p3.setX((int) (p3.getX() + (Math.cos(theta) * FACTOR)));
		//		p3.setY((int) (p3.getY() + (Math.sin(theta) * FACTOR)));

	}

	public void paint(Graphics g)
	{
		paintBackground(g);
		paintCenter(g);
		g.drawPolygon(getXPoints(), getYPoints(), 3);
	}

	public void paintCenter(Graphics g)
	{
		super.paint(g);
		int centerSize = 4;
		g.drawOval(mean(getXPoints()) - centerSize/2, mean(getYPoints()) - centerSize/2, centerSize, centerSize);
	}

	public void paintBackground(Graphics g)
	{
		super.paint(g);
		g.clearRect(0, 0, 300, 300);
	}

	private int mean(int[] list)
	{
		int sum = 0;
		for(int num : list)
			sum += num;
		return sum/list.length;
	}

}
