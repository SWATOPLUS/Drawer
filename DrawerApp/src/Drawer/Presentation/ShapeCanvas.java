package Drawer.Presentation;

import Drawer.Shape;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeCanvas extends JPanel {

    private Shape shape;
    private boolean isDragging = false;
    private int oldX;
    private int oldY;

    private ShapeCreator shapeCreator;

    public ShapeCanvas(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                isDragging = true;
                oldX = e.getX();
                oldY = e.getY();

                if(shapeCreator != null && !shapeCreator.isSealed()){
                    if(SwingUtilities.isLeftMouseButton(e)) {
                        applyShape(shapeCreator.onNext(new Point(e.getX(), e.getY())));
                    } else if(SwingUtilities.isRightMouseButton(e)) {
                        applyShape(shapeCreator.onFinished());
                    } else if(SwingUtilities.isMiddleMouseButton(e)){
                        applyShape(shapeCreator.onCanceled());
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                isDragging = false;
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseMoved(e);
                if(isDragging){
                    int xOffset = e.getX() - oldX;
                    int yOffset = e.getY() - oldY;
                    Point offset = new Point(xOffset,yOffset);
                    onShapeMoved(offset);

                    oldX = e.getX();
                    oldY = e.getY();
                }
            }
        });
    }

    private void onShapeMoved(Point offset){
        if(shape == null) return;

        Point oldCenter = shape.getTheCenter();

        int x = oldCenter.x + offset.x;
        int y = oldCenter.y + offset.y;

        shape.move(new Point(x,y));

        repaint();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(shape != null) {
            shape.draw(g);
        }
    }

    public void applyShape(Shape shape){
        this.shape = shape;
        repaint();
    }

    public void applyCreator(ShapeCreator shapeCreator) {
        this.shapeCreator = shapeCreator;
    }
}
