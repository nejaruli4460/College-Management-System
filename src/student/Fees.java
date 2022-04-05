package student;

import java.awt.Color;

import javax.swing.JPanel;

import Method.Method;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fees extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Create the panel.
	 */
	public Fees() {
		setBounds(0,0,1440,883);
		setLayout(null);
		setBackground(new Color(0,0,0,80));
		
		JLabel feeLabel = new JLabel("ADMISSION FEES PAYMENT");
		feeLabel.setForeground(Color.GRAY);
		feeLabel.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 45));
		feeLabel.setBounds(370, 11, 589, 44);
		add(feeLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(125, 120, 944, 470);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFeesHead = new JLabel("FEES HEAD");
		lblFeesHead.setForeground(new Color(128, 128, 128));
		lblFeesHead.setFont(new Font("Arial", Font.BOLD, 19));
		lblFeesHead.setBounds(72, 25, 124, 14);
		panel.add(lblFeesHead);
		
		JLabel lblPayment = new JLabel("PAYMENT");
		lblPayment.setForeground(Color.GRAY);
		lblPayment.setFont(new Font("Arial", Font.BOLD, 19));
		lblPayment.setBounds(327, 25, 124, 14);
		panel.add(lblPayment);
		
		JLabel lblProcessingFees = new JLabel("Processing Fees");
		lblProcessingFees.setForeground(Color.GRAY);
		lblProcessingFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblProcessingFees.setBounds(72, 62, 175, 14);
		panel.add(lblProcessingFees);
		
		JLabel lblRepairFees = new JLabel("Repair Fees");
		lblRepairFees.setForeground(Color.GRAY);
		lblRepairFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblRepairFees.setBounds(72, 99, 124, 14);
		panel.add(lblRepairFees);
		
		JLabel lblMaintainance = new JLabel("E-Maintainance");
		lblMaintainance.setForeground(Color.GRAY);
		lblMaintainance.setFont(new Font("Arial", Font.PLAIN, 19));
		lblMaintainance.setBounds(72, 136, 175, 14);
		panel.add(lblMaintainance);
		
		JLabel lblGeneralMaintainance = new JLabel("General Maintainance");
		lblGeneralMaintainance.setForeground(Color.GRAY);
		lblGeneralMaintainance.setFont(new Font("Arial", Font.PLAIN, 19));
		lblGeneralMaintainance.setBounds(72, 173, 186, 14);
		panel.add(lblGeneralMaintainance);
		
		JLabel lblLabrotaryFees = new JLabel("Labrotary Fees");
		lblLabrotaryFees.setForeground(Color.GRAY);
		lblLabrotaryFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblLabrotaryFees.setBounds(72, 210, 134, 14);
		panel.add(lblLabrotaryFees);
		
		JLabel lblLibraryFess = new JLabel("Library Fees");
		lblLibraryFess.setForeground(Color.GRAY);
		lblLibraryFess.setFont(new Font("Arial", Font.PLAIN, 19));
		lblLibraryFess.setBounds(72, 247, 124, 14);
		panel.add(lblLibraryFess);
		
		JLabel lblSeminar = new JLabel("Seminar");
		lblSeminar.setForeground(Color.GRAY);
		lblSeminar.setFont(new Font("Arial", Font.PLAIN, 19));
		lblSeminar.setBounds(72, 284, 124, 14);
		panel.add(lblSeminar);
		
		JLabel lblSessionCharge = new JLabel("Session Charge");
		lblSessionCharge.setForeground(Color.GRAY);
		lblSessionCharge.setFont(new Font("Arial", Font.PLAIN, 19));
		lblSessionCharge.setBounds(72, 321, 161, 14);
		panel.add(lblSessionCharge);
		
		JLabel lblStudentActivityFees = new JLabel("Student Activity Fees");
		lblStudentActivityFees.setForeground(Color.GRAY);
		lblStudentActivityFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblStudentActivityFees.setBounds(72, 358, 186, 14);
		panel.add(lblStudentActivityFees);
		
		JLabel lblTutionFees = new JLabel("Tution Fees");
		lblTutionFees.setForeground(Color.GRAY);
		lblTutionFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblTutionFees.setBounds(72, 395, 124, 14);
		panel.add(lblTutionFees);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("250");
		textField.setBounds(327, 62, 134, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("350");
		textField_1.setColumns(10);
		textField_1.setBounds(327, 99, 134, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("250");
		textField_2.setColumns(10);
		textField_2.setBounds(327, 136, 134, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("250");
		textField_3.setColumns(10);
		textField_3.setBounds(327, 173, 134, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		String lab=labFees("CMSG");
		textField_4.setText(lab);
		textField_4.setColumns(10);
		textField_4.setBounds(327, 210, 134, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("100");
		textField_5.setColumns(10);
		textField_5.setBounds(327, 247, 134, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("100");
		textField_6.setColumns(10);
		textField_6.setBounds(327, 284, 134, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("350");
		textField_7.setColumns(10);
		textField_7.setBounds(327, 321, 134, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setText("400");
		textField_8.setColumns(10);
		textField_8.setBounds(327, 358, 134, 20);
		panel.add(textField_8);
		String tf=tutionFees("BSC(G)");
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setText(tf);
		textField_9.setColumns(10);
		textField_9.setBounds(327, 389, 134, 20);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBounds(718, 62, 140, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JButton totalButton = new JButton("TOTAL CALCULATE");
		totalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equal=(Integer.parseInt(textField.getText()))+(Integer.parseInt(textField_1.getText()))+(Integer.parseInt(textField_2.getText()))+(Integer.parseInt(textField_3.getText()))+(Integer.parseInt(textField_4.getText()))+(Integer.parseInt(textField_5.getText()))+(Integer.parseInt(textField_6.getText()))+(Integer.parseInt(textField_7.getText()))+(Integer.parseInt(textField_8.getText()))+(Integer.parseInt(textField_9.getText()));
				textField_10.setText(""+equal);
			}
		});
		totalButton.setBounds(485, 61, 186, 23);
		totalButton.setFocusable(false);
		panel.add(totalButton);
		
		JButton payButton = new JButton("PAY");
		payButton.setBounds(626, 118, 89, 23);
		panel.add(payButton);
		
		
	}

	private String tutionFees(String s) {
		if(s.equals("BA(H)")) {
			return "450";
		}else if(s.equals("BSC(H)")) {
			return "660";
		}else if(s.equals("BSC(G)") ){
			return "510";
		}else if(s.equals("BA(G)")) {
			return "300";
		}else if(s.equals("BCOM(H)")) {
			return "510";
		}else {
			return "360";
		}
	}

	private String labFees(String string) {
		if(string.equals("CMSA") ){
			return "7500";
		}else if(string.equals("CMSG")){
			return "2500";
		}
		return null;
	}

}
