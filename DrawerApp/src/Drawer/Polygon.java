package Drawer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polygon extends TwoDimShape {

	private List<Point> points;

	public Polygon(Color shColor, Color shFillColor, List<Point> points){
		super(shColor, shFillColor);
		setPoints(points);
		setTheCenter(points.get(0));
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(Graphics g){
		int[] xPoints = new int[points.size()];
		int[] yPoints = new int[points.size()];
		for(int i=0;i<points.size();i++){
			xPoints[i] = points.get(i).x;
			yPoints[i] = points.get(i).y;
		}
		g.setColor(getShapeColor());
		g.drawPolygon(xPoints, yPoints, points.size());
		g.setColor(getShapeFillColor());
		g.fillPolygon(xPoints, yPoints, points.size());
	}

	public List<Point> getPoints(){
		return points;
	}

	public void move(Point point){
		int xDiff = getTheCenter().x - point.x;
		int yDiff = getTheCenter().y - point.y;
		setTheCenter(new Point(point));
		for(Point p: points){
			p.x-=xDiff;
			p.y-=yDiff;
		}
	}

	public void setPoints(List<Point> newVal){
		points = newVal;
	}

}