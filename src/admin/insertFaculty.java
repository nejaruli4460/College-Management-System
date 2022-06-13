package admin;

import java.awt.Color;
import Method.Validation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import ConnectionPackage.Connector;
import Method.Method;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.SystemColor;

public class insertFaculty extends JDialog {

	/**
	 * Launch the application.
	 */
	static String  Filename=null;
	static String dobInput=null;
	byte [] image=null;
	private JTextField nameInput;
	private JTextField mobileInput;
	private JTextField designationInput;
	private JTextField emailInput;

	/**
	 * Create the dialog.
	 */
	public insertFaculty(DefaultTableModel model) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		
		setBounds(250, 0, 715, 700);
		getContentPane().setLayout(null);
		Method method=new Method();
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 715, 700);
		getContentPane().add(Background);
		ImageIcon icon=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon, 715, 701, Background);
		
		JLabel profile = new JLabel("");
		profile.setBounds(510, 43, 144, 168);
		profile.setBorder(new LineBorder(Color.gray,2));
		Background.add(profile);
		JButton chooseButton = new JButton("choose");
		chooseButton.setBackground(SystemColor.activeCaption);
		chooseButton.setBounds(543, 222, 89, 23);
		Background.add(chooseButton);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setBounds(10, 64, 89, 28);
		Background.add(nameLabel);
		
		nameInput = new JTextField();
		nameInput.setBounds(109, 68, 223, 23);
		Background.add(nameInput);
		nameInput.setColumns(10);
		
		JLabel fatName = new JLabel("Mobile");
		fatName.setForeground(Color.WHITE);
		fatName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fatName.setBounds(10, 116, 89, 28);
		Background.add(fatName);
		
		mobileInput = new JTextField();
		mobileInput.setColumns(10);
		mobileInput.setBounds(109, 121, 223, 23);
		Background.add(mobileInput);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setForeground(Color.WHITE);
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genderLabel.setBounds(10, 175, 60, 28);
		Background.add(genderLabel);
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setForeground(Color.LIGHT_GRAY);
		radioButton.setBounds(109, 179, 53, 23);
		radioButton.setActionCommand("Male");
		Background.add(radioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(Color.LIGHT_GRAY);
		rdbtnFemale.setBounds(188, 179, 72, 23);
		rdbtnFemale.setActionCommand("Female");
		Background.add(rdbtnFemale);
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setForeground(Color.LIGHT_GRAY);
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
		
		JLabel designationlabel = new JLabel("Designation");
		designationlabel.setForeground(Color.WHITE);
		designationlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		designationlabel.setBounds(10, 331, 78, 28);
		Background.add(designationlabel);
		
		designationInput = new JTextField();
		designationInput.setColumns(10);
		designationInput.setBounds(109, 335, 223, 23);
		Background.add(designationInput);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(10, 392, 78, 28);
		Background.add(lblDateOfBirth);
		
		
		JDatePickerImpl datePicker=Method.datePicker();
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dobInput=datePicker.getJFormattedTextField().getText();
			}
		});
		datePicker.setBounds(119,400,200,23);
		Background.add(datePicker);
		
		
		
		JLabel lblMobileNumber = new JLabel("Qualification");
		lblMobileNumber.setForeground(Color.WHITE);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMobileNumber.setBounds(10, 445, 78, 28);
		Background.add(lblMobileNumber);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailId.setBounds(10, 494, 78, 28);
		Background.add(lblEmailId);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(109, 499, 223, 23);
		Background.add(emailInput);
		
		JLabel lblAppliedFor = new JLabel("Department");
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
		comboBox.setBackground(Color.WHITE);
		
		comboBox.setBounds(108, 549, 224, 22);
		Background.add(comboBox);
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.setBackground(SystemColor.activeCaption);
		submitButton.setBounds(253, 607, 89, 23);
		Background.add(submitButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setBackground(SystemColor.activeCaption);
		
		resetButton.setBounds(410, 607, 89, 23);
		Background.add(resetButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(110, 445, 231, 38);
		Background.add(scrollPane_1);
		
		JTextArea qualInput = new JTextArea();
		scrollPane_1.setViewportView(qualInput);
		
		JLabel lblAreaOfInterest = new JLabel("Area of Interest");
		lblAreaOfInterest.setForeground(Color.WHITE);
		lblAreaOfInterest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAreaOfInterest.setBounds(374, 400, 115, 28);
		Background.add(lblAreaOfInterest);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(447, 439, 227, 71);
		Background.add(scrollPane_3);
		
		JTextArea aotInput = new JTextArea();
		scrollPane_3.setViewportView(aotInput);
		
//		System.out.println(dobInput);
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
					JOptionPane.showMessageDialog(null, "Please select gender","error",JOptionPane.ERROR_MESSAGE);
//					System.out.println("hello");
				}else if(Filename==null) {
					JOptionPane.showMessageDialog(null, "Please select a image","error",JOptionPane.ERROR_MESSAGE);
				}else if(dobInput==null) {
					JOptionPane.showMessageDialog(null, "Please select date of birth","error",JOptionPane.ERROR_MESSAGE);
				}else if(Validation.facultyValidation(nameInput.getText(),mobileInput.getText(),addressInput.getText(),designationInput.getText(),qualInput.getText(),emailInput.getText(),aotInput.getText())) {
					try {
						Connection con=Connector.connect();
						InputStream in=new FileInputStream(Filename);
						
						String user="";
						String query="select max(sl) from faculty";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(query);
						if(rs.next()) {
							int n=rs.getInt(1)+1;
							String form=String.format("%04d",n);
							user=user.concat("SNCF"+form);
						}
						
						String q="insert into faculty(name,dob,gender,address,mobile,email,department,designation,qualification,aot,image,username) values(?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(q);
						ps.setString(1, nameInput.getText());
						ps.setString(5, mobileInput.getText());
						ps.setString(3, group.getSelection().getActionCommand());
						ps.setString(4, addressInput.getText());
						ps.setString(8, designationInput.getText());
						ps.setString(2, dobInput);
						ps.setString(7, comboBox.getSelectedItem().toString());
						ps.setString(6, emailInput.getText());
						ps.setString(9,qualInput.getText());
						ps.setString(10,aotInput.getText());
						ps.setBlob(11, in);
						ps.setString(12,user);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Inserted Successfully\n UserId : "+user);
						con.close();
						model.setRowCount(0);
						Student.refreshTable();
						setVisible(false);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"error");
						e1.printStackTrace();
					}
				}

			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameInput.setText("");
				mobileInput.setText("");
				group.clearSelection();
				addressInput.setText("");
				mobileInput.setText("");
				emailInput.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		
	}
}
