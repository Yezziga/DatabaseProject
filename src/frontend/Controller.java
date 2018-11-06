package frontend;

import java.awt.Dimension;

import javax.swing.*;

public class Controller {
	private Terminal terminal;
	private RegisterPnl registerPnl;
	private MyBookingsPnl myBookings;
	private StartWindow window;
	private SimpleTableWindow table;

	public Controller() {
		registerPnl = new RegisterPnl(this);
		terminal = new Terminal(this);
		myBookings = new MyBookingsPnl(this);
		table = new SimpleTableWindow(this);
	}

	public void changePanel(int i) {
		JPanel pnl = null;
		if (i == 1) {
			pnl = registerPnl;
		}
		if (i == 2) {
			pnl = myBookings;
		}
		if (i == 3) {
			pnl = table;
		}
		window.swapPanel(pnl);
	}


	public void start() {
		window = new StartWindow(this);
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}

	public void registerTraveler(String name, String address, String email, String phone) {

	}

}
