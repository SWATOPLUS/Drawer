package Drawer;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Shavo_000
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class PolyLine extends OneDimShape {

	private List<Point> points;

	public PolyLine(Color shColor, List<Point> points) {
		super(shColor);
		this.points = points;
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
		g.drawPolyline(xPoints, yPoints, points.size());
	}

	public List<Point> getPoints(){
		return points;
	}

	/**
	 * 
	 * @param point    point
	 */
	public void move(Point point){
		int xDiff = getTheCenter().x - point.x;
		int yDiff = getTheCenter().y - point.y;
		setTheCenter(new Point(point));
		for(Point p: points){
			p.x-=xDiff;
			p.y-=yDiff;
		}
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setPoints(List<Point> newVal){
		points = newVal;
	}

}