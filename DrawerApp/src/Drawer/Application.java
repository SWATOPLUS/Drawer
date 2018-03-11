package Drawer;

import Drawer.Panels.SegmentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame {
	private Color shColor;
	private Color shFillColor;
	private JPanel drawPanel;

	public Application(){
	    super("Drawer");
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


	    JMenuBar menuBar = new JMenuBar();

		JMenu drawMenu = new JMenu("Draw..");

		JMenuItem segmentItem = new JMenuItem("Segment");
		drawMenu.add(segmentItem);
		segmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(drawPanel);
                drawPanel = new SegmentPanel(shColor, 1);
                add(drawPanel);
                revalidate();
                repaint();
            }
        });

		JMenu colorMenu = new JMenu("Color");

		JMenuItem shColorItem = new JMenuItem("Shape color");
		colorMenu.add(shColorItem);
        shColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shColor = JColorChooser.showDialog(null, "Shape color", Color.BLACK);
                shColorItem.setForeground(shColor);
            }
        });
		JMenuItem shFillColorItem = new JMenuItem("Shape fill color");
		colorMenu.add(shFillColorItem);
        shColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shFillColor = JColorChooser.showDialog(null, "Shape fill color", Color.WHITE);
                shFillColorItem.setForeground(shFillColor);
            }
        });

        menuBar.add(colorMenu);

        add(menuBar,BorderLayout.NORTH);

	}

	public void finalize() throws Throwable {

	}

	public static void main(String[] args){
	    JFrame app = new Application();
	    app.setSize(640,480);
        app.setVisible(true);
    }

}