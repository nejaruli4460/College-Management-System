package admin;

import java.awt.EventQueue;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
//import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePickerImpl;

import ConnectionPackage.Connector;

import java.awt.BorderLayout;
import java.awt.Color;
import Method.Method;
import Method.Validation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.SystemColor;

public class InsertStudent extends JDialog {

	/**
	 * Launch the application.
	 */
	static String  Filename=null;
	String dobInput=null;
	byte [] image=null;
	private JTextField nameInput;
	private JTextField fatInput;
	private JTextField pinInput;
	private JTextField mobileInput;
	private JTextField emailInput;

	/**
	 * Create the dialog.
	 */
	public InsertStudent(DefaultTableModel model) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModal(true);
		
		Method method=new Method();
		setBounds(250, 0, 550, 700);
		getContentPane().setLayout(null);
		
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 534, 661);
		getContentPane().add(Background);
		ImageIcon icon=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon, 534, 661, Background);
		
		JLabel profile = new JLabel("");
		profile.setBackground(Color.WHITE);
		profile.setBounds(364, 47, 148, 168);
		profile.setBorder(new LineBorder(Color.gray,2));
		Background.add(profile);
		
		JButton chooseButton = new JButton("choose");
		chooseButton.setBackground(SystemColor.activeCaption);
		chooseButton.setBounds(398, 227, 89, 23);
		Background.add(chooseButton);
		
		JLabel nameLabel = new JLabel("Student Name");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setBounds(10, 64, 89, 28);
		Background.add(nameLabel);
		
		nameInput = new JTextField();
		nameInput.setBounds(109, 68, 223, 23);
		Background.add(nameInput);
		nameInput.setColumns(10);
		
		JLabel fatName = new JLabel("Father's Name");
		fatName.setForeground(Color.WHITE);
		fatName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fatName.setBounds(10, 116, 89, 28);
		Background.add(fatName);
		
		fatInput = new JTextField();
		fatInput.setColumns(10);
		fatInput.setBounds(109, 121, 223, 23);
		Background.add(fatInput);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setForeground(Color.WHITE);
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genderLabel.setBounds(10, 175, 60, 28);
		Background.add(genderLabel);
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setBounds(109, 179, 53, 23);
		radioButton.setActionCommand("Male");
		Background.add(radioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(188, 179, 72, 23);
		rdbtnFemale.setActionCommand("Female");
		Background.add(rdbtnFemale);
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(272, 179, 60, 23);
		rdbtnOther.setActionCommand("Other");
		Background.add(rdbtnOther);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnFemale);
		group.add(radioButton);
		group.add(rdbtnOther);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(10, 231, 78, 28);
		Background.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 215, 232, 84);
		Background.add(scrollPane);
		
		JTextArea addressInput = new JTextArea();
		scrollPane.setViewportView(addressInput);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setForeground(Color.WHITE);
		lblPincode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPincode.setBounds(10, 331, 78, 28);
		Background.add(lblPincode);
		
		pinInput = new JTextField();
		pinInput.setColumns(10);
		pinInput.setBounds(109, 335, 223, 23);
		Background.add(pinInput);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(10, 392, 78, 28);
		Background.add(lblDateOfBirth);
		
		JLabel lblMobileNumber = new JLabel("Mobile");
		lblMobileNumber.setForeground(Color.WHITE);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMobileNumber.setBounds(10, 445, 78, 28);
		Background.add(lblMobileNumber);
		
		mobileInput = new JTextField();
		mobileInput.setColumns(10);
		mobileInput.setBounds(109, 450, 223, 23);
		Background.add(mobileInput);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailId.setBounds(10, 494, 78, 28);
		Background.add(lblEmailId);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(109, 499, 223, 23);
		Background.add(emailInput);
		
		JLabel lblAppliedFor = new JLabel("Applied For?");
		lblAppliedFor.setForeground(Color.WHITE);
		lblAppliedFor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAppliedFor.setBounds(10, 545, 78, 28);
		Background.add(lblAppliedFor);
		ArrayList<String> list=new ArrayList<String>();
		try {
			Connection con=Connector.connect();
			String query="select * from department";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				list.add(rs.getString(2));
			}
			con.close();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		System.out.println(list);
		String departmentInput="";
		JComboBox comboBox = new JComboBox(list.toArray());
		comboBox.setBackground(SystemColor.activeCaption);
		
		comboBox.setBounds(108, 549, 224, 22);
		Background.add(comboBox);
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.setBackground(SystemColor.activeCaption);
		submitButton.setBounds(109, 607, 89, 23);
		Background.add(submitButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setBackground(SystemColor.activeCaption);
		
		resetButton.setBounds(243, 607, 89, 23);
		Background.add(resetButton);
		
		JDatePickerImpl datePicker=Method.datePicker();
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dobInput=datePicker.getJFormattedTextField().getText();
			}
		});
		datePicker.setBounds(127,397,200,23);
		Background.add(datePicker);
		String comboItem[]= {"2019","2020","2021","2022","2023","2024"};
		JComboBox year = new JComboBox(comboItem);
		year.setBackground(SystemColor.activeCaption);
		year.setBounds(364, 335, 148, 22);
		Background.add(year);
		
		
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser choose=new JFileChooser();
				choose.showOpenDialog(null);
				
				try {
					File f=choose.getSelectedFile();
					Filename=f.getAbsolutePath();
					ImageIcon icon=new ImageIcon(Filename);
					method.resizeImage(icon, 150, 170, profile);
//					File image=new File(Filename);
				}catch(NullPointerException e3) {
					JOptionPane.showMessageDialog(null,"No file chosen");
				}
				
				
				
			}
		});
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(group.isSelected(null)) {
					JOptionPane.showMessageDialog(null, "Select gender","error",JOptionPane.ERROR_MESSAGE);
//					System.out.println("hello");
				}else if(Filename==null){
					JOptionPane.showMessageDialog(null, "Select a image","error",JOptionPane.ERROR_MESSAGE);
				}else if(dobInput==null){
					JOptionPane.showMessageDialog(null, "Select your date of birth","error",JOptionPane.ERROR_MESSAGE);
				}else if(Validation.studentValidation(nameInput.getText(),fatInput.getText(),addressInput.getText(),pinInput.getText(),mobileInput.getText(),emailInput.getText())==true){
					try {
						
						Connection con=Connector.connect();
						int n=0;	
						String count="select max(serial) from student";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(count);
						if(rs.next()) {
							n=rs.getInt(1)+1;
						}
						String userSerial=String.format("%05d",n);
						String username="SNC"+userSerial;
						InputStream in=new FileInputStream(Filename);
						
						String q="insert into student(name,father,gender,address,pin,dob,department,mobile,email,image,year,username) values(?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(q);
						ps.setString(1, nameInput.getText());
						ps.setString(2, fatInput.getText());
						ps.setString(3, group.getSelection().getActionCommand());
						ps.setString(4, addressInput.getText());
						ps.setString(5, pinInput.getText());
						ps.setString(6, dobInput);
						ps.setString(7, comboBox.getSelectedItem().toString());
						ps.setString(8, mobileInput.getText());
						ps.setString(9, emailInput.getText());
						ps.setBlob(10, in);
						ps.setString(11,year.getSelectedItem().toString());
						ps.setString(12,username);
						ps.executeUpdate();
						
						String query="insert into attendance(username,semester,department) values(?,?,?)";
						PreparedStatement p=con.prepareStatement(query);
						p.setString(1,username);
						p.setString(2,"SEMESTER 1");
						p.setString(3,comboBox.getSelectedItem().toString());
						p.executeUpdate();
						
						String query1="insert into result(username,semester,department) values(?,?,?)";
						PreparedStatement p1=con.prepareStatement(query1);
						p1.setString(1,username);
						p1.setString(2,"SEMESTER 1");
						p1.setString(3,comboBox.getSelectedItem().toString());
						p1.executeUpdate();
						
						String query2="insert into studentfees(username,sem) values(?,?)";
						PreparedStatement p2=con.prepareStatement(query2);
						p2.setString(1,username);
						p2.setString(2,"SEMESTER 1");
						p2.executeUpdate();
						
						
						
						JOptionPane.showMessageDialog(null, "Inserted Successfully \n Username "+username);
						con.close();
						model.setRowCount(0);
						Student.refreshTable();
						setVisible(false);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getLocalizedMessage());
						e1.printStackTrace();
					}
				}

			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameInput.setText("");
				fatInput.setText("");
				group.clearSelection();
				addressInput.setText("");
				mobileInput.setText("");
				emailInput.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		
	}
}
