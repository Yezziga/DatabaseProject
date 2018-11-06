
package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

// optional
public class MyBookingsPnl extends JPanel{
	private JLabel lblMyBookings = new JLabel("My bookings"); // NORTH

	private JPanel pnlCenter = new JPanel();
	private JScrollPane sp = new JScrollPane();
	private JList routesList = new JList();
	
	private JPanel pnlSouth = new JPanel();
	private JLabel lblTravelerID= new JLabel("Traveler-ID: "); // NORTH
	private JTextField tfTravelerID = new JTextField();
	private JButton bnOK = new JButton("OK"); 
	private JButton bnGoBack = new JButton("Go back"); 

	
	
	public MyBookingsPnl() {
		setLayout(new BorderLayout());
		lblMyBookings.setHorizontalAlignment(JLabel.CENTER);
		lblMyBookings.setPreferredSize(new Dimension(80, 50));

		tfTravelerID.setPreferredSize(new Dimension(80, 20));
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		sp.setSize(200, 700); // not working
		sp.setViewportView(routesList);
		pnlCenter.add(sp);
		
		pnlSouth.add(lblTravelerID);
		pnlSouth.add(tfTravelerID);
		pnlSouth.add(bnOK);
		pnlSouth.add(bnGoBack);
		add(lblMyBookings, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
}
