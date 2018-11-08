package frontend;

import javax.swing.table.AbstractTableModel;

import backend.Queries;

public class MyTable extends AbstractTableModel {

	private String[] columnNames;
	private Object[][] data;
	private boolean DEBUG = false;

	public MyTable() {
		this.columnNames = getColumns();
		this.data = getData();
	}

	public MyTable(String[] columnNames, Object[][] data) {
		this.columnNames = columnNames;
		this.data = data;
	}
	
	public void setData(Object[][] o) {
		this.data = o;
	}
	
	public void setColumn(String[] s) {
		this.columnNames = s;
	}

	public Object[][] getData() {

		// Object[][] myData = new Queries().getQueries.getDrivers();
		Object[][] myData = new String[][] {};

		return myData;
	}

	public String[] getColumns() {

		// String[] myData = { "Person_nr", "name", "address", "phone_nr" };
		String[] myData = { " " };
		return myData;
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