package Drawer;

import java.awt.*;
import java.util.List;

public class RightTriangle extends Polygon {

	private Point addPoint;

	public RightTriangle(Color shColor, Color shFillColor, List<Point> points){
		super(shColor, shFillColor, points);
		setAddPoint(points.get(1));
		points.remove(0);
		points.add(new Point(getAddPoint().x, 2*getTheCenter().y - getAddPoint().y));
		points.add(new Point(2*getTheCenter().x - getAddPoint().x, getAddPoint().y));
		setPoints(points);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Point getAddPoint(){
		return addPoint;
	}

	public void setAddPoint(Point newVal){
		addPoint = newVal;
	}

}