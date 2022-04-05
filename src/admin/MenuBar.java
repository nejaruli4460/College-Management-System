package admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Login.LoginPage;

public class MenuBar extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuBar(String str) {
//		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(0, 204, 153,0));
		setLayout(null);
		
		
		setVisible(true);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon("C:\\Users\\Nejarul\\eclipse-workspace\\College Management System\\asset\\nejarul photo.jpg"));
		image.setBounds(27, 11, 78, 90);
		add(image);
		
		JLabel userName = new JLabel(str);
		userName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		userName.setBounds(10, 107, 125, 27);
		add(userName);
		
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int j=JOptionPane.showConfirmDialog(null, "Are You Sure?","Log out",JOptionPane.YES_NO_OPTION);
				if(j==0) {
					adminMain sm=new adminMain();
					sm.setVisible(false);
					LoginPage lp=new LoginPage();
					lp.setVisible(true);
				}
//				System.out.println(j);
			}
		});
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		logoutButton.setFocusable(false);
		logoutButton.setBackground(new Color(64, 224, 208));
		logoutButton.setBounds(10, 537, 125, 27);
		add(logoutButton);
		
		
				
		
		
		
	}
	public JButton homeButton() {
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHome.setFocusable(false);
		btnHome.setBackground(Color.cyan);
		btnHome.setBounds(10, 162, 125, 27);
		return(btnHome);
	}
	public JButton departmentButton() {
		JButton btnDepartment = new JButton("Department");
		btnDepartment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDepartment.setFocusable(false);
		btnDepartment.setBackground(new Color(64, 224, 208));
		btnDepartment.setBounds(10, 200, 125, 27);
		return(btnDepartment);
	}
	public JButton studentButton() {
		JButton btnStudent = new JButton("Student");
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnStudent.setFocusable(false);
		btnStudent.setBackground(new Color(64, 224, 208));
		btnStudent.setBounds(10, 238, 125, 27);
		return(btnStudent);
	}
	public JButton facultyButton() {
		JButton btnFaculty = new JButton("Faculty");
		btnFaculty.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFaculty.setFocusable(false);
		btnFaculty.setBackground(new Color(64, 224, 208));
		btnFaculty.setBounds(10, 276, 125, 27);
		return(btnFaculty);
	}
	public JButton clerkButton() {
		JButton btnClerk = new JButton("Clerk");
		btnClerk.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClerk.setFocusable(false);
		btnClerk.setBackground(new Color(64, 224, 208));
		btnClerk.setBounds(10, 314, 125, 27);
		return(btnClerk);
	}
	public JButton marksButton() {
		JButton btnMarksheetReport = new JButton("Marksheet Report");
		btnMarksheetReport.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMarksheetReport.setFocusable(false);
		btnMarksheetReport.setBackground(new Color(64, 224, 208));
		btnMarksheetReport.setBounds(10, 352, 125, 27);
		return(btnMarksheetReport);
	}
	public JButton attendanceButton() {
		JButton btnAttendanceReport = new JButton("Attendance Report");
		btnAttendanceReport.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAttendanceReport.setFocusable(false);
		btnAttendanceReport.setBackground(new Color(64, 224, 208));
		btnAttendanceReport.setBounds(10, 390, 125, 27);
		return(btnAttendanceReport);
	}
	public JButton adminButton() {
		JButton btnUsers = new JButton("Admin");
		btnUsers.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUsers.setFocusable(false);
		btnUsers.setBackground(new Color(64, 224, 208));
		btnUsers.setBounds(10, 428, 125, 27);
		return(btnUsers);
	}
	public JButton adminProfileButton() {
		JButton btnAdminProfile = new JButton("Admin Profile");
		btnAdminProfile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdminProfile.setFocusable(false);
		btnAdminProfile.setBackground(new Color(64, 224, 208));
		btnAdminProfile.setBounds(10, 461, 125, 27);
		return(btnAdminProfile);
	}
	public JButton noticeButton() {
		JButton btnNotice = new JButton("Notice");
		btnNotice.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNotice.setFocusable(false);
		btnNotice.setBackground(new Color(64, 224, 208));
		btnNotice.setBounds(10, 499, 125, 27);
		return(btnNotice);
	}
}
