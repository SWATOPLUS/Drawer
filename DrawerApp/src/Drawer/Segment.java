package Drawer;


import java.awt.*;

public class Segment extends OneDimShape {

	private Point b;

	public Segment(Color shColor, Point center, Point b){
        super(shColor);
        setTheCenter(center);
        setB(b);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(Graphics g){
        g.setColor(getShapeColor());
        g.drawLine(getTheCenter().x, getTheCenter().y, b.x, b.y);
	}

	public Point getB(){
		return b;
	}

	public void move(Point point){
        int xDiff = getTheCenter().x - point.x;
        int yDiff = getTheCenter().y - point.y;
        setTheCenter(new Point(point));
        int newBx = b.x - xDiff;
        int newBy = b.y - yDiff;
        setB(new Point(newBx,newBy));
	}

	public void setB(Point newVal){
		b = newVal;
	}

}