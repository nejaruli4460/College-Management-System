package admin;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ConnectionPackage.Connector;
import Method.Method;

import javax.swing.JLabel;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.io.InputStream;
import java.sql.*;

import javax.swing.SwingConstants;

public class Profile extends JPanel {
	private JLabel nameField;
	private JTextField mobileField;
	private JTextField emailField;
	private JTextField dobField;
	private JTextField addField;

	/**
	 * Create the panel.
	 */
	public Profile(int serial) {
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
		ImageIcon image=new ImageIcon("C:\\Users\\Nejarul\\Downloads\\photo.jpg");
		method.resizeImage(image, 100, 100, photo);
		photo.setBounds(528, 40, 96, 100);
		photo.setBorder(new LineBorder(Color.gray,2));
		background.add(photo);
		
		nameField = new JLabel();
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setForeground(new Color(255,255,255));
		nameField.setFont(new Font("Nirmala UI", Font.PLAIN, 69));
		nameField.setBounds(377, 151, 492, 97);
//		nameField.setText("Nejarul Islam");
		background.add(nameField);
		
		JLabel designationField = new JLabel();
		designationField.setHorizontalAlignment(SwingConstants.CENTER);
		designationField.setForeground(Color.WHITE);
		designationField.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 27));
		designationField.setBounds(495, 259, 199, 29);
		background.add(designationField);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 27));
		lblMobileNo.setBounds(109, 339, 139, 29);
		background.add(lblMobileNo);
		
		mobileField = new JTextField();
		mobileField.setForeground(new Color(100, 149, 237));
		mobileField.setFont(new Font("Tahoma", Font.BOLD, 20));
		mobileField.setEnabled(false);
//		mobileField.setText("8609850867");
		mobileField.setBounds(278, 339, 157, 29);
		background.add(mobileField);
		mobileField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 27));
		lblEmail.setBounds(491, 339, 139, 29);
		background.add(lblEmail);
		
		emailField = new JTextField();
//		emailField.setText("nejarulislam45@gmail.com");
		emailField.setForeground(new Color(100, 149, 237));
		emailField.setFont(new Font("Tahoma", Font.BOLD, 20));
		emailField.setEnabled(false);
		emailField.setColumns(10);
		emailField.setBounds(584, 339, 370, 29);
		background.add(emailField);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setForeground(new Color(255,255,255));
		lblDateOfBirth.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 27));
		lblDateOfBirth.setBounds(86, 416, 172, 29);
		background.add(lblDateOfBirth);
		
		dobField = new JTextField();
//		dobField.setText("21-04-2021");
		dobField.setForeground(new Color(100, 149, 237));
		dobField.setFont(new Font("Tahoma", Font.BOLD, 20));
		dobField.setEnabled(false);
		dobField.setColumns(10);
		dobField.setBounds(279, 416, 157, 29);
		background.add(dobField);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(255,255,255));
		lblAddress.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 27));
		lblAddress.setBounds(460, 416, 105, 29);
		background.add(lblAddress);
		
		addField = new JTextField();
//		addField.setText("Gudhia,Murshidabad");
		addField.setForeground(new Color(100, 149, 237));
		addField.setFont(new Font("Tahoma", Font.BOLD, 20));
		addField.setEnabled(false);
		addField.setColumns(10);
		addField.setBounds(583, 420, 370, 29);
		background.add(addField);
		
		try {
			Connection con=Connector.connect();
			String sql="select * from admin where sl=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(10);
				InputStream is=b.getBinaryStream();
				Image img=ImageIO.read(is);
			ImageIcon	icon1=new ImageIcon(img);
				method.resizeImage(icon1, 90, 100, photo);
				nameField.setText(rs.getString(3));
				emailField.setText(rs.getString(5));
				mobileField.setText(rs.getString(4));
				dobField.setText(rs.getString(6));
				designationField.setText("("+rs.getString(7)+")");
				addField.setText(rs.getString(8));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
