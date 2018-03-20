package com.stillwell.olympus.athena.polygon.turn;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Triangleaaa extends JFrame {

	private int[] xPoints = new int[]{0, 25, 50};
	private int[] yPoints = new int[]{50, 0, 50};

	double angle = 0f;
	double direction = 0f;

	public Triangleaaa()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new DrawTrianglePanel());
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 87)
				{
					direction = 0;
				}
				else if(e.getKeyCode() == 68)
				{
					direction = 90;
				}
				else if(e.getKeyCode() == 83)
				{
					direction = 180;
				}
				else if(e.getKeyCode() == 65)
				{
					direction = 270;
				}

//				System.out.println("angle " + angle);
//				System.out.println("direction " + direction);
				
//				double directionPlus = direction+360;
//				System.out.println("direction+ " + (directionPlus));
				
				boolean turnLeft = false;
				boolean turnRight = false;
//				System.out.println("fffff" + Math.abs(direction - angle));
//				System.out.println("fddddd" + Math.abs(360 + angle - direction));


//				double n1 = directionPlus - angle;
//				double n2 = angle - direction;
				
//				System.out.println(n1);
//				System.out.println(n2);
//				
//				if(n1 < n2)
//				{
//					turnLeft = true;
//					turnRight = false;
//				} else if(n1 > n2)
//				{
//					turnLeft = false;
//					turnRight = true;
//				} else
//				{
//						turnLeft = false;
//						turnRight = false;
//				}

//				if(angle < direction)
//				{
//					turnLeft = false;
//					turnRight = true;
//				}
//				else if(angle > direction)
//				{
//					turnLeft = true;
//					turnRight = false;
//				}
//				else
//				{
//					turnLeft = false;
//					turnRight = false;
//				}
				//else if(angle > direction)

				
//				System.out.println(smallestCircularDistance(angle, direction));
				
				if(smallestCircularDistance(angle, direction) > 0)
					turnRight = true;
				else if(smallestCircularDistance(angle, direction) < 0)
					turnLeft = true;
				else
				{
					turnLeft = false;
					turnRight = false;
				}
				
				if(turnRight)
					angle+=5;
				if(turnLeft)
					angle-=5;

				repaint();

			}
		});        pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public double smallestCircularDistance(double angle1, double angle2)
	{
//		double distance = 0;
//		System.out.println(angle1 + "   " + angle2 + "   " + (angle2-angle1));
		
		if(angle >= 360)
			angle -= 360;
		
		double dist1 = angle2 - angle1;
		double dist2 = angle2 - (360 + angle1);
		
		System.out.println(angle1 + "   " + angle2 + "   " + dist1 + "   " + dist2);
		
//		System.out.println(dist1);
//		System.out.println(dist2);
		
		if(Math.abs(dist1) < Math.abs(dist2))
			return dist1;
		return dist2;
		
//		return angle2 - angle1;
	}

	private class DrawTrianglePanel extends JPanel {

		private Point clickPoint;

		public DrawTrianglePanel()
		{
			//            addMouseListener(this);
			//            addMouseMotionListener(this);
			//           
			clickPoint = new Point(100, 100);
		}

		@Override
		public Dimension getPreferredSize()
		{
			return new Dimension(200, 200);
		}

		protected Dimension getTriangleSize() {

			int maxX = 0;
			int maxY = 0;
			for (int index = 0; index < xPoints.length; index++) {
				maxX = Math.max(maxX, xPoints[index]);
			}
			for (int index = 0; index < yPoints.length; index++) {
				maxY = Math.max(maxY, yPoints[index]);
			}
			return new Dimension(maxX, maxY);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g.create();
			AffineTransform at = new AffineTransform();
			Dimension size = getTriangleSize();
			int x = clickPoint.x - (size.width / 2);
			int y = clickPoint.y - (size.height / 2);
			at.translate(x, y);
			at.rotate(Math.toRadians(angle), clickPoint.x - x, clickPoint.y - y);
			g2d.setTransform(at);
			g2d.drawPolygon(xPoints, yPoints, 3);
			// Guide
			g2d.setColor(Color.RED);
			g2d.drawLine(size.width / 2, 0, size.width / 2, size.height / 2);
			g2d.dispose();

		}

		public void mouseDragged(MouseEvent e) {
			System.out.println("Mouse dragged called");

			angle = -Math.toDegrees(Math.atan2(e.getPoint().x - clickPoint.x, e.getPoint().y - clickPoint.y)) + 180;

			repaint();
		}

	}
	
	public int moduluo(int num, int base)
	{
		return num % base;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				new Triangleaaa();
			}
		});
	}

}