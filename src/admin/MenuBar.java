package admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import ConnectionPackage.Connector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Login.LoginPage;
import Method.Method;

public class MenuBar extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuBar(int serial) {
//		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(0, 204, 153,0));
		setLayout(null);
		Method method=new Method();
		
		setVisible(true);
		
		
		JLabel image = new JLabel("");
//		image.setIcon(new ImageIcon("C:\\Users\\Nejarul\\eclipse-workspace\\College Management System\\asset\\nejarul photo.jpg"));
		image.setBounds(23, 11, 90, 100);
		add(image);
		ImageIcon icon = null;
		try {
			Connection con=Connector.connect();
			String sql="select image from admin where sl=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(1);
				InputStream is=b.getBinaryStream();
				Image img=ImageIO.read(is);
				icon=new ImageIcon(img);
				
			}
			con.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		method.resizeImage(icon, 90, 100, image);
		
		JLabel userName = new JLabel("ADMINISTRATOR");
		userName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		userName.setBounds(10, 107, 125, 27);
		add(userName);		
				
		
		
		
	}
	public JButton homeButton() {
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHome.setFocusable(false);
		btnHome.setBackground(new Color(64, 224, 208));
		btnHome.setBounds(10, 162, 125, 27);
		return(btnHome);
	}
	public JButton departmentButton() {
		JButton btnDepartment = new JButton("Manage Department");
		btnDepartment.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDepartment.setFocusable(false);
		btnDepartment.setBackground(new Color(64, 224, 208));
		btnDepartment.setBounds(10, 200, 125, 27);
		return(btnDepartment);
	}
	public JButton studentButton() {
		JButton btnStudent = new JButton("Manage Student");
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnStudent.setFocusable(false);
		btnStudent.setBackground(new Color(64, 224, 208));
		btnStudent.setBounds(10, 238, 125, 27);
		return(btnStudent);
	}
	public JButton facultyButton() {
		JButton btnFaculty = new JButton("Manage Faculty");
		btnFaculty.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFaculty.setFocusable(false);
		btnFaculty.setBackground(new Color(64, 224, 208));
		btnFaculty.setBounds(10, 276, 125, 27);
		return(btnFaculty);
	}
	public JButton marksButton() {
		JButton btnMarksheetReport = new JButton("Marksheet Report");
		btnMarksheetReport.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMarksheetReport.setFocusable(false);
		btnMarksheetReport.setBackground(new Color(64, 224, 208));
		btnMarksheetReport.setBounds(10, 314, 125, 27);
		return(btnMarksheetReport);
	}
	public JButton attendanceButton() {
		JButton btnAttendanceReport = new JButton("Attendance Report");
		btnAttendanceReport.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAttendanceReport.setFocusable(false);
		btnAttendanceReport.setBackground(new Color(64, 224, 208));
		btnAttendanceReport.setBounds(10, 352, 125, 27);
		return(btnAttendanceReport);
	}
	public JButton adminButton() {
		JButton btnUsers = new JButton("Manage Admin");
		btnUsers.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUsers.setFocusable(false);
		btnUsers.setBackground(new Color(64, 224, 208));
		btnUsers.setBounds(10, 390, 125, 27);
		return(btnUsers);
	}
	public JButton adminProfileButton() {
		JButton btnAdminProfile = new JButton("Admin Profile");
		btnAdminProfile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdminProfile.setFocusable(false);
		btnAdminProfile.setBackground(new Color(64, 224, 208));
		btnAdminProfile.setBounds(10, 494, 125, 27);
		
		return(btnAdminProfile);
	}
	public JButton noticeButton() {
		JButton btnNotice = new JButton("Manage Notice");
		btnNotice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNotice.setFocusable(false);
		btnNotice.setBackground(new Color(64, 224, 208));
		btnNotice.setBounds(10, 428, 125, 27);
		
		return(btnNotice);
	}
	public JButton feesButton() {
		JButton btnNotice = new JButton("Manage Fees");
		btnNotice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNotice.setFocusable(false);
		btnNotice.setBackground(new Color(64, 224, 208));
		btnNotice.setBounds(10, 461, 125, 27);
		
		return(btnNotice);
	}
	
}
