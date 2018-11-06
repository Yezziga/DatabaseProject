package frontend;

import backend.Queries;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimpleTableWindow extends JPanel implements TableModelListener, ActionListener {

	private boolean DEBUG = false;
	private JTable table;
	private JLabel lblTitle;
	private JTextField tfInput;
	private JButton bnBook, bnMyBookings, bnRegister;
	private Controller c;

	public SimpleTableWindow(Controller c) {
		super(new BorderLayout());
		this.c = c;

		table = new JTable(new MyTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		table.getModel().addTableModelListener(this);
		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.magenta);

		lblTitle = new JLabel("Title goes here");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		tfInput = new JTextField("Input goes here");
		tfInput.setPreferredSize(new Dimension(250, 25));
		bnBook = new JButton("book");
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
	}

	public Object[][] getData() {

		Object[][] myData = new Queries().getQueries.getDrivers();

		return myData;
	}

	public String[] getColumns() {

		String[] myData = { "Person_nr", "name", "address", "phone_nr" };
		return myData;
	}

	class MyTableModel extends AbstractTableModel {
		// private String[] columnNames = { "First Name", "Last Name", "Sport", "# of
		// Years", "Vegetarian" };
		// private Object[][] data = {
		// { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
		// { "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
		// { "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
		// { "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
		// { "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) }
		// };
		private String[] columnNames;
		private Object[][] data;

		public MyTableModel() {
			this.columnNames = getColumns();
			this.data = getData();
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		/*
		 * JTable uses this method to determine the default renderer/ editor for each
		 * cell. If we didn't implement this method, then the last column would contain
		 * text ("true"/"false"), rather than a check box.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's editable.
		 */
		public boolean isCellEditable(int row, int col) {
			// Note that the data/cell address is constant,
			// no matter where the cell appears onscreen.
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		/*
		 * Don't need to implement this method unless your table's data can change.
		 */
		public void setValueAt(Object value, int row, int col) {
			if (DEBUG) {
				System.out.println("Setting value at " + row + "," + col + " to " + value + " (an instance of "
						+ value.getClass() + ")");
			}

			data[row][col] = value;
			fireTableCellUpdated(row, col);

			if (DEBUG) {
				System.out.println("New value of data:");
				printDebugData();
			}
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i = 0; i < numRows; i++) {
				System.out.print("    row " + i + ":");
				for (int j = 0; j < numCols; j++) {
					System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}
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
