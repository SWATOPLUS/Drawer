package Drawer;

import java.awt.*;

/**
 * @author Shavo_000
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class Line extends Ray {


	public Line(Color shColor, Point center, Point b) {
		super(shColor, center, b);
	}

	@Override
	public void draw(Graphics g){
		super.draw(g);
		drawRayFromTo(g,getB(),getTheCenter());
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}