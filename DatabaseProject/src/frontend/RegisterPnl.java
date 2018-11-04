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
	private JLabel lblID = new JLabel("Your traveler-ID");
	private JLabel lblStatus = new JLabel("status comes here");

	private JLabel invis = new JLabel();
	private JLabel invis1 = new JLabel();
	private JLabel invis2 = new JLabel();
	private JLabel invis3 = new JLabel();
	private JLabel invis4 = new JLabel();
	private JLabel invis5 = new JLabel();
	private JLabel invis6 = new JLabel();
	private JLabel invis7 = new JLabel();
	private JLabel invis8 = new JLabel();

	private JTextField tfName = new JTextField("testa");
	private JTextField tfAddress = new JTextField("testa");
	private JTextField tfEmail = new JTextField("testa");
	private JTextField tfPhone = new JTextField("testa");
	private JTextField tfID = new JTextField("testa");

	private JButton bnRegister = new JButton("Register");
	private JButton bnCancel = new JButton("Cancel");

	private JPanel panel = new JPanel();

	public RegisterPnl() {
		setLayout(new BorderLayout());

		setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		tfName.setPreferredSize(new Dimension(160, 20));
		tfAddress.setPreferredSize(new Dimension(160, 20));
		tfEmail.setPreferredSize(new Dimension(160, 20));
		tfPhone.setPreferredSize(new Dimension(160, 20));
		tfID.setPreferredSize(new Dimension(160, 20));

		invis.setPreferredSize(new Dimension(440, 20));
		invis1.setPreferredSize(new Dimension(250, 20));
		invis2.setPreferredSize(new Dimension(537, 20));
		invis3.setPreferredSize(new Dimension(348, 20));
		invis4.setPreferredSize(new Dimension(348, 20));

		invis5.setPreferredSize(new Dimension(800, 20));
		invis6.setPreferredSize(new Dimension(800, 20));
		invis7.setPreferredSize(new Dimension(800, 20));
		invis8.setPreferredSize(new Dimension(800, 20));
		bnRegister.setLocation(600, 600);
		
		panel.setPreferredSize(new Dimension(300, 70));
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

		add(panel, BorderLayout.CENTER);

		panel.add(invis);
		panel.add(lblName);
		panel.add(tfName);
		panel.add(invis1);
//		pnlLeft.add(invis5);

		panel.add(lblAddress);
		panel.add(tfAddress);
		panel.add(invis2);
//		pnlLeft.add(invis6);

		panel.add(lblEmail);
		panel.add(tfEmail);
		panel.add(invis3);
//		pnlLeft.add(invis7);

		panel.add(lblPhone);
		panel.add(tfPhone);
		panel.add(invis4);
		// add(invis8);

		panel.add(lblID);
		panel.add(tfID);

		panel.add(bnCancel);
		add(lblStatus);
	}

}
