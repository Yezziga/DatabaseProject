package frontend;

import java.awt.*;
import javax.swing.*;

public class Terminal extends JPanel{
	private JLabel lblTitle;
	private JScrollPane pane;
	private JTextField tfInput;
	private JList<String> list;
	
	
	public Terminal() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		lblTitle = new JLabel("Title goes here");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		list = new JList<String>();
		pane = new JScrollPane(list);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tfInput = new JTextField("Input goes here");
		
		String[] data = { "CPH_BER, \"BER_CPH\", \"STO_BER\", \"BER_CPH\", \"STO_BER\", \"BER_CPH\", \"STO_BER\", \"BER_CPH\",\r\n" + 
				"				\"STO_BER\", \"BER_CPH\", \"STO_BER\", \"BER_CPH\", \"STO_BER\"", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH",
				"STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH",
				"STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER", "BER_CPH",
				"STO_BER", "BER_CPH", "STO_BER", "BER_CPH", "STO_BER" }; // TESTI
		list.setListData(data);
		
		add(lblTitle, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		add(tfInput, BorderLayout.SOUTH);
		
	}


}
