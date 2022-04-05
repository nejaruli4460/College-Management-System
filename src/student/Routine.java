package student;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import Method.Method;
public class Routine extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Routine() {
		setBounds(0,0,1440,883);
		setLayout(null);
		setBackground(new Color(0,0,0,80));
		Method method=new Method();
		
		JLabel routineLabel = new JLabel("ROUTINE");
		routineLabel.setForeground(Color.ORANGE);
		routineLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 45));
		routineLabel.setBorder(new EtchedBorder(3));
		
		routineLabel.setBounds(522, 36, 182, 56);
		add(routineLabel);
		
		JLabel routineBackground = new JLabel("");
		routineBackground.setBounds(138, 60, 1069, 655);
		add(routineBackground);
		ImageIcon routineBack=new ImageIcon(".\\asset\\routine.jpg");
		method.resizeImage(routineBack, 950,555, routineBackground);
	
		
		
	}
}
