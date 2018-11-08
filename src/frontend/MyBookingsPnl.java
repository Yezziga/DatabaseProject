
package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// optional
public class MyBookingsPnl extends JPanel {
	private JLabel lblMyBookings = new JLabel("MY BOOKINGS"); // NORTH
	private JPanel pnlSouth = new JPanel();
	private JTable table;
	private JLabel lblTravelerID = new JLabel("Traveler-ID: "); // NORTH
	private JTextField tfTravelerID = new JTextField();
	private JButton bnOK = new JButton("OK");
	private JButton bnClear = new JButton("Clear");
	private JButton bnGoBack = new JButton("Go back");
	private Controller c;
	private Table t;

	public MyBookingsPnl(Controller c) {
		this.c = c;
		setLayout(new BorderLayout());
		t = new Table();
		table = new JTable(t);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		lblMyBookings.setHorizontalAlignment(JLabel.CENTER);
		lblMyBookings.setPreferredSize(new Dimension(80, 50));

		tfTravelerID.setPreferredSize(new Dimension(80, 20));
		pnlSouth.add(lblTravelerID);
		pnlSouth.add(tfTravelerID);
		pnlSouth.add(bnOK);
		pnlSouth.add(bnGoBack);
		pnlSouth.add(bnClear);
		add(lblMyBookings, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

		Listener listener = new Listener();
		listener.addListeners();
	}

	public Table getTable() {
		return t;
	}

	private class Listener implements ActionListener {

		public void addListeners() {
			bnOK.addActionListener(this);
			bnGoBack.addActionListener(this);
			bnClear.addActionListener(this);

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bnOK) {
				int trav_id = Integer.parseInt(tfTravelerID.getText());
				c.getMyBookings(trav_id);
				// query traveler-ID's bookings

			}

			if (e.getSource() == bnGoBack) {
				c.changePanel(3);
			}
			if(e.getSource() ==bnClear) {
				t.refresh();
			}
		}

	}
}
