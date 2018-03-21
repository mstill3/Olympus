package com.stillwell.olympus.athena.polygon.turn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Pan extends JPanel
{
	
	private static final long serialVersionUID = 1L;

	int xPoly[] = {150, 250, 325, 375};
    int yPoly[] = {150, 100, 125, 225};
	Polygon p1 = new Polygon(xPoly, yPoly, xPoly.length);

	public Pan()
	{
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				p1.rotate(1);
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
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);

			g.setColor(Color.orange);
		g.fillPolygon(p1);

	}
	
//	//TRANSLATE TO ORIGIN
//	double x1 = p1.getX() - center.x;
//	double y1 = p1.getY() - center.y;
//
//	//APPLY ROTATION
//	double temp_x1 = x1 * Math.cos(angle) - y1 * Math.sin(angle));
//	double temp_y1 = x1 * Math.sin(angle) + y1 * Math.cos(angle));
//
//	//TRANSLATE BACK
//	p1.setLocation(temp_x1 + center.x, temp_y1 + center.y);




}
