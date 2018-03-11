package Drawer.Panels;

import Drawer.Controller;
import Drawer.Line;
import Drawer.Ray;
import Drawer.Segment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SegmentPanel extends JPanel {
    private List<Point> points;
    private Point center, secondPoint;
    private int amountClicked = 0;
    private Segment segment;

    public SegmentPanel(Color shColor, int index){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (amountClicked){
                    case 0:
                        center = new Point(e.getX(), e.getY());
                        points.add(center);
                        repaint();
                        amountClicked++;
                        break;
                    case 1:
                        secondPoint = new Point(e.getX(), e.getY());
                        points.add(secondPoint);
                        repaint();
                        amountClicked++;
                        switch(index){
                            case 1:
                                segment = new Segment(shColor, center, secondPoint);
                            case 2:
                                segment = new Ray(shColor, center, secondPoint);
                            case 3:
                                segment = new Line(shColor, center, secondPoint);
                        }
                        repaint();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for(Point point: points){
            g.drawLine(point.x, point.y, point.x, point.y);
        }
        if(amountClicked>=2)
            segment.draw(g);
    }
}

