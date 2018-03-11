package Drawer;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Шевцов
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class RegularPolygon extends Polygon {

	private Point addPoint;
	private int amount;

	public RegularPolygon(Color shColor, Color shFillColor, List<Point> points, int amount){
		super(shColor, shFillColor, points);
		setAmount(amount);
		setAddPoint(points.get(1));
		points.remove(0);
		double r = Math.sqrt((getTheCenter().x - getAddPoint().x)*(getTheCenter().x - getAddPoint().x) + (getTheCenter().y - getAddPoint().y)*(getTheCenter().y - getAddPoint().y));
		double angle = Math.acos((getAddPoint().x - getTheCenter().x)/r);
		double z=angle;
		int i=1;
		while(i<amount){
			z+=2*Math.PI/amount;
			int newX = getTheCenter().x + (int)Math.round(Math.cos(z)*r);
			int newY = getTheCenter().y - (int)Math.round(Math.sin(z)*r);
			points.add(i, new Point(newX, newY));
			i++;
		}
		setPoints(points);
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

	public Point getAddPoint(){
		return addPoint;
	}

	public int getAmount(){
		return amount;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setAddPoint(Point newVal){
		addPoint = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(int newVal){
		amount = newVal;
	}

}