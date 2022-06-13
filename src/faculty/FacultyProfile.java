package faculty;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ConnectionPackage.Connector;
import Method.Method;

public class FacultyProfile extends JPanel {
	private JLabel nameField;
	private JTextField dobField;
	private JTextField genderField;
	private JTextField addField;
	private JTextField mobileField;
	private JTextField emailField;
	private JTextField qualField;

	/**
	 * Create the panel.
	 */
	public FacultyProfile(int serial) {
		setBounds(0,0,1301,683);
		setLayout(null);
		Method method=new Method();
		
		JLabel background = new JLabel("");
		background.setForeground(new Color(0, 128, 128));
		background.setBounds(0, 0, 1301, 683);
		ImageIcon icon=new ImageIcon(".\\asset\\panelback.jpg");
		method.resizeImage(icon, 1400, 683, background);
		add(background);
		
		
		JLabel photo = new JLabel("");
		photo.setBounds(528, 40, 96, 100);
		photo.setBorder(new LineBorder(Color.gray,2));
		background.add(photo);
		
		nameField = new JLabel();
		nameField.setForeground(new Color(255,255,255));
		nameField.setFont(new Font("Nirmala UI", Font.PLAIN, 69));
		nameField.setBounds(377, 151, 492, 107);
		nameField.setText("Nejarul Islam");
		background.add(nameField);
		
		JLabel designationField = new JLabel("Teacher");
		designationField.setForeground(new Color(255, 228, 181));
		designationField.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 27));
		designationField.setBounds(495, 259, 199, 29);
		background.add(designationField);
		
		JLabel lblNewLabel = new JLabel("Date of Birth");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 323, 130, 34);
		background.add(lblNewLabel);
		
		dobField = new JTextField();
		dobField.setEditable(false);
		dobField.setBounds(190, 323, 365, 34);
		background.add(dobField);
		dobField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblGender.setBounds(632, 328, 86, 34);
		background.add(lblGender);
		
		genderField = new JTextField();
		genderField.setEditable(false);
		genderField.setColumns(10);
		genderField.setBounds(767, 328, 384, 34);
		background.add(genderField);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblAddress.setBounds(20, 388, 130, 34);
		background.add(lblAddress);
		
		addField = new JTextField();
		addField.setEditable(false);
		addField.setColumns(10);
		addField.setBounds(190, 400, 365, 34);
		background.add(addField);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblMobile.setBounds(632, 388, 86, 34);
		background.add(lblMobile);
		
		mobileField = new JTextField();
		mobileField.setEditable(false);
		mobileField.setColumns(10);
		mobileField.setBounds(767, 388, 384, 34);
		background.add(mobileField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblEmail.setBounds(20, 461, 130, 34);
		background.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setEditable(false);
		emailField.setColumns(10);
		emailField.setBounds(190, 461, 365, 34);
		background.add(emailField);
		
		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblQualification.setBounds(629, 461, 130, 34);
		background.add(lblQualification);
		
		qualField = new JTextField();
		qualField.setEditable(false);
		qualField.setColumns(10);
		qualField.setBounds(767, 461, 384, 34);
		background.add(qualField);
		
		try {
			Connection con=Connector.connect();
			String sql="select image,name,designation,dob,gender,address,mobile,email,qualification from faculty where sl=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(1);
				InputStream is=b.getBinaryStream();
				Image img=ImageIO.read(is);
				ImageIcon icon1=new ImageIcon(img);
				method.resizeImage(icon1, 96, 100, photo);
				nameField.setText(rs.getString(2));
				designationField.setText(rs.getString(3));
				dobField.setText(rs.getString(4));
				genderField.setText(rs.getString(5));
				addField.setText(rs.getString(6));
				mobileField.setText(rs.getString(7));
				emailField.setText(rs.getString(8));
				qualField.setText(rs.getString(9));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
