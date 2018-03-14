package Drawer.Presentation;
import Drawer.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IrregularShapeCreator extends ShapeCreator {

    private final Function<List<Point>, Shape> builder;
    private final List<Point> points = new ArrayList<Point>();

    public IrregularShapeCreator(Function<List<Point>, Shape> builder) {
        this.builder = builder;
    }

    @Override
    public Shape onNext(Point point) {
        points.add(point);
        return new Dots(points);
    }

    @Override
    public Shape onFinished() {
        seal();
        return builder.apply(points);
    }
}
