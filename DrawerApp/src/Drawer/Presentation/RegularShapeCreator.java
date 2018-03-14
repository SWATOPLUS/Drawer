package Drawer.Presentation;
import Drawer.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RegularShapeCreator extends ShapeCreator {

    private final Function<List<Point>, Shape> builder;
    private final int pointCount;
    private final List<Point> points = new ArrayList<Point>();


    public RegularShapeCreator(int pointCount, Function<List<Point>, Shape> builder){
        this.builder = builder;
        this.pointCount = pointCount;
    }

    @Override
    public Shape onNext(Point point) {
        points.add(point);

        if(points.size() == pointCount){
            seal();
            return builder.apply(points);
        }

        return new Dots(points);
    }

    @Override
    public Shape onFinished() {
        return new Dots(points);
    }
}
