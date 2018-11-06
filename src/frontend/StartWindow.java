package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import backend.Queries;

/**
 * Main GUI
 * 
 * @author Jessica
 *
 */
public class StartWindow extends JFrame {

	public StartWindow(Controller c) {

		SimpleTableWindow newContentPane = new SimpleTableWindow(c);
		newContentPane.setOpaque(true); // content panes must be opaque
		setContentPane(newContentPane);
		this.setLocation(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(900, 500));
		this.pack();
		this.setVisible(true);
	
	}

	public void swapPanel(JPanel toShow) {
		setContentPane(toShow);
		pack();
		revalidate();
		repaint();
	}


}
