package frontend;

import java.awt.Dimension;

import javax.swing.*;

public class Controller {
	private Terminal terminal;
	private RegisterPnl registerPnl;
	private MyBookingsPnl myBookings;
	private StartWindow window;
	
	public Controller() {
		registerPnl = new RegisterPnl(this);
		terminal = new Terminal(this);
		myBookings = new MyBookingsPnl(this);
	}

	public void openRegisterUI() {
		window.swapPanel(terminal, registerPnl);
	}

	public void start() {
		window = new StartWindow(terminal);
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}

	public void openMainMenu(int i) {
		if( i==1) {
		window.swapPanel(registerPnl, terminal);
		} else {
			window.swapPanel(myBookings, terminal);	
		}
	}
	
	public void openMyBookingsUI() {
		window.swapPanel(terminal, myBookings);
	}

	public void registerTraveler(String name, String address, String email, String phone) {
		
	}

}
