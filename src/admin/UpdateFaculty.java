package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePickerImpl;

import ConnectionPackage.Connector;
import Method.Method;
import Method.Validation;

import java.awt.SystemColor;

public class UpdateFaculty extends JDialog {
	static String  Filename=null;
	static String dobInput=null;
	byte [] image=null;
	private JTextField nameInput;
	private JTextField mobileInput;
	private JTextField designationInput;
	private JTextField emailInput;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public UpdateFaculty(JTable table,DefaultTableModel model) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		
		setBounds(250, 0, 715, 700);
		getContentPane().setLayout(null);
		
		Method method=new Method();
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 715, 700);
		getContentPane().add(Background);
		ImageIcon icon2=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon2, 715, 701, Background);
		
		
		JLabel profile = new JLabel("");
		profile.setBounds(532, 95, 100, 116);
		profile.setBorder(new LineBorder(Color.gray,2));
		Background.add(profile);
		JButton chooseButton = new JButton("choose");
		chooseButton.setBackground(SystemColor.activeCaption);
		chooseButton.setBounds(543, 222, 89, 23);
		Background.add(chooseButton);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBackground(Color.WHITE);
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
		
		if(table!=null && model!=null) {
			int row=table.getSelectedRow();
			nameInput.setText(model.getValueAt(row, 1).toString());
			mobileInput.setText(model.getValueAt(row, 6).toString());
			String Gender=model.getValueAt(row, 4).toString();
			if(Gender.equals("Male")) {
				radioButton.setSelected(true);
			}else if(Gender.equals("Female")) {
				rdbtnFemale.setSelected(true);
			}else {
				rdbtnOther.setSelected(true);
			}
			addressInput.setText(model.getValueAt(row, 5).toString());
			designationInput.setText(model.getValueAt(row, 9).toString());
			String dob=model.getValueAt(row, 3).toString();
			datePicker.getJFormattedTextField().setText(dob);
			qualInput.setText(model.getValueAt(row, 10).toString());
			emailInput.setText(model.getValueAt(row, 7).toString());
			comboBox.setSelectedItem(model.getValueAt(row, 8));
			aotInput.setText(model.getValueAt(row, 11).toString());
			InputStream bl = null;
			OutputStream out;
			ImageIcon icon=null;
			try {
				int serial=Integer.parseInt(model.getValueAt(row, 0).toString()) ;
				Connection con=Connector.connect();
				String q="select * from faculty where sl=?";
				PreparedStatement ps=con.prepareStatement(q);
				ps.setInt(1,serial);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					Blob b=rs.getBlob(13);
					InputStream is=b.getBinaryStream();
					Image image=ImageIO.read(is);
					icon=new ImageIcon(image);
				}
				method.resizeImage(icon, 100,100, profile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
			
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(group.isSelected(null)) {
					JOptionPane.showMessageDialog(null, "Please select gender","error",JOptionPane.ERROR_MESSAGE);
//					System.out.println("hello");
					}else if(Validation.facultyValidation(nameInput.getText(),mobileInput.getText(),addressInput.getText(),designationInput.getText(),qualInput.getText(),emailInput.getText(),aotInput.getText())) {

					try {
						Connection con=Connector.connect();
						
						
						if(Filename!=null) {
							InputStream in=new FileInputStream(Filename);
						String	sql="update faculty set name=?,dob=?,gender=?,address=?,mobile=?,email=?,department=?,designation=?,Qualification=?,aot=?,image=? where sl=? ";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, nameInput.getText());
						ps.setString(2, datePicker.getJFormattedTextField().getText());
						ps.setString(3,group.getSelection().getActionCommand());
						ps.setString(4, addressInput.getText());
						ps.setString(5, mobileInput.getText());
						ps.setString(6, emailInput.getText());
						ps.setString(7, comboBox.getSelectedItem().toString());
						ps.setString(8, designationInput.getText());
						ps.setString(9, qualInput.getText());
						ps.setString(10, aotInput.getText());
						ps.setBlob(11,in);
						ps.setInt(12,Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString()));
						ps.executeUpdate();
						}else {
							String	sql="update faculty set name=?,dob=?,gender=?,address=?,mobile=?,email=?,department=?,designation=?,Qualification=?,aot=? where sl=? ";
							PreparedStatement ps=con.prepareStatement(sql);
							ps.setString(1, nameInput.getText());
							ps.setString(2, datePicker.getJFormattedTextField().getText());
							ps.setString(3,group.getSelection().getActionCommand());
							ps.setString(4, addressInput.getText());
							ps.setString(5, mobileInput.getText());
							ps.setString(6, emailInput.getText());
							ps.setString(7, comboBox.getSelectedItem().toString());
							ps.setString(8, designationInput.getText());
							ps.setString(9, qualInput.getText());
							ps.setString(10, aotInput.getText());
							ps.setInt(11,Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString()));
							ps.executeUpdate();
						}
						
						
						JOptionPane.showMessageDialog(null, "Row Updated");
						con.close();
						model.setRowCount(0);
						Faculty.refreshTable();
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


