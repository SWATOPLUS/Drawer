package Drawer;

import java.awt.*;
import java.util.List;

/**
 * @author Шевцов
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class Polygon extends TwoDimShape {

	private List<Point> points;

	public Polygon(Color shColor) {
		super(shColor);
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(){

	}

	public List<Point> getPoints(){
		return points;
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
	public void setPoints(List<Point> newVal){
		points = newVal;
	}

}