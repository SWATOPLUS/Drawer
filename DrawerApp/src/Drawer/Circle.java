package Drawer;


import java.awt.*;

public class Circle extends Ellipse {

	public Circle(Color shColor, Color shapeFillColor, Point center, Point addP){
        super(shColor, shapeFillColor, center, addP);
        int newX = center.x - (int)(Math.sqrt((center.x - addP.x)*(center.x - addP.x)+(center.y - addP.y)*(center.y - addP.y)));
        int newY = center.y - (int)(Math.sqrt((center.x - addP.x)*(center.x - addP.x)+(center.y - addP.y)*(center.y - addP.y)));
		setAddPoint(new Point(newX, newY));
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}