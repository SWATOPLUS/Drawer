package Drawer;

import java.awt.*;
import java.util.*;

/**
 * @author Шевцов
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class RightTriangle extends Polygon {

	private Point addPoint;

	public RightTriangle(Color shColor, Color shFillColor, java.util.List<Point> points) {
		super(shColor, shFillColor, points);
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

	public Point getAddPoint(){
		return addPoint;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setAddPoint(Point newVal){
		addPoint = newVal;
	}

}