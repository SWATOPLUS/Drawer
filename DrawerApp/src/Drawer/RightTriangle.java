package Drawer;

/**
 * @author ������
 * @version 1.0
 * @created 11-���-2018 10:39:15
 */
public class RightTriangle extends Polygon {

	private Point addPoint;

	public RightTriangle(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Point getAddPoint(){
		return addPoint;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setAddPoint(Point newVal){
		addPoint = newVal;
	}

}