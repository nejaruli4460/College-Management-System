package student;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

import ConnectionPackage.Connector;
import Method.Method;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.SwingConstants;

public class Reciept extends JPanel {

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
	public Reciept(int serial) {
		setBounds(0,0,1440,883);
		setLayout(null);
		setBackground(new Color(0,0,0,80));
				
		Method method=new Method();
		JLabel upperBackground = new JLabel("");
		upperBackground.setBackground(SystemColor.activeCaption);
		upperBackground.setForeground(Color.GRAY);
		ImageIcon image=new ImageIcon(".\\asset\\uperBack.jpg");
	
		method.resizeImage(image,1300,883,upperBackground);
		upperBackground.setBounds(0, 0, 1301, 883);
		add(upperBackground);

		
				ArrayList list=new ArrayList();
				try {
					Connection con=Connector.connect();
					String sql="select sem from studentfees where username=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, Method.usernameBySerial(serial));
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						list.add(rs.getString(1));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				JPanel panelHead = new JPanel();
				panelHead.setBounds(151, 66, 848, 112);
				upperBackground.add(panelHead);
				panelHead.setVisible(false);
				panelHead.setLayout(null);
				
				JPanel panelPaid = new JPanel();
				panelPaid.setBounds(151, 190, 848, 463);
				upperBackground.add(panelPaid);
				panelPaid.setVisible(false);
				panelPaid.setLayout(null);
				
				JLabel lblName = new JLabel("Name :");
				lblName.setForeground(Color.GRAY);
				lblName.setFont(new Font("Arial", Font.BOLD, 19));
				lblName.setBounds(10, 49, 66, 23);
				panelHead.add(lblName);
				
				JLabel nameField = new JLabel(Method.nameBySerial(serial));
				nameField.setForeground(Color.GRAY);
				nameField.setFont(new Font("Arial", Font.BOLD, 19));
				nameField.setBounds(86, 49, 350, 23);
				panelHead.add(nameField);
				
				JLabel lblStudentId = new JLabel("Student ID :");
				lblStudentId.setForeground(Color.GRAY);
				lblStudentId.setFont(new Font("Arial", Font.BOLD, 19));
				lblStudentId.setBounds(446, 56, 125, 23);
				panelHead.add(lblStudentId);
				
				JLabel studentIdField = new JLabel(Method.usernameBySerial(serial));
				studentIdField.setForeground(Color.GRAY);
				studentIdField.setFont(new Font("Arial", Font.BOLD, 19));
				studentIdField.setBounds(581, 56, 243, 23);
				panelHead.add(studentIdField);
				
				JLabel lblSemester = new JLabel("Semester :");
				lblSemester.setForeground(Color.GRAY);
				lblSemester.setFont(new Font("Arial", Font.BOLD, 19));
				lblSemester.setBounds(446, 22, 125, 23);
				panelHead.add(lblSemester);
				
				JLabel SemesterField = new JLabel();
				SemesterField.setForeground(Color.GRAY);
				SemesterField.setFont(new Font("Arial", Font.BOLD, 19));
				SemesterField.setBounds(559, 22, 243, 23);
				panelHead.add(SemesterField);
		
				JPanel panelHome = new JPanel();
				panelHome.setBounds(151, 198, 848, 389);
				upperBackground.add(panelHome);
				panelHome.setVisible(true);
				panelHome.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Select Semester then click on Payment Reciept to generate payment reciept");
				lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 21));
				lblNewLabel_1.setBounds(30, 236, 808, 83);
				panelHome.add(lblNewLabel_1);
		//		
		
		
		JPanel panelDue = new JPanel();
		panelDue.setBounds(151, 184, 848, 403);
		upperBackground.add(panelDue);
		panelDue.setVisible(false);
		panelDue.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fees Not Paid Yet");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 46));
		lblNewLabel.setBounds(120, 133, 503, 130);
		panelDue.add(lblNewLabel);
		
		
		
		
		JLabel lblFeesHead = new JLabel("FEES HEAD");
		lblFeesHead.setForeground(new Color(128, 128, 128));
		lblFeesHead.setFont(new Font("Arial", Font.BOLD, 19));
		lblFeesHead.setBounds(72, 25, 124, 14);
		panelPaid.add(lblFeesHead);
		
