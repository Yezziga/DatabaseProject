package frontend;

import backend.Queries;
import java.awt.Dimension;

import javax.swing.*;

public class Controller {
	private RegisterPnl registerPnl;
	private MyBookingsPnl myBookings;
	private StartWindow window;
	private SimpleTableWindow table;

	public Controller() {
		registerPnl = new RegisterPnl(this);
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

	public void registerTraveler(String name, String address, String email, String phone) {
		int trav_id = new Queries().insertQueries.registerTraveler(name, email, address, phone);
		if(trav_id == -1)
		{
			//throw new Exception();
		}
	}

	public void getMyBookings(int trav_id) {
		Object[][] bookings = new Queries().getQueries.getMyBooking(15);
		String[] myData = { "Person_nr", "name", "address", "phone_nr" };
		if(trav_id == -1)
		{
			//throw new Exception();
		}
	}
	
	public void checkSeats(int seats) {
		// call query to calculate price
		
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}
