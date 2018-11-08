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
public class BookingPnl extends JPanel implements TableModelListener, ActionListener {

	private JTable table;
	private JLabel lblTitle;
	private JTextField tfInput;
	private JButton bnBook, bnMyBookings, bnRegister;
	private Controller c;
	private MyTable t;

	public BookingPnl(Controller c) {
		super(new BorderLayout());
		this.c = c;
		t = new MyTable();

		table = new JTable(t);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		table.getModel().addTableModelListener(this);
		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		JPanel pnlSouth = new JPanel();

		lblTitle = new JLabel("BOOKING");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		tfInput = new JTextField("Input goes here");
		tfInput.setPreferredSize(new Dimension(250, 25));
		bnBook = new JButton("Book");
		bnMyBookings = new JButton("My bookings");
		bnRegister = new JButton("Register");
		pnlSouth = new JPanel();
		pnlSouth.add(tfInput);
		pnlSouth.add(bnBook);
		pnlSouth.add(bnMyBookings);
		pnlSouth.add(bnRegister);

		add(lblTitle, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

		bnRegister.addActionListener(this);
		bnMyBookings.addActionListener(this);
		bnBook.addActionListener(this);

	}
	
	public MyTable getTable() {
		return t;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel) e.getSource();
		String columnName = model.getColumnName(column);
		Object data = model.getValueAt(row, column);
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

	}

}
