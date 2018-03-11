package Drawer;

/**
 * @author Шевцов
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public class Polygon extends TwoDimShape {

	private list<Point> points;

	public Polygon(){

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