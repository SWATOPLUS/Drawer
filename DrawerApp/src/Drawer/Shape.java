package Drawer;

import java.awt.*;

public abstract class Shape {

	private Color shapeColor;
	private Point theCenter;

	public Shape(Color shColor){
	    setShapeColor(shColor);
	}

	public abstract void draw(Graphics g);

	public Color getShapeColor(){
		return shapeColor;
	}

	public Point getTheCenter(){
		return new Point(theCenter.x, theCenter.y);
	}

	public abstract void move(Point point);

	public void setShapeColor(Color newVal){
		shapeColor = newVal;
	}

	public void setTheCenter(Point newVal){
		theCenter = newVal;
	}

}