package frontend;

import backend.Queries;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// rename bookingPnl
public class BookingPnl extends JPanel implements ActionListener {

	private JTable table;
	private JLabel lblTitle;
	private JTextField tfleft, tfRight;
	private JButton bnSearch, bnBook, bnMyBookings, bnRegister, bnClear;
	private Controller c;
	private Table t;

	public BookingPnl(Controller c) {
		super(new BorderLayout());
		this.c = c;
		t = new Table();

		table = new JTable(t);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.getModel().addTableModelListener(t);

		JScrollPane scrollPane = new JScrollPane(table);
		JPanel pnlSouth = new JPanel();

		lblTitle = new JLabel("BOOKING");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		tfleft = new JTextField();
		tfleft.setPreferredSize(new Dimension(150, 25));
		tfRight = new JTextField();
		tfRight.setPreferredSize(new Dimension(150, 25));
		bnSearch = new JButton("Search");
		bnBook = new JButton("Book");
		bnMyBookings = new JButton("My bookings");
		bnRegister = new JButton("Register");
		bnClear = new JButton("Clear");
		pnlSouth = new JPanel();
		pnlSouth.add(bnSearch);
		pnlSouth.add(tfleft);
		pnlSouth.add(tfRight);
		pnlSouth.add(bnBook);
		pnlSouth.add(bnMyBookings);
		pnlSouth.add(bnRegister);
		pnlSouth.add(bnClear);

		add(lblTitle, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

		bnSearch.addActionListener(this);
		bnRegister.addActionListener(this);
		bnMyBookings.addActionListener(this);
		bnBook.addActionListener(this);
		bnClear.addActionListener(this);

	}
	

	public Table getTable() {
		return t;
	}

	public String getLeftIn() {
		return tfleft.getText();
	}

	public String getRightIn() {
		return tfRight.getText();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		if (event.getSource() == bnRegister) {
			c.changePanel(1);
		}
		if (event.getSource() == bnMyBookings) {
			c.changePanel(2);
		}
		if (event.getSource() == bnBook) {
			if (table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Select a row to book");
			} else {

				int seats, travId, tripId;
				travId = Integer.parseInt(JOptionPane.showInputDialog("What is your traveler-ID?"));
				seats = Integer.parseInt(JOptionPane.showInputDialog("How many seats would you like to book?"));
				tripId = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString());

				c.checkIfBookable(seats, tripId, travId);
			}
		}
		if (event.getSource() == bnClear) {
			t.refresh();
		}
		if (event.getSource() == bnSearch) {

			if (getLeftIn().isEmpty() && getRightIn().isEmpty()) {
				c.getAllTrips();
			} else if (getLeftIn().startsWith("add ")) {
				String driverId = getLeftIn().substring(4);
				c.addDriverToTrip(driverId, getRightIn());
			} else {
				c.getTrips(getLeftIn(), getRightIn());

			}
		}
	}

}
