package Drawer;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Шевцов
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class IsoscelesTriangle extends RightTriangle {


	public IsoscelesTriangle(Color shColor, Color shFillColor, List<Point> points){
		super(shColor, shFillColor, points);
		points.add(new Point(2*getAddPoint().x - points.get(2).x, getAddPoint().y));
		points.remove(0);
		setPoints(points);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}