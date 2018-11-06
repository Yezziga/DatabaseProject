package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterPnl extends JPanel {
	private JLabel lblName = new JLabel("Name");
	private JLabel lblAddress = new JLabel("Address");
	private JLabel lblEmail = new JLabel("Email");
	private JLabel lblPhone = new JLabel("Phone");
	private JLabel lblStatus = new JLabel("status comes here");

	private JLabel invis = new JLabel("REGISTER");
	private JLabel invis1 = new JLabel();
	private JLabel invis2 = new JLabel();
	private JLabel invis3 = new JLabel();
	private JLabel invis4 = new JLabel();
	private JLabel invis5 = new JLabel();
	private JLabel invis6 = new JLabel();

	private JTextField tfName = new JTextField();
	private JTextField tfAddress = new JTextField();
	private JTextField tfEmail = new JTextField();
	private JTextField tfPhone = new JTextField();

	private JButton bnRegister = new JButton("Register");
	private JButton bnCancel = new JButton("Cancel");
	private JPanel panel = new JPanel();
	private Controller c;

	public RegisterPnl(Controller c) {
		this.c = c;
		setLayout(new BorderLayout());

		tfName.setPreferredSize(new Dimension(160, 20));
		tfAddress.setPreferredSize(new Dimension(160, 20));
		tfEmail.setPreferredSize(new Dimension(160, 20));
		tfPhone.setPreferredSize(new Dimension(160, 20));

		invis.setPreferredSize(new Dimension(900, 90));
		invis1.setPreferredSize(new Dimension(900, 20));
		invis2.setPreferredSize(new Dimension(900, 20));
		invis3.setPreferredSize(new Dimension(900, 20));
		invis4.setPreferredSize(new Dimension(900, 20));
		invis6.setPreferredSize(new Dimension(900, 20));
		panel.setPreferredSize(new Dimension(300, 70));
		invis.setHorizontalAlignment(JLabel.CENTER);

		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);

		panel.add(invis);
		panel.add(lblName);
		panel.add(tfName);
		panel.add(invis1);

		panel.add(lblAddress);
		panel.add(tfAddress);
		panel.add(invis2);

		panel.add(lblEmail);
		panel.add(tfEmail);
		panel.add(invis3);

		panel.add(lblPhone);
		panel.add(tfPhone);
		panel.add(invis4);
		panel.add(invis5);

		panel.add(bnRegister);
		panel.add(bnCancel);
		panel.add(invis6);
		panel.add(lblStatus);

		Listener listener = new Listener();
		listener.addListeners();
	}

	public String getName() {
		return tfName.getText();
	}

	public String getAddress() {
		return tfAddress.getText();
	}

	public String getEmail() {
		return tfEmail.getText();
	}

	public String getPhone() {
		return tfPhone.getText();
	}

	public void setLblStatus(String s) {
		lblStatus.setText(s);
	}

	private class Listener implements ActionListener {

		public void addListeners() {
			bnRegister.addActionListener(this);
			bnCancel.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bnRegister) {

				c.registerTraveler(getName(), getAddress(), getEmail(), getPhone()); // add new traveler to database
				JOptionPane.showMessageDialog(null, "You have been registered. Your traveler-ID is: ");
			}

			if (e.getSource() == bnCancel) {
				c.openMainMenu(1);
			}

		}

	}
}
