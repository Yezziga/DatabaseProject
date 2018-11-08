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
	private JTextField tfInput;
	private JButton bnSearch, bnBook, bnMyBookings, bnRegister, bnRefresh;
	private Controller c;
	private MyTable t;

	public BookingPnl(Controller c) {
		super(new BorderLayout());
		this.c = c;
		t = new MyTable();

		table = new JTable(t);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		table.getModel().addTableModelListener(t);
		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		JPanel pnlSouth = new JPanel();

		lblTitle = new JLabel("BOOKING");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		tfInput = new JTextField();
		tfInput.setPreferredSize(new Dimension(250, 25));
		bnSearch = new JButton("Search");
		bnBook = new JButton("Book");
		bnMyBookings = new JButton("My bookings");
		bnRegister = new JButton("Register");
		bnRefresh = new JButton("Refresh");
		pnlSouth = new JPanel();
		pnlSouth.add(bnSearch);
		pnlSouth.add(tfInput);
		pnlSouth.add(bnBook);
		pnlSouth.add(bnMyBookings);
		pnlSouth.add(bnRegister);
		pnlSouth.add(bnRefresh);

		add(lblTitle, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		bnSearch.addActionListener(this);
		bnRegister.addActionListener(this);
		bnMyBookings.addActionListener(this);
		bnBook.addActionListener(this);
		bnRefresh.addActionListener(this);

	}
	
	public MyTable getTable() {
		return t;
	}


	public String getInput() {
		return tfInput.getText();
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
//			int seats = Integer.parseInt(JOptionPane.showInputDialog("How many seats would you like to book?"));
//			c.checkSeats(seats);
			c.getDriver();
		}
		if(event.getSource() == bnRefresh) {
			t.refresh();
		}
		if(event.getSource()== bnSearch) {
			if(getInput().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please insert name of city");
			} else {
//				c.getDriver();
			}
		}

	}

}
