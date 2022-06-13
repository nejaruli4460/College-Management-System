package student;

import java.awt.Color;

import javax.swing.JPanel;

import Method.Method;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;

import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Fees extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField labFees;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField tutionFees;
	private JTextField textField_10;

	/**
	 * Create the panel.
	 */
	public Fees(int serial) {
		setBounds(0,0,1440,883);
		setLayout(null);
		setBackground(new Color(0,0,0,80));
		
		
		JLabel feeLabel = new JLabel("ADMISSION FEES PAYMENT");
		feeLabel.setBackground(Color.ORANGE);
		feeLabel.setForeground(Color.WHITE);
		feeLabel.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 45));
		feeLabel.setBounds(370, 11, 589, 44);
		add(feeLabel);
	
		JPanel panel1 = new JPanel();
		panel1.setBounds(125, 120, 944, 470);
		add(panel1);
		panel1.setLayout(null);
		add(panel1);
		panel1.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Fees Paid For your "+Method.currentSem(serial));
		lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 47));
		lblNewLabel.setBounds(202, 107, 718, 148);
		panel1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(125, 120, 944, 470);
		add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
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
////		String comboItem[]= {"SEMESTER 1","SEMESTER 2","SEMESTER 3","SEMESTER 4","SEMESTER 5","SEMESTER 6"};
//		JComboBox comboBox = new JComboBox(comboItem);
//		comboBox.setBounds(125, 100, 944, 22);
//		add(comboBox);
		
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
		
		labFees = new JTextField();
		labFees.setEditable(false);
		labFees.setColumns(10);
		labFees.setBounds(327, 210, 134, 20);
		panel.add(labFees);
		
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
		tutionFees = new JTextField();
		tutionFees.setEditable(false);
		tutionFees.setColumns(10);
		tutionFees.setBounds(327, 389, 134, 20);
		panel.add(tutionFees);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBounds(718, 62, 140, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JButton totalButton = new JButton("TOTAL CALCULATE");
		totalButton.setBackground(SystemColor.activeCaption);
		totalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equal=(Integer.parseInt(textField.getText()))+(Integer.parseInt(textField_1.getText()))+(Integer.parseInt(textField_2.getText()))+(Integer.parseInt(textField_3.getText()))+(Integer.parseInt(labFees.getText()))+(Integer.parseInt(textField_5.getText()))+(Integer.parseInt(textField_6.getText()))+(Integer.parseInt(textField_7.getText()))+(Integer.parseInt(textField_8.getText()))+(Integer.parseInt(tutionFees.getText()));
				textField_10.setText(""+equal);
			}
		});
		totalButton.setBounds(485, 61, 186, 23);
		totalButton.setFocusable(false);
		panel.add(totalButton);
		
		try {
			Connection connect=Connector.connect();
			String sql="select status from studentfees where username=? and sem=?";
			PreparedStatement prepare=connect.prepareStatement(sql);
			prepare.setString(1, Method.usernameBySerial(serial));
			prepare.setString(2, Method.currentSem(serial));
			ResultSet result=prepare.executeQuery();
			if(result.next()) {
				if(result.getString(1).equals("paid")) {
					panel1.setVisible(true);
				}else {
					panel.setVisible(true);
				}
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JButton payButton = new JButton("PAY");
		payButton.setBackground(SystemColor.activeCaption);
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=Connector.connect();
					String query="Update studentfees set status=? where username=(select username from student where serial=?) and sem=?";
					
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,"paid");
					ps.setInt(2,serial);
//					ps.setString(2,comboBox.getSelectedItem().toString());
					ps.setString(3,Method.currentSem(serial));
					ps.executeUpdate();
										
					JOptionPane.showMessageDialog(null, "Fees Successfully Paid","Successfull",JOptionPane.INFORMATION_MESSAGE);
					panel.setVisible(false);
					panel1.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		payButton.setBounds(626, 118, 89, 23);
		payButton.setFocusable(false);
		panel.add(payButton);
		
		
		try {
			Connection con =Connector.connect();
			String q="select lab,tution from fees where department=(select department from student where serial=?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				labFees.setText(""+rs.getInt(1));
				tutionFees.setText(""+rs.getInt(2));
			}
			con.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
