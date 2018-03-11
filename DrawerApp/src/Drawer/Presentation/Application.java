package Drawer.Presentation;

import Drawer.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.function.Function;

public class Application extends JFrame {
    private final ShapeCanvas shapeCanvas;
    private final JButton stopButton;
    private IrregularShapeCreator irregularShapeCreator;
    private Color borderColor;
	private Color fillColor;

	public Application(){
	    super("Drawer");
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.shapeCanvas = new ShapeCanvas();
        add(shapeCanvas);

	    JMenuBar menuBar = new JMenuBar();


		JMenu colorMenu = new JMenu("Color");

		JMenuItem shColorItem = new JMenuItem("Shape color");
		colorMenu.add(shColorItem);
        shColorItem.addActionListener(e -> {
            borderColor = JColorChooser.showDialog(null, "Shape color", Color.BLACK);
            shColorItem.setForeground(borderColor);
        });

        JMenuItem shFillColorItem = new JMenuItem("Shape fill color");
		colorMenu.add(shFillColorItem);
        shColorItem.addActionListener(e -> {
            fillColor = JColorChooser.showDialog(null, "Shape fill color", Color.WHITE);
            shFillColorItem.setForeground(fillColor);
        });


       stopButton = new JButton("stop");
       stopButton.addActionListener(e -> {
            irregularShapeCreator.onStopped();
            stopButton.setVisible(false);
       });
       stopButton.setVisible(false);


        menuBar.add(colorMenu);
        menuBar.add(this.constructAddMenu());
        menuBar.add(stopButton);

        add(menuBar,BorderLayout.NORTH);
	}


	private JMenu constructAddMenu(){
        JMenu addMenu = new JMenu("add shape");

        //ShapeCreator ss2 = new IrregularShapeCreator(shapeCanvas, count -> true , points -> new Segment(Color.BLACK,points.get(0),points.get(1)));
        addMenu.add(constructAddMenuItem("segment",2,points -> new Segment(borderColor,points.get(0),points.get(1))));
        addMenu.add(constructAddMenuItem("circle",2,points -> new Circle(borderColor,fillColor,points.get(0),points.get(1))));
        addMenu.add(constructAddMenuItem("ellipse",2,points -> new Ellipse(borderColor,fillColor,points.get(0),points.get(1))));
        addMenu.add(constructAddMenuItem("polyline",points -> new PolyLine(borderColor,points)));
        addMenu.add(constructAddMenuItem("polygon",points -> new Drawer.Polygon(borderColor,fillColor,points)));
        return addMenu;
    }

    private JMenuItem constructAddMenuItem(String name, int pointsCount, Function<List<Point>, Drawer.Shape> builder){
        JMenuItem menuItem = new JMenuItem(name);

        menuItem.addActionListener(e -> {
            shapeCanvas.applyShape(null);
            ShapeCreator shapeCreator = new RegularShapeCreator(shapeCanvas, pointsCount, builder);
            shapeCanvas.applyCreator(shapeCreator);
        });

        return menuItem;
    }

    private JMenuItem constructAddMenuItem(String name, Function<List<Point>, Drawer.Shape> builder){

        JMenuItem menuItem = new JMenuItem(name);

        menuItem.addActionListener(e -> {
            shapeCanvas.applyShape(null);
            stopButton.setVisible(true);
            irregularShapeCreator = new IrregularShapeCreator(shapeCanvas, builder);
            ShapeCreator shapeCreator = irregularShapeCreator;
            shapeCanvas.applyCreator(shapeCreator);
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