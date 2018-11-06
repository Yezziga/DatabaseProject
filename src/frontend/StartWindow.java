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

	public StartWindow(JPanel pnl) {
		this.setLocation(500,200); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(900, 500));
		this.add(pnl);
		this.pack();
		this.setVisible(true);
		//
	}
	
	public void swapPanel(JPanel old, JPanel toShow) {
		remove(old);
		add(toShow);
		pack();
		revalidate();
		repaint();
	}
	
	public void end() {
		dispose();
	}
	
}
