package Drawer.Presentation;
import Drawer.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IrregularShapeCreator implements ShapeCreator {

    private final Function<List<Point>, Shape> builder;
    private final ShapeCanvas shapeCanvas;
    private final List<Point> points = new ArrayList<>();

    public IrregularShapeCreator(ShapeCanvas shapeCanvas, Function<List<Point>, Shape> builder){
        this.shapeCanvas=shapeCanvas;
        this.builder = builder;
        shapeCanvas.applyCreator(this);
    }

    @Override
    public void onPointAdded(Point point) {
        points.add(point);
        shapeCanvas.applyShape(new Dots(points));
    }

    public void onStopped(){
        Shape shape = builder.apply(points);
        shapeCanvas.applyShape(shape);
        shapeCanvas.cancelCreator();
    }
}
