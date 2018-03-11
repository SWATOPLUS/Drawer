package Drawer;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Шевцов
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class Rectangle extends RightTriangle {


	public Rectangle(Color shColor, Color shFillColor, List<Point> points){
		super(shColor, shFillColor, points);
		points.add(2, new Point(2*getTheCenter().x - getAddPoint().x, 2*getTheCenter().y - getAddPoint().y));
		setPoints(points);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}