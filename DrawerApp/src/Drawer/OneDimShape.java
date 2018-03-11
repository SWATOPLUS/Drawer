package Drawer;

import java.awt.*;


public abstract class OneDimShape extends Shape {

	public OneDimShape(Color shColor){
        super(shColor);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public abstract void draw(Graphics g);

	public abstract void move(Point point);

}