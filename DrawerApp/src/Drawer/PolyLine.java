package Drawer;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Shavo_000
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class PolyLine extends OneDimShape {

	private List<Point> points;

	public PolyLine(Color shColor) {
		super(shColor);
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public void draw(Graphics g) {

	}

	public void draw(){

	}

	public List<Point> getPoints(){
		return points;
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