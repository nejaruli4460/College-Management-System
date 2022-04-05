package student;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Marksheet extends JPanel {

	/**
	 * Create the panel.
	 */
	public Marksheet() {
		setBounds(0,0,1440,883);
		setLayout(null);
		setBackground(new Color(0,0,0,80));
		
		JPanel panel = new JPanel();
		panel.setBounds(151, 122, 848, 465);
		add(panel);
		panel.setLayout(null);
		
		String str[]= {"default","sem-1","sem-2","sem-3","sem-4","sem-5","sem-6"};
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 184, 828, 71);
		panel.add(lblNewLabel);
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(111, 11, 125, 22);
		panel.add(comboBox);
		
		JButton resultButton = new JButton("GET RESULT");
		resultButton.setBounds(264, 11, 125, 23);
		panel.add(resultButton);
//		
		resultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1=comboBox.getSelectedItem().toString();
				System.out.println(str1);
				 if(str1.equals(str[0])) {
					 lblNewLabel.setText("");
				 }else {
					 lblNewLabel.setText("your "+str1+" result not generated yet.Wait for further update..");
				 }
				
			}
		});
	}
}

