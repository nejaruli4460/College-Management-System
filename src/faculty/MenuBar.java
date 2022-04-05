package faculty;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Login.LoginPage;

public class MenuBar extends JPanel {
	public MenuBar() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(0, 204, 153,0));
		setLayout(null);
		setBounds(0,0,148,683);
		
		
		setVisible(true);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon("C:\\Users\\Nejarul\\eclipse-workspace\\College Management System\\asset\\nejarul photo.jpg"));
		image.setBounds(27, 11, 78, 90);
		add(image);
		
		JLabel userName = new JLabel("Nejarul Islam");
		userName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		userName.setBounds(10, 107, 125, 27);
		add(userName);
		
		
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int j=JOptionPane.showConfirmDialog(null, "Are You Sure?","Log out",JOptionPane.YES_NO_OPTION);
				if(j==0) {
					FacultyMain sm=new FacultyMain();
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
		logoutButton.setBounds(10, 517, 125, 27);
		add(logoutButton);
		
		
		
		
		
		
		
		
	}
	public JButton homeButton () {
		JButton homeButton = new JButton("Home");
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		homeButton.setFocusable(false);
		homeButton.setBackground(new Color(64, 224, 208));
		homeButton.setBounds(10, 171, 125, 27);
		return homeButton;
	}
	public JButton routineButton() {
		JButton btnRoutine = new JButton("Routine");
		btnRoutine.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRoutine.setFocusable(false);
		btnRoutine.setBackground(new Color(64, 224, 208));
		btnRoutine.setBounds(10, 220, 125, 27);
		return(btnRoutine);
	}
	public JButton noticeButton() {
		JButton btnNotice = new JButton("Notice");
		btnNotice.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNotice.setFocusable(false);
		btnNotice.setBackground(new Color(64, 224, 208));
		btnNotice.setBounds(10, 267, 125, 27);
		return(btnNotice);
	}
	public JButton marksButton() {
		JButton btnEnterMarks = new JButton("Enter marks");
		btnEnterMarks.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEnterMarks.setFocusable(false);
		btnEnterMarks.setBackground(new Color(64, 224, 208));
		btnEnterMarks.setBounds(10, 317, 125, 27);
		return(btnEnterMarks);
	}
	public JButton attendanceButton() {
	JButton btnEnterAttendance = new JButton("Attendance");
	btnEnterAttendance.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnEnterAttendance.setFocusable(false);
	btnEnterAttendance.setBackground(new Color(64, 224, 208));
	btnEnterAttendance.setBounds(10, 367, 125, 27);
	return(btnEnterAttendance);
	}
	public JButton profileButton() {
		JButton btnProfile = new JButton("Profile");
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnProfile.setFocusable(false);
		btnProfile.setBackground(new Color(64, 224, 208));
		btnProfile.setBounds(10, 416, 125, 27);
		return(btnProfile);
	}
	public JButton contactButton() {
		JButton btnContactUs = new JButton("Contact US");
		btnContactUs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnContactUs.setFocusable(false);
		btnContactUs.setBackground(new Color(64, 224, 208));
		btnContactUs.setBounds(10, 466, 125, 27);
		return(btnContactUs);
	}
}


