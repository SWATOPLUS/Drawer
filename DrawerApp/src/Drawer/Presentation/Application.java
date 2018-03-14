package Drawer.Presentation;

import Drawer.*;
import Drawer.Rectangle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.List;
import java.util.function.Function;

public class Application extends JFrame {
    private final ShapeCanvas shapeCanvas;
    private Color borderColor;
	private Color fillColor;
	private int vertCount;

	public Application(){
	    super("Drawer");
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.shapeCanvas = new ShapeCanvas();
        add(shapeCanvas);

	    JMenuBar menuBar = new JMenuBar();


		JMenu colorMenu = new JMenu("Color");

		JMenuItem borderColorMenuItem = new JMenuItem("Shape color");
		colorMenu.add(borderColorMenuItem);
        borderColorMenuItem.addActionListener(e -> {
            borderColor = JColorChooser.showDialog(null, "Shape color", Color.BLACK);
            borderColorMenuItem.setForeground(borderColor);
        });

        JMenuItem fillColorMenuItem = new JMenuItem("Shape fill color");
		colorMenu.add(fillColorMenuItem);
        fillColorMenuItem.addActionListener(e -> {
            fillColor = JColorChooser.showDialog(null, "Shape fill color", Color.WHITE);
            fillColorMenuItem.setForeground(fillColor);
        });

       JSpinner vertCountInput = new JSpinner(new SpinnerNumberModel(0,0,10000,1));
       vertCountInput.addChangeListener(new ChangeListener() {
           @Override
           public void stateChanged(ChangeEvent e) {
               vertCount = Integer.parseInt(vertCountInput.getValue().toString());
           }
       });


        menuBar.add(colorMenu);
        menuBar.add(this.constructAddMenu());
        menuBar.add(vertCountInput);
        add(menuBar,BorderLayout.NORTH);
	}


	private JMenu constructAddMenu(){
        JMenu addMenu = new JMenu("add shape");
        addMenu.add(constructAddMenuItem("segment",2,points -> new Segment(borderColor,points.get(0),points.get(1))));
        addMenu.add(constructAddMenuItem("ray",2,points -> new Ray(borderColor,points.get(0),points.get(1))));
        addMenu.add(constructAddMenuItem("line",2,points -> new Line(borderColor,points.get(0),points.get(1))));
        addMenu.add(constructAddMenuItem("circle",2,points -> new Circle(borderColor,fillColor,points.get(0),points.get(1))));
        addMenu.add(constructAddMenuItem("ellipse",2,points -> new Ellipse(borderColor,fillColor,points.get(0),points.get(1))));
        addMenu.add(constructAddMenuItem("right triangle",2,points -> new RightTriangle(borderColor,fillColor,points)));
        addMenu.add(constructAddMenuItem("rect",2,points -> new Rectangle(borderColor,fillColor,points)));
        addMenu.add(constructAddMenuItem("Rhombus",2, points -> new Rhombus(borderColor,fillColor,points)));
        addMenu.add(constructAddMenuItem("IsoscelesTriangle",2, points -> new IsoscelesTriangle(borderColor,fillColor,points)));
        addMenu.add(constructAddMenuItem("RegularPolygon",2, points -> new RegularPolygon(borderColor,fillColor,points, vertCount)));
        addMenu.add(constructAddMenuItem("polyline",points -> new PolyLine(borderColor,points)));
        addMenu.add(constructAddMenuItem("polygon",points -> new Drawer.Polygon(borderColor,fillColor,points)));
        return addMenu;
    }

    private JMenuItem constructAddMenuItem(String name, int pointsCount, Function<List<Point>, Drawer.Shape> builder){
        JMenuItem menuItem = new JMenuItem(name);

        menuItem.addActionListener(e -> {
            shapeCanvas.applyShape(null);
            shapeCanvas.applyCreator(new RegularShapeCreator(pointsCount, builder));
        });

        return menuItem;
    }

    private JMenuItem constructAddMenuItem(String name, Function<List<Point>, Drawer.Shape> builder){

        JMenuItem menuItem = new JMenuItem(name);

        menuItem.addActionListener(e -> {
            shapeCanvas.applyShape(null);
            shapeCanvas.applyCreator(new IrregularShapeCreator(builder));
        });

        return menuItem;
    }

	public void finalize() throws Throwable {

	}



	public static void main(String[] args){
	    JFrame app = new Application();
	    app.setSize(640,480);
        app.setVisible(true);
    }

}