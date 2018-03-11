package Drawer;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Шевцов
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class Rhombus extends Rectangle {


	public Rhombus(Color shColor, Color shFillColor, List<Point> points){
		super(shColor, shFillColor, points);
		List<Point> newPoints = new ArrayList<>(points.size());
		newPoints.add(new Point(getAddPoint().x, getTheCenter().y));
		newPoints.add(new Point(getTheCenter().x, getAddPoint().y));
		newPoints.add(new Point(2*getTheCenter().x - getAddPoint().x, getTheCenter().y));
		newPoints.add(new Point(getTheCenter().x, 2*getTheCenter().y - getAddPoint().y));
		setPoints(newPoints);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}