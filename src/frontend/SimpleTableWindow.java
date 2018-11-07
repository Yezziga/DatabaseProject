package frontend;

import backend.Queries;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleTableWindow extends JPanel implements TableModelListener, ActionListener {

	private JTable table;
	private JLabel lblTitle;
	private JTextField tfInput;
	private JButton bnBook, bnMyBookings, bnRegister;
	private Controller c;

	public SimpleTableWindow(Controller c) {
		super(new BorderLayout());
		this.c = c;

		table = new JTable(new MyTable());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		table.getModel().addTableModelListener(this);
		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.magenta);

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
			int seats = Integer.parseInt(JOptionPane.showInputDialog("How many seats would you like to book?"));
			c.checkSeats(seats);
		}

		// Cell selection is disabled in Multiple Interval Selection
		// mode. The enabled state of cellCheck is a convenient flag
		// for this status.
		// if ("Row Selection" == command) {
		// table.setRowSelectionAllowed(rowCheck.isSelected());
		// //In MIS mode, column selection allowed must be the
		// //opposite of row selection allowed.
		// if (!cellCheck.isEnabled()) {
		// table.setColumnSelectionAllowed(!rowCheck.isSelected());
		// }
		// } else if ("Column Selection" == command) {
		// table.setColumnSelectionAllowed(columnCheck.isSelected());
		// //In MIS mode, row selection allowed must be the
		// //opposite of column selection allowed.
		// if (!cellCheck.isEnabled()) {
		// table.setRowSelectionAllowed(!columnCheck.isSelected());
		// }
		// } else if ("Cell Selection" == command) {
		// table.setCellSelectionEnabled(cellCheck.isSelected());
		// } else if ("Multiple Interval Selection" == command) {
		// table.setSelectionMode(
		// ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// //If cell selection is on, turn it off.
		// if (cellCheck.isSelected()) {
		// cellCheck.setSelected(false);
		// table.setCellSelectionEnabled(false);
		// }
		// //And don't let it be turned back on.
		// cellCheck.setEnabled(false);
		// } else if ("Single Interval Selection" == command) {
		// table.setSelectionMode(
		// ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		// //Cell selection is ok in this mode.
		// cellCheck.setEnabled(true);
		// } else if ("Single Selection" == command) {
		// table.setSelectionMode(
		// ListSelectionModel.SINGLE_SELECTION);
		// //Cell selection is ok in this mode.
		// cellCheck.setEnabled(true);
		// }
		//
		// //Update checkboxes to reflect selection mode side effects.
		// rowCheck.setSelected(table.getRowSelectionAllowed());
		// columnCheck.setSelected(table.getColumnSelectionAllowed());
		// if (cellCheck.isEnabled()) {
		// cellCheck.setSelected(table.getCellSelectionEnabled());
		// }

	}

}
