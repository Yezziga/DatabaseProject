package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.*;

public class RegisterPnl extends JPanel {
	private JLabel lblName = new JLabel("Name");
	private JLabel lblAddress = new JLabel("Address");
	private JLabel lblEmail = new JLabel("Email");
	private JLabel lblPhone = new JLabel("Phone");
	private JLabel lblStatus = new JLabel("status comes here");

	private JLabel invis = new JLabel();
	private JLabel invis1 = new JLabel();
	private JLabel invis2 = new JLabel();
	private JLabel invis3 = new JLabel();
	private JLabel invis4 = new JLabel();
	private JLabel invis5 = new JLabel();
	private JLabel invis6 = new JLabel();

//	private JLabel invis7 = new JLabel();
//	private JLabel invis8 = new JLabel();

	private JTextField tfName = new JTextField();
	private JTextField tfAddress = new JTextField();
	private JTextField tfEmail = new JTextField();
	private JTextField tfPhone = new JTextField();
//	private JTextField tfID = new JTextField();

	private JButton bnRegister = new JButton("Register");
	private JButton bnCancel = new JButton("Cancel");

	private JPanel panel = new JPanel();

	public RegisterPnl() {
		setLayout(new BorderLayout());


//		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		tfName.setPreferredSize(new Dimension(160, 20));
		tfAddress.setPreferredSize(new Dimension(160, 20));
		tfEmail.setPreferredSize(new Dimension(160, 20));
		tfPhone.setPreferredSize(new Dimension(160, 20));

//		tfID.setPreferredSize(new Dimension(160, 20));

		invis.setPreferredSize(new Dimension(610, 90));
		invis1.setPreferredSize(new Dimension(610, 20));
		invis2.setPreferredSize(new Dimension(610, 20));
		invis3.setPreferredSize(new Dimension(610, 20));
		invis4.setPreferredSize(new Dimension(610, 20));

		invis5.setPreferredSize(new Dimension(800, 20));
		invis6.setPreferredSize(new Dimension(800, 20));
//		invis7.setPreferredSize(new Dimension(800, 20));
//		invis8.setPreferredSize(new Dimension(800, 20));
		
		panel.setPreferredSize(new Dimension(300, 70));
//		panel.setBorder(BorderFactory.createLineBorder(Color.RED));

//		invis1.setBorder(BorderFactory.createLineBorder(Color.BLUE));

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

//		panel.add(lblID);
//		panel.add(tfID);
		panel.add(invis5);

		panel.add(bnRegister);
		panel.add(bnCancel);
		panel.add(invis6);
		panel.add(lblStatus);

	}

}
