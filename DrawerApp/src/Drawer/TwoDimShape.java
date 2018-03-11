package Drawer;


import java.awt.*;

public abstract class TwoDimShape extends Shape {

	private Color shapeFillColor;

	public TwoDimShape(Color shColor, Color shapeFillColor){
		super(shColor);
		setShapeFillColor(shapeFillColor);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public abstract void draw(Graphics g);

	public Color getShapeFillColor(){
		return shapeFillColor;
	}

	public abstract void move(Point point);

	public void setShapeFillColor(Color newVal){
		shapeFillColor = newVal;
	}

}
