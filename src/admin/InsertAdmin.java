package admin;

import java.awt.Color;
import Method.Method;
import Method.Validation;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePickerImpl;

import ConnectionPackage.Connector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dialog.ModalityType;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class InsertAdmin extends JDialog {

	/**
	 * Launch the application.
	 */
	static String  Filename=null;
	static String dobInput=null;
	private JTextField nameInput;
	private JTextField mobileInput;
	private JTextField emailInput;
	private JTextField designationInput;

	/**
	 * Create the dialog.
	 */
	public InsertAdmin(DefaultTableModel model) {
		setBackground(SystemColor.activeCaption);
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		
		setBounds(400, 20, 535, 651);
		getContentPane().setLayout(null);
		Method method=new Method();
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 534, 661);
		getContentPane().add(Background);
		ImageIcon icon=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon, 534, 661, Background);
		
		JLabel photo = new JLabel("");
		photo.setBounds(349, 56, 100, 104);
		photo.setBorder(new LineBorder(Color.gray,1));
		Background.add(photo);
		
		JButton Choose = new JButton("Choose..");
		Choose.setBackground(SystemColor.activeCaption);
		Choose.setFocusable(false);
		Choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser choose=new JFileChooser();
				choose.showOpenDialog(null);
				
				try {
					File f=choose.getSelectedFile();
					Filename=f.getAbsolutePath();
					ImageIcon icon=new ImageIcon(Filename);
					method.resizeImage(icon, 100, 100, photo);
//					File image=new File(Filename);
				}catch(NullPointerException e3) {
					JOptionPane.showMessageDialog(null,"No file chosen");
				}
			}
		});
		Choose.setBounds(359, 171, 89, 23);
		Background.add(Choose);
		
		JLabel Header = new JLabel("INSERT ADMIN");
		Header.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Header.setForeground(Color.WHITE);
		Header.setBounds(172, 22, 146, 23);
		Background.add(Header);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setBounds(10, 96, 68, 22);
		Background.add(nameLabel);
		
		nameInput = new JTextField();
		nameInput.setBounds(83, 95, 235, 23);
		Background.add(nameInput);
		nameInput.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setForeground(Color.WHITE);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMobile.setBounds(10, 149, 68, 22);
		Background.add(lblMobile);
		
		mobileInput = new JTextField();
		mobileInput.setColumns(10);
		mobileInput.setBounds(83, 149, 235, 23);
		Background.add(mobileInput);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(10, 202, 68, 22);
		Background.add(lblEmail);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(83, 202, 235, 23);
		Background.add(emailInput);
		
		JDatePickerImpl datePicker=Method.datePicker();
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dobInput=datePicker.getJFormattedTextField().getText();
			}
		});
		datePicker.setFocusable(false);
		datePicker.setBounds(83,255,235,25);
		datePicker.setBorder(new LineBorder(Color.black,1));
		Background.add(datePicker);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(10, 255, 73, 22);
		Background.add(lblDateOfBirth);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(Color.WHITE);
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesignation.setBounds(10, 302, 68, 22);
		Background.add(lblDesignation);
		
		designationInput = new JTextField();
		designationInput.setColumns(10);
		designationInput.setBounds(83, 304, 235, 23);
		Background.add(designationInput);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(10, 354, 68, 22);
		Background.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 354, 235, 59);
		Background.add(scrollPane);
		
		JTextArea addressInput = new JTextArea();
		scrollPane.setViewportView(addressInput);
		
		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setForeground(Color.WHITE);
		lblQualification.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQualification.setBounds(10, 437, 68, 22);
		Background.add(lblQualification);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(85, 437, 233, 57);
		Background.add(scrollPane_1);
		
		JTextArea qualInput = new JTextArea();
		scrollPane_1.setViewportView(qualInput);
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.setBackground(SystemColor.activeCaption);
		
		submitButton.setFocusable(false);
		submitButton.setBounds(133, 554, 89, 23);
		Background.add(submitButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setBackground(SystemColor.activeCaption);
		resetButton.setFocusable(false);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dobInput==null) {
					JOptionPane.showMessageDialog(null,"Please select date of birth..","Error",JOptionPane.ERROR_MESSAGE);
				}else if(Filename==null) {
					JOptionPane.showMessageDialog(null,"Please select a picture..","Error",JOptionPane.ERROR_MESSAGE);
				}else if(Validation.adminValidation(nameInput.getText(), mobileInput.getText(),addressInput.getText(), designationInput.getText(), qualInput.getText(), emailInput.getText())){
					try {
						Connection con=Connector.connect();
						InputStream in=new FileInputStream(Filename);
						
						String user="";
						String sql="select max(sl) from admin";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							int n=rs.getInt(1)+1;
							String subUser=String.format("%04d", n);
							user=user.concat("ADMIN"+subUser);
						}
						
						String query="Insert into admin(name,mobile,email,dob,designation,address,qualification,image,username) values(?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, nameInput.getText());
						ps.setString(2, mobileInput.getText());
						ps.setString(3, emailInput.getText());
						ps.setString(4, dobInput);
						ps.setString(5, designationInput.getText());
						ps.setString(6, addressInput.getText());
						ps.setString(7, qualInput.getText());
						ps.setBlob(8, in);
						ps.setString(9, user);
						ps.executeUpdate();
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Successfully inserted \n UserId:"+user);
						model.setRowCount(0);
						Admin.refreshTable();
						con.close();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error occured","error",JOptionPane.ERROR_MESSAGE);;
						e1.printStackTrace();
					}
				}
			}
		});
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameInput.setText("");
				mobileInput.setText("");
				emailInput.setText("");
				designationInput.setText("");
				addressInput.setText("");
				qualInput.setText("");
			}
		});
		resetButton.setBounds(257, 554, 89, 23);
		Background.add(resetButton);

	}
}
