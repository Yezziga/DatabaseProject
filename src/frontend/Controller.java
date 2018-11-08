package frontend;

import backend.Queries;
import frontend.BookingPnl;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.*;

public class Controller {
	private RegisterPnl registerPnl;
	private MyBookingsPnl myBookings;
	private StartWindow window;
	private BookingPnl bookingPnl;

	public Controller() {
		registerPnl = new RegisterPnl(this);
		myBookings = new MyBookingsPnl(this);
		bookingPnl = new BookingPnl(this);
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
			pnl = bookingPnl;
		}
		window.swapPanel(pnl);
	}

	public void start() {
		window = new StartWindow(this);
	}

	public int registerTraveler(String name, String address, String email, String phone) {
		int trav_id = new Queries().insertQueries.registerTraveler(name, email, address, phone);
		if (trav_id == -1) {
			// throw new Exception();
		}
		return trav_id;
	}

	public void getMyBookings(int trav_id) {
		Object[][] bookings = new Queries().getQueries.getMyBooking(trav_id);
		String[] columns = { "Booking nr", "Route", "Departure", "Arrival", "Total price", "Reserved seats" };
		myBookings.getTable().setColumn(columns);
		myBookings.getTable().setData(bookings);
	}

	public void checkIfBookable(int seats, int tripId, int travId) {
		int bookingid;
		try {
			bookingid = new Queries().insertQueries.bookTrip(seats, tripId, travId);
			System.out.println("check if possible " + bookingid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* 
	 * not used
	 */
	public void getDriver() {
		Object[][] myData = new Queries().getQueries.getDriver("2019");
		String[] column = { "Person_nr", "name", "address", "phone_nr" };
		bookingPnl.getTable().setColumn(column);
		bookingPnl.getTable().setData(myData);
		window.swapPanel(bookingPnl);
	}

	public void addDriverToTrip(String driverId, String tripId) {
		new Queries().insertQueries.addDriverToTrip(driverId, tripId);	
	}

	public void getTrips(String startPoint, String destination) {
		try {
		Object[][] myData = new Queries().getQueries.getTrips(startPoint, destination);
		String[] column = {"route", "departure", "arrival", "price", "seats_left", "driver_person_nr", "trip_id"};
		bookingPnl.getTable().setColumn(column);
		bookingPnl.getTable().setData(myData);
		window.swapPanel(bookingPnl);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void getAllTrips() {
		Object[][] myData = new Queries().getQueries.getAllTrips();
		String[] column = {"route", "departure", "arrival", "price", "seats_left", "driver_person_nr", "trip_id"};
		bookingPnl.getTable().setColumn(column);
		bookingPnl.getTable().setData(myData);
		window.swapPanel(bookingPnl);
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}
