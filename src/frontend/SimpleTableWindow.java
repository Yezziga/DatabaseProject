package frontend;

import backend.Queries;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
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

	public SimpleTableWindow() {
		super(new GridLayout(2, 0));

		table = new JTable(new MyTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		table.getModel().addTableModelListener(this);
		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
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

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TableDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		SimpleTableWindow newContentPane = new SimpleTableWindow();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel) e.getSource();
		String columnName = model.getColumnName(column);
		Object data = model.getValueAt(row, column);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
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
