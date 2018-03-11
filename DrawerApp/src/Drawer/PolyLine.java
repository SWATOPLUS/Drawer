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

	public PolyLine(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(){

	}

	public list<Point> getPoints(){
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
	public void setPoints(list<Point> newVal){
		points = newVal;
	}

}