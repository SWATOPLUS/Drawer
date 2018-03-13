package Drawer.Presentation;
import Drawer.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RegularShapeCreator implements ShapeCreator {

    private final Function<List<Point>, Shape> builder;
    private final int pointCount;
    private final ShapeCanvas shapeCanvas;
    private final List<Point> points = new ArrayList<Point>();

    public RegularShapeCreator(ShapeCanvas shapeCanvas, int pointCount, Function<List<Point>, Shape> builder){
        this.shapeCanvas=shapeCanvas;
        this.builder = builder;
        this.pointCount = pointCount;
        shapeCanvas.applyCreator(this);
    }



    @Override
    public void onPointAdded(Point point) {
        points.add(point);
        shapeCanvas.applyShape(new Dots(points));
        if(points.size() == pointCount){
            Shape shape = builder.apply(points);
            shapeCanvas.applyShape(shape);
            shapeCanvas.cancelCreator();
        }
    }
}
