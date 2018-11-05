package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Main GUI
 * 
 * @author Jessica
 *
 */
public class StartWindow extends JFrame {

	public StartWindow() {
		this.setLocation(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 700);
//		this.add(new RegisterPnl());
		this.add(new BookingPnl());
//		this.pack();
		this.setVisible(true);
		//
	}

	public static void main(String[] args) {
		new StartWindow();
	}
}