		JLabel lblPayment = new JLabel("PAYMENT");
		lblPayment.setForeground(Color.GRAY);
		lblPayment.setFont(new Font("Arial", Font.BOLD, 19));
		lblPayment.setBounds(327, 25, 124, 14);
		panelPaid.add(lblPayment);
		
		JLabel lblProcessingFees = new JLabel("Processing Fees");
		lblProcessingFees.setForeground(Color.GRAY);
		lblProcessingFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblProcessingFees.setBounds(72, 62, 175, 14);
		panelPaid.add(lblProcessingFees);
		
		JLabel lblRepairFees = new JLabel("Repair Fees");
		lblRepairFees.setForeground(Color.GRAY);
		lblRepairFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblRepairFees.setBounds(72, 99, 124, 14);
		panelPaid.add(lblRepairFees);
		
		JLabel lblMaintainance = new JLabel("E-Maintainance");
		lblMaintainance.setForeground(Color.GRAY);
		lblMaintainance.setFont(new Font("Arial", Font.PLAIN, 19));
		lblMaintainance.setBounds(72, 136, 175, 14);
		panelPaid.add(lblMaintainance);
		
		JLabel lblGeneralMaintainance = new JLabel("General Maintainance");
		lblGeneralMaintainance.setForeground(Color.GRAY);
		lblGeneralMaintainance.setFont(new Font("Arial", Font.PLAIN, 19));
		lblGeneralMaintainance.setBounds(72, 173, 186, 14);
		panelPaid.add(lblGeneralMaintainance);
		
		JLabel lblLabrotaryFees = new JLabel("Labrotary Fees");
		lblLabrotaryFees.setForeground(Color.GRAY);
		lblLabrotaryFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblLabrotaryFees.setBounds(72, 210, 134, 14);
		panelPaid.add(lblLabrotaryFees);
		
		JLabel lblLibraryFess = new JLabel("Library Fees");
		lblLibraryFess.setForeground(Color.GRAY);
		lblLibraryFess.setFont(new Font("Arial", Font.PLAIN, 19));
		lblLibraryFess.setBounds(72, 247, 124, 14);
		panelPaid.add(lblLibraryFess);
		
		JLabel lblSeminar = new JLabel("Seminar");
		lblSeminar.setForeground(Color.GRAY);
		lblSeminar.setFont(new Font("Arial", Font.PLAIN, 19));
		lblSeminar.setBounds(72, 284, 124, 14);
		panelPaid.add(lblSeminar);
		
		JLabel lblSessionCharge = new JLabel("Session Charge");
		lblSessionCharge.setForeground(Color.GRAY);
		lblSessionCharge.setFont(new Font("Arial", Font.PLAIN, 19));
		lblSessionCharge.setBounds(72, 321, 161, 14);
		panelPaid.add(lblSessionCharge);
		
		JLabel lblStudentActivityFees = new JLabel("Student Activity Fees");
		lblStudentActivityFees.setForeground(Color.GRAY);
		lblStudentActivityFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblStudentActivityFees.setBounds(72, 358, 186, 14);
		panelPaid.add(lblStudentActivityFees);
		
		JLabel lblTutionFees = new JLabel("Tution Fees");
		lblTutionFees.setForeground(Color.GRAY);
		lblTutionFees.setFont(new Font("Arial", Font.PLAIN, 19));
		lblTutionFees.setBounds(72, 395, 124, 14);
		panelPaid.add(lblTutionFees);
////		String comboItem[]= {"SEMESTER 1","SEMESTER 2","SEMESTER 3","SEMESTER 4","SEMESTER 5","SEMESTER 6"};
//		JComboBox comboBox = new JComboBox(comboItem);
//		comboBox.setBounds(125, 100, 944, 22);
//		add(comboBox);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("250");
		textField.setBounds(327, 62, 134, 20);
		panelPaid.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("350");
		textField_1.setColumns(10);
		textField_1.setBounds(327, 99, 134, 20);
		panelPaid.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("250");
		textField_2.setColumns(10);
		textField_2.setBounds(327, 136, 134, 20);
		panelPaid.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("250");
		textField_3.setColumns(10);
		textField_3.setBounds(327, 173, 134, 20);
		panelPaid.add(textField_3);
		
