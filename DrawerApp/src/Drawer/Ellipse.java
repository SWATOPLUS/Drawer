package Drawer;

import java.awt.*;

/**
 * @author Шевцов
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class Ellipse extends TwoDimShape {

	private Point addPoint;

	public Ellipse(Color shColor) {
		super(shColor);
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(){

	}

	public Point getAddPoint(){
		return addPoint;
	}

	@Override
	public void draw(Graphics g) {

	}

	/**
	 * 
	 * @param point    point
	 */
	public void move(Point point){

	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setAddPoint(Point newVal){
		addPoint = newVal;
	}

}