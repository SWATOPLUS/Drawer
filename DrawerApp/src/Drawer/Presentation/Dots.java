package Drawer.Presentation;

import java.awt.*;
import java.util.List;

public class Dots extends Drawer.Shape {

    private final List<Point> points;

    public Dots(List<Point> points) {
        super(Color.RED);
        this.points = points;
        setTheCenter(new Point(0,0));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getShapeColor());
        for (Point dot:points) {
            g.fillOval(dot.x-2,dot.y-2,4,4);
        }
    }

    @Override
    public void move(Point point) {

    }
}
