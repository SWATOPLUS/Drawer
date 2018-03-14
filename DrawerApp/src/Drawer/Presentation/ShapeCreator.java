package Drawer.Presentation;

import Drawer.*;
import Drawer.Shape;

import java.awt.*;

public abstract class ShapeCreator{

    private boolean seal = false;

    public abstract Shape onNext(Point point);
    public Shape onCanceled() {
        seal();
        return null;
    }
    public abstract Shape onFinished();
    public boolean isSealed(){
        return seal;
    }
    protected void seal(){
        seal = true;
    }
}