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

import ConnectionPackage.Connector;

import java.awt.BorderLayout;
import java.awt.Color;
import Method.Method;
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

public class InsertStudent extends JDialog {

	/**
	 * Launch the application.
	 */
	static String  Filename=null;
	byte [] image=null;
	private JTextField nameInput;
	private JTextField fatInput;
	private JTextField pinInput;
	private JTextField mobileInput;
	private JTextField emailInput;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertStudent dialog = new InsertStudent(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public InsertStudent(DefaultTableModel model) {
		
		setBounds(250, 0, 550, 700);
		getContentPane().setLayout(null);
		
		JLabel profile = new JLabel("");
		profile.setBounds(364, 47, 148, 168);
		profile.setBorder(new LineBorder(Color.gray,2));
		getContentPane().add(profile);
		Method method=new Method();
		JButton chooseButton = new JButton("choose");
		chooseButton.setBounds(398, 227, 89, 23);
		getContentPane().add(chooseButton);
		
		JLabel nameLabel = new JLabel("Student Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setBounds(10, 64, 89, 28);
		getContentPane().add(nameLabel);
		
		nameInput = new JTextField();
		nameInput.setBounds(109, 68, 223, 23);
		getContentPane().add(nameInput);
		nameInput.setColumns(10);
		
		JLabel fatName = new JLabel("Father's Name");
		fatName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fatName.setBounds(10, 116, 89, 28);
		getContentPane().add(fatName);
		
		fatInput = new JTextField();
		fatInput.setColumns(10);
		fatInput.setBounds(109, 121, 223, 23);
		getContentPane().add(fatInput);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genderLabel.setBounds(10, 175, 60, 28);
		getContentPane().add(genderLabel);
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setBounds(109, 179, 53, 23);
		radioButton.setActionCommand("Male");
		getContentPane().add(radioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(188, 179, 72, 23);
		rdbtnFemale.setActionCommand("Female");
		getContentPane().add(rdbtnFemale);
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(272, 179, 60, 23);
		rdbtnOther.setActionCommand("Other");
		getContentPane().add(rdbtnOther);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnFemale);
		group.add(radioButton);
		group.add(rdbtnOther);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(10, 231, 78, 28);
		getContentPane().add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 215, 232, 84);
		getContentPane().add(scrollPane);
		
		JTextArea addressInput = new JTextArea();
		scrollPane.setViewportView(addressInput);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPincode.setBounds(10, 331, 78, 28);
		getContentPane().add(lblPincode);
		
		pinInput = new JTextField();
		pinInput.setColumns(10);
		pinInput.setBounds(109, 335, 223, 23);
		getContentPane().add(pinInput);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(10, 392, 78, 28);
		getContentPane().add(lblDateOfBirth);
		
		JLabel lblMobileNumber = new JLabel("Mobile");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMobileNumber.setBounds(10, 445, 78, 28);
		getContentPane().add(lblMobileNumber);
		
		mobileInput = new JTextField();
		mobileInput.setColumns(10);
		mobileInput.setBounds(109, 450, 223, 23);
		getContentPane().add(mobileInput);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailId.setBounds(10, 494, 78, 28);
		getContentPane().add(lblEmailId);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(109, 499, 223, 23);
		getContentPane().add(emailInput);
		
		JLabel lblAppliedFor = new JLabel("Applied For?");
		lblAppliedFor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAppliedFor.setBounds(10, 545, 78, 28);
		getContentPane().add(lblAppliedFor);
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
		getContentPane().add(comboBox);
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.setBounds(109, 607, 89, 23);
		getContentPane().add(submitButton);
		
		JButton resetButton = new JButton("RESET");
		
		resetButton.setBounds(243, 607, 89, 23);
		getContentPane().add(resetButton);
		
		JSpinner day = new JSpinner();
		day.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		day.setBounds(127, 397, 44, 23);
		getContentPane().add(day);
		
		JSpinner month = new JSpinner();
		month.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		month.setBounds(188, 397, 44, 23);
		getContentPane().add(month);
		
		JSpinner year = new JSpinner();
		year.setModel(new SpinnerNumberModel(new Long(1990), new Long(1990), new Long(2022), new Long(1)));
		year.setBounds(253, 397, 79, 23);
		getContentPane().add(year);
//		System.out.print(departmentInput);
		
		String dobInput=day.getValue().toString()+"/"+month.getValue().toString()+"/"+year.getValue().toString();
		System.out.println(dobInput);
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
				if(nameInput.getText().equals(null)||fatInput.getText().equals(null)||group.isSelected(null)||
				addressInput.getText().equals(null)||mobileInput.getText().equals(null)||
				emailInput.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "Please fill all the field..","error",JOptionPane.ERROR_MESSAGE);
//					System.out.println("hello");
				}else {
					try {
						Connection con=Connector.connect();
						InputStream in=new FileInputStream(Filename);
						
						String q="insert into student(name,father,gender,address,pin,dob,department,mobile,email,image) values(?,?,?,?,?,?,?,?,?,?)";
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
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Inserted Successfully");
						con.close();
						model.setRowCount(0);
						Student.refreshTable();
						setVisible(false);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"error");
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