		labFees = new JTextField();
		labFees.setEditable(false);
		labFees.setColumns(10);
		labFees.setBounds(327, 210, 134, 20);
		panelPaid.add(labFees);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("100");
		textField_5.setColumns(10);
		textField_5.setBounds(327, 247, 134, 20);
		panelPaid.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("100");
		textField_6.setColumns(10);
		textField_6.setBounds(327, 284, 134, 20);
		panelPaid.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("350");
		textField_7.setColumns(10);
		textField_7.setBounds(327, 321, 134, 20);
		panelPaid.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setText("400");
		textField_8.setColumns(10);
		textField_8.setBounds(327, 358, 134, 20);
		panelPaid.add(textField_8);
		tutionFees = new JTextField();
		tutionFees.setEditable(false);
		tutionFees.setColumns(10);
		tutionFees.setBounds(327, 389, 134, 20);
		panelPaid.add(tutionFees);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBounds(663, 62, 140, 20);
		panelPaid.add(textField_10);
		textField_10.setColumns(10);

		
		
		
		
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

		int equal=(Integer.parseInt(textField.getText()))+(Integer.parseInt(textField_1.getText()))+(Integer.parseInt(textField_2.getText()))+(Integer.parseInt(textField_3.getText()))+(Integer.parseInt(labFees.getText()))+(Integer.parseInt(textField_5.getText()))+(Integer.parseInt(textField_6.getText()))+(Integer.parseInt(textField_7.getText()))+(Integer.parseInt(textField_8.getText()))+(Integer.parseInt(tutionFees.getText()));
		textField_10.setText(""+equal);
		
		JLabel lblTotalFeesPaid = new JLabel("Total Fees Paid");
		lblTotalFeesPaid.setForeground(Color.GRAY);
		lblTotalFeesPaid.setFont(new Font("Arial", Font.PLAIN, 19));
		lblTotalFeesPaid.setBounds(491, 62, 134, 20);
		panelPaid.add(lblTotalFeesPaid);
		
		JLabel paidStamp = new JLabel("");
		paidStamp.setBackground(Color.WHITE);
		paidStamp.setBounds(568, 139, 201, 195);
		panelPaid.add(paidStamp);
		
		ImageIcon icon=new ImageIcon(".\\asset\\paid.png");
		
		method.resizeImage(icon, 201, 195, paidStamp);
		
		JButton recieptButton = new JButton("GET Reciept");
		recieptButton.setBackground(SystemColor.activeCaption);
		upperBackground.add(recieptButton);
		recieptButton.setBounds(781, 11, 212, 23);
		recieptButton.setFocusable(false);
		
		JComboBox comboBox = new JComboBox(list.toArray());
		upperBackground.add(comboBox);
		comboBox.setBounds(151, 11, 607, 22);
	recieptButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String sem=comboBox.getSelectedItem().toString();
			SemesterField.setText(sem);
			System.out.println(sem);
			try {
				Connection con=Connector.connect();
				String query="select status from studentfees where username=? and sem=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, Method.usernameBySerial(serial));
				ps.setString(2, sem);
				ResultSet rs=ps.executeQuery();
				System.out.println("hello");
				if(rs.next()) {
					if(rs.getString(1).equals("paid")) {
						panelHome.setVisible(false);
						panelPaid.setVisible(true);
						panelHead.setVisible(true);
						panelDue.setVisible(false);
						
					}else {
						panelHome.setVisible(false);
						panelPaid.setVisible(false);
						panelHead.setVisible(false);
						panelDue.setVisible(true);
						
					}
				}
				con.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
	

}
}
