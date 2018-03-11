package Drawer;


import java.awt.*;

public class Ellipse extends TwoDimShape {

	private Point addPoint;

	public Ellipse(Color shColor, Color shapeFillColor, Point center, Point addP){
        super(shColor, shapeFillColor);
        setTheCenter(center);
        int newX, newY;
        if(center.x>addP.x && center.y>addP.y){
            newX=addP.x;
            newY=addP.y;
        } else if(center.x > addP.x && center.y < addP.y){
            newX = addP.x;
            newY = 2*center.y - addP.y;
        } else if(center.x < addP.x && center.y > addP.y){
            newX = 2*center.x - addP.x;
            newY = addP.y;
        } else {
            newX = 2*center.x - addP.x;
            newY = 2*center.y - addP.y;
        }
        addPoint = new Point(newX, newY);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(Graphics g){
        g.setColor(getShapeColor());
        g.drawOval(addPoint.x, addPoint.y, 2*(getTheCenter().x - addPoint.x), 2*(getTheCenter().y - addPoint.y));
        g.setColor(getShapeFillColor());
        g.fillOval(addPoint.x, addPoint.y, 2*(getTheCenter().x - addPoint.x), 2*(getTheCenter().y - addPoint.y));
	}

	public Point getAddPoint(){
		return addPoint;
	}

	public void move(Point point){
        int xDiff = getTheCenter().x - point.x;
        int yDiff = getTheCenter().y - point.y;
        setTheCenter(new Point(point));
        int newAddPx = addPoint.x - xDiff;
        int newAddPy = addPoint.y - yDiff;
        setAddPoint(new Point(newAddPx,newAddPy));
	}

	public void setAddPoint(Point newVal){
		addPoint = newVal;
	}

}