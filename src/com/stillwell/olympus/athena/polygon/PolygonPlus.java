package com.stillwell.olympus.athena.polygon;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

public class PolygonPlus extends Polygon
{

    private static final long serialVersionUID = 1L;

    public PolygonPlus(int[] xPoints, int[] yPoints)
    {
        super(xPoints, yPoints, xPoints.length);
        setOriginalPoints(getPoints(xPoints, yPoints));
    }

    public void setXs(int[] xPoints)
    {
        xpoints = xPoints;
    }

    public void setYs(int[] yPoints)
    {
        ypoints = yPoints;
    }

    public void setPoints(Point[] points)
    {
        for (int i = 0; i < npoints; i++)
        {
            xpoints[i] = (int) points[i].getX();
            ypoints[i] = (int) points[i].getY();
        }
    }

    public Point[] getPoints(int[] xPoints, int[] yPoints)
    {
        Point[] ps = new Point[xpoints.length];
        for (int i = 0; i < xPoints.length; i++)
            ps[i] = new Point(xpoints[i], ypoints[i]);
        return ps;
    }

    public void polygonize(Point[] polyPoints)
    {
        reset();
        for (int i = 0; i < polyPoints.length; i++)
            addPoint(polyPoints[i].x, polyPoints[i].y);
    }

    public Point[] rotatePointMatrix(double angle)
    {
        Point[] origPoints = getOriginalPoints();
        Point[] rotatedPolygon = new Point[npoints];
        for (int i = 0; i < rotatedPolygon.length; i++)
            rotatedPolygon[i] = new Point(0, 0);
        AffineTransform.getRotateInstance(Math.toRadians(angle), getCenter().getX(), getCenter().getY())
                .transform(origPoints, 0, rotatedPolygon, 0, npoints);
        return rotatedPolygon;
    }

    public Point getCenter()
    {
        int midX = 0;
        int midY = 0;

        for (int i = 0; i < npoints; i++)
        {
            midX += xpoints[i];
            midY += ypoints[i];
        }

        midX /= npoints;
        midY /= npoints;

        return new Point(midX, midY);
    }

    public Point[] getPoints()
    {
        Point[] points = new Point[npoints];
        for (int i = 0; i < npoints; i++)
            points[i] = new Point(xpoints[i], ypoints[i]);
        return points;
    }

    private Point[] originalPoints;

    public void setOriginalPoints(Point[] points)
    {
        originalPoints = new Point[points.length];
        for (int i = 0; i < points.length; i++)
            originalPoints[i] = points[i];
    }

    public Point[] getOriginalPoints()
    {
        return originalPoints;
    }

    public void print(int[] points)
    {
        System.out.println("{");
        for (int i : points)
            System.out.println(i + ", ");
        System.out.println("}");
    }

    public void print(Point[] points)
    {
        System.out.print("{");
        for (Point p : points)
            System.out.print("{" + p.getX() + ", " + p.getY() + "}");
        System.out.print("}\n");
    }

}
