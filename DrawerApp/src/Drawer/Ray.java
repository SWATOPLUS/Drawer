package Drawer;


import java.awt.*;

public class Ray extends Segment {

	public Ray(Color shColor, Point center, Point b){
	    super(shColor, center, b);


	}

	@Override
	public void draw(Graphics g){
		drawRayFromTo(g,getTheCenter(),getB());
	}

	protected void drawRayFromTo(Graphics g, Point from,Point to){
		int x = from.x + (to.x - from.x)*10000;
		int y = from.y + (to.y - from.y)*10000;
		g.setColor(getShapeColor());
		g.drawLine(from.x,from.y, x,y);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}