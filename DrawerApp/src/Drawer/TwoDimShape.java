package Drawer;

/**
 * @author Shavo_000
 * @version 1.0
 * @created 11-мар-2018 10:39:15
 */
public abstract class TwoDimShape extends Shape {

	private Color shapeFillColor;

	public TwoDimShape(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public abstract void draw();

	public Color getShapeFillColor(){
		return shapeFillColor;
	}

	/**
	 * 
	 * @param point    point
	 */
	public abstract void move(Point point);

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setShapeFillColor(Color newVal){
		shapeFillColor = newVal;
	}

}