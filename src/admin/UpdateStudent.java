package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePickerImpl;

import ConnectionPackage.Connector;
import Method.Method;
import Method.Validation;

import java.awt.Dialog.ModalityType;
import java.awt.SystemColor;

public class UpdateStudent extends JDialog {

	/**
	 * Launch the application.
	 */
	static String  Filename=null;
	String dobInput;
	InputStream input;
	byte [] image=null;
	private JTextField nameInput;
	private JTextField fatInput;
	private JTextField pinInput;
	private JTextField mobileInput;

	/**
	 * Create the dialog.
	 */
	public UpdateStudent(DefaultTableModel model,JTable table) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModal(true);
		
		setBounds(250, 0, 550, 700);
		getContentPane().setLayout(null);
		
		Method method=new Method();
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 534, 661);
		getContentPane().add(Background);
		ImageIcon icon2=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon2, 534, 661, Background);
		
		JLabel profile = new JLabel("");
		profile.setBounds(386, 83, 101, 111);
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
		
		JDatePickerImpl datePicker=Method.datePicker();
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dobInput=datePicker.getJFormattedTextField().getText();
			}
		});
		datePicker.setBounds(127,397,200,23);
		Background.add(datePicker);
		
		mobileInput = new JTextField();
		mobileInput.setColumns(10);
		mobileInput.setBounds(109, 436, 223, 23);
		Background.add(mobileInput);
		
		ArrayList<String> list=new ArrayList<String>();
		if(table!=null && model!=null) {
			int rowIndex=table.getSelectedRow();
			String name=model.getValueAt(rowIndex, 2).toString();
			String fatname=model.getValueAt(rowIndex, 3).toString();
			String Gender=model.getValueAt(rowIndex, 4).toString();
			String Address=model.getValueAt(rowIndex, 5).toString();
			String Pin=model.getValueAt(rowIndex, 6).toString();
			String dob=model.getValueAt(rowIndex, 7).toString();
			mobileInput.setText(model.getValueAt(rowIndex, 9).toString());
			nameInput.setText(name);
			fatInput.setText(fatname);
			if(Gender.equals("Male")) {
				radioButton.setSelected(true);
			}else if(Gender.equals("Female")) {
				rdbtnFemale.setSelected(true);
			}else {
				rdbtnOther.setSelected(true);
			}
			datePicker.getJFormattedTextField().setText(dob);
			
			addressInput.setText(Address);
			pinInput.setText(Pin);
			InputStream bl = null;
			OutputStream out;
			ImageIcon icon=null;
			try {
				int serial=Integer.parseInt(model.getValueAt(rowIndex, 0).toString()) ;
				Connection con=Connector.connect();
				String q="select * from student where serial=?";
				PreparedStatement ps=con.prepareStatement(q);
				ps.setInt(1,serial);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					Blob b=rs.getBlob(12);
					InputStream is=b.getBinaryStream();
					Image image=ImageIO.read(is);
					icon=new ImageIcon(image);
				}
				method.resizeImage(icon, 100,100, profile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
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
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.setBackground(SystemColor.activeCaption);
		submitButton.setBounds(109, 486, 89, 23);
		Background.add(submitButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setBackground(SystemColor.activeCaption);
		
		resetButton.setBounds(237, 486, 89, 23);
		Background.add(resetButton);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setForeground(Color.WHITE);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMobile.setBounds(10, 431, 78, 28);
		Background.add(lblMobile);
		
		
		
		System.out.print(departmentInput);
		
//		String dobInput=day.getValue().toString()+"/"+month.getValue().toString()+"/"+year.getValue().toString();
//		System.out.println(dobInput);
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser choose=new JFileChooser();
				choose.showOpenDialog(null);
				
				try {
					File f=choose.getSelectedFile();
					Filename=f.getAbsolutePath();
					ImageIcon icon=new ImageIcon(Filename);
					method.resizeImage(icon, 1000, 1270, profile);
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
				}else if(Validation.studentValidation(nameInput.getText(),fatInput.getText(),addressInput.getText(),pinInput.getText(),mobileInput.getText(),"nejarulislam45@gmail.com")==true){

				
				
				if(Filename !=null) {
					try {
						Connection con=Connector.connect();
						
						InputStream in=new FileInputStream(Filename);
						
						String sql="Update student set name=?,father=?,gender=?,address=?,pin=?,dob=?,image=? where serial=?";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, nameInput.getText());
						ps.setString(2, fatInput.getText());
						ps.setString(3, group.getSelection().getActionCommand());
						ps.setString(4,addressInput.getText() );
						ps.setString(5, pinInput.getText());
						ps.setString(6, datePicker.getJFormattedTextField().getText());
						ps.setBlob(7, in);
						int Row=table.getSelectedRow();
						ps.setInt(8,Integer.parseInt(model.getValueAt(Row, 0).toString()));
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Updated Successfully");
						con.close();
						model.setRowCount(0);
						Student.refreshTable();
						setVisible(false);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"error");
						e1.printStackTrace();
				}


				}else {
					try {
						Connection con=Connector.connect();
						
//						InputStream in=new FileInputStream(Filename);
						
						String sql="Update student set name=?,father=?,gender=?,address=?,pin=?,dob=? where serial=?";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, nameInput.getText());
						ps.setString(2, fatInput.getText());
						ps.setString(3, group.getSelection().getActionCommand());
						ps.setString(4,addressInput.getText() );
						ps.setString(5, pinInput.getText());
						ps.setString(6, datePicker.getJFormattedTextField().getText());
						int Row=table.getSelectedRow();
						ps.setInt(7,Integer.parseInt(model.getValueAt(Row, 0).toString()));
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Updated Successfully");
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
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameInput.setText("");
				fatInput.setText("");
				group.clearSelection();
				addressInput.setText("");
			}
		});
		
	}

}
