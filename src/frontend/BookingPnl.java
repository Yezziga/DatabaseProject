
package frontend;

import java.awt.*;

import javax.swing.*;

public class BookingPnl extends JPanel {
	private JPanel pnlRoutes = new JPanel();
	private JPanel pnlTrips = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JPanel pnlSouthLeft = new JPanel();
	private JPanel pnlSouthRight = new JPanel();
	private JLabel lblRoutes = new JLabel("Routes");
	private JLabel lblTrips = new JLabel("Trips");
	private JLabel lblBooking = new JLabel("Booking"); // NORTH
	private JScrollPane spLeft = new JScrollPane();
	private JScrollPane spRight = new JScrollPane();
	private JList<String> routesList = new JList<String>();
	private JList tripList = new JList();
	private JTextField tfSeats = new JTextField("Seats");
	private JTextField tfID = new JTextField("Your traveler-ID");
	private JButton bnBook = new JButton("Book");
	private JButton bnCancel = new JButton("Cancel");

	private JLabel invis = new JLabel();
	private JLabel invis1 = new JLabel();

	public BookingPnl() {
		setLayout(new BorderLayout());
		pnlCenter.setLayout(new GridLayout(1, 2, 30, 10));
		lblBooking.setPreferredSize(new Dimension(200, 50));
		lblBooking.setHorizontalAlignment(JLabel.CENTER);

		pnlRoutes.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // testing purpose
		pnlTrips.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		pnlSouth.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // testing purpose

		invis.setPreferredSize(new Dimension(350, 10));
		// invis.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		invis1.setPreferredSize(new Dimension(350, 10));
		// invis1.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));

		String[] data = {"CPH_BER", "BER_CPH", "STO_BER"};	// TESTI
		routesList.setListData(data);
		
		
		spLeft.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spLeft.setSize(200, 700); // not working
		spLeft.setViewportView(routesList);

		spRight.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spRight.setSize(200, 700);
		spRight.setViewportView(tripList);

		// pnlSouth.add(lblRoutes);
		pnlRoutes.add(lblRoutes);
		pnlRoutes.add(invis);
		pnlTrips.add(lblTrips);
		pnlTrips.add(invis1);
		pnlRoutes.add(spLeft);
		pnlTrips.add(spRight);
		pnlCenter.add(pnlRoutes);
		pnlCenter.add(pnlTrips);
		pnlSouth.setLayout(new GridLayout(1, 2, 30, 0));
		pnlSouthLeft.add(new JLabel("testing"));
		// pnlSouthRight.add(new JLabel("right panel"));

		pnlSouthRight.setLayout(new GridLayout(2, 2, 30, 10));
		pnlSouthRight.add(tfSeats);
		pnlSouthRight.add(tfID);
		pnlSouthRight.add(bnBook);
		pnlSouthRight.add(bnCancel);
		pnlSouth.add(pnlSouthLeft);
		pnlSouth.add(pnlSouthRight);

		add(lblBooking, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

	}
}
