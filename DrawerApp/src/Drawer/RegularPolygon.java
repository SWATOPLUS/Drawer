package Drawer;

/**
 * @author ������
 * @version 1.0
 * @created 11-���-2018 10:39:15
 */
public class RegularPolygon extends Polygon {

	private Point addPoint;
	private int amount;

	public RegularPolygon(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Point getAddPoint(){
		return addPoint;
	}

	public int getAmount(){
		return amount;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setAddPoint(Point newVal){
		addPoint = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(int newVal){
		amount = newVal;
	}

}