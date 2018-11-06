package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import backend.Queries;
import frontend.SimpleTableWindow.MyTableModel;

/**
 * not used
 * @author Jessica
 *
 */
public class Terminal extends JPanel {
	private JLabel lblTitle;
	private JScrollPane pane;
	private JTextField tfInput;
	private JButton bnBook, bnMyBookings, bnRegister;
	private JList<Object> list;
	private JPanel pnlSouth;
	private Controller c;
	
	public Terminal(Controller c) {
		this.c = c;

		ArrayList<String[]> s = new Queries().getQueries.getDriver("197801082222");

		setBackground(Color.WHITE);
		setLayout(new BorderLayout());

		lblTitle = new JLabel("Title goes here");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		list = new JList<Object>();
		pane = new JScrollPane(list);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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

		String[] data = {
				"CPH_BER, \"BER_CPH\", \"STO_BER\", \"BER_CPH\", \"STO_BER\", \"BER_CPH\", \"STO_BER\", \"BER_CPH\",\r\n"
						+ "				\"STO_BER\", \"BER_CPH\", \"STO_BER\", \"BER_CPH\", \"STO_BER\"",
				"BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH",
				"STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER",
				"BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH",
				"STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER" }; // TESTI
		list.setListData(s.get(0));

		add(lblTitle, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

		System.out.print(s);
		Listener listener = new Listener();
		listener.addListeners();
	
	}

	public String getInput() {
		return tfInput.getText();
	}

	private class Listener implements ActionListener {

		public void addListeners() {
			bnRegister.addActionListener(this);
			bnMyBookings.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bnRegister) {
//				c.openRegisterUI();
			}
			if(e.getSource() == bnMyBookings) {
//				c.openMyBookingsUI();
			}

		}

	}

}
