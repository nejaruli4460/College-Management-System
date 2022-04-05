package faculty;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JCheckBoxMenuItem;

public class MarksDistribute extends JPanel {
	JComboBox combo;
	/**
	 * Create the panel.
	 */
	public MarksDistribute() {
		setBounds(0,0,1440,883);
		setLayout(null);
		setBackground(new Color(0,0,0,80));
		
		JPanel panel = new JPanel();
		panel.setBounds(151, 122, 848, 465);
		add(panel);
		panel.setLayout(null);
		
		String str[]= {"semester-1","semester-2","semester-3","semester-4","semester-5","semester-6"};
		
		JComboBox comboBox = new JComboBox(str);

		comboBox.setBounds(39, 11, 187, 22);
		panel.add(comboBox);
	}
	
}
