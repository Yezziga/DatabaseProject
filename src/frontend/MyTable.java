package frontend;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import backend.Queries;

public class MyTable extends AbstractTableModel implements TableModelListener {

	private String[] columnNames;
	private Object[][] data;
	private boolean DEBUG = true;

	public MyTable() {
		this.columnNames = getColumns();
		this.data = getData();
	}

	public MyTable(String[] columnNames, Object[][] data) {
		this.columnNames = columnNames;
		this.data = data;
	}
	
	public void refresh() {
		setColumn(getColumns());
		setData(getData());
		
	}

	public void setData(Object[][] o) {
		this.data = o;
	}

	public void setColumn(String[] s) {
		this.columnNames = s;
		fireTableStructureChanged();
	}

	public Object[][] getData() {

		Object[][] myData = new String[][] {};

		return myData;
	}

	public String[] getColumns() {

		String[] myData = {};
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

	@Override
	public void tableChanged(TableModelEvent e) {
		// int row = e.getFirstRow();
		// int column = e.getColumn();
		// TableModel model = (TableModel) e.getSource();
		// String columnName = model.getColumnName(column);
		// Object data = model.getValueAt(row, column);
		// setValueAt(data, row, column);
	}
}