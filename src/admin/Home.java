package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import ConnectionPackage.Connector;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import Method.Method;

@SuppressWarnings("serial")
public class Home extends JPanel {
	private JLabel notificationIcon;
	private JLabel lblNotification;
	private JLabel notificationCount;
	public Home() {
		setBounds(0,0,1301,683);
		setLayout(null);
		Method method=new Method();
		JLabel upperBackground = new JLabel("");
		ImageIcon image=new ImageIcon(".\\asset\\uperBack.jpg");
		method.resizeImage(image,1300,382,upperBackground);
		
		JPanel notification = new JPanel();
		notification.setBorder(new LineBorder(Color.gray, 3));
		notification.setBackground(Color.WHITE);
		notification.setBounds(922, 273, 241, 282);
		add(notification);
		notification.setLayout(null);
		JLabel notificationIcon = new JLabel("");
		notificationIcon.setBounds(44, 21, 151, 150);
		notification.add(notificationIcon);
		ImageIcon nImage=new ImageIcon(".\\asset\\notification.png");
		method.resizeImage(nImage,150,150,notificationIcon);
		
		JLabel lblNotification = new JLabel("Unseen Notifaction");
		lblNotification.setForeground(Color.GRAY);
		lblNotification.setFont(new Font("Footlight MT Light", Font.BOLD, 20));
		lblNotification.setBounds(23, 182, 208, 32);
		notification.add(lblNotification);
		
		JLabel notificationCount = new JLabel("0");
		notificationCount.setForeground(Color.GRAY);
		notificationCount.setFont(new Font("Footlight MT Light", Font.BOLD, 30));
		notificationCount.setBounds(95, 222, 44, 32);
		notification.add(notificationCount);
		
		
		JPanel faculties = new JPanel();
		faculties.setBorder(new LineBorder(Color.gray, 3));
		faculties.setBackground(Color.WHITE);
		faculties.setBounds(630, 273, 241, 282);
		add(faculties);
		faculties.setLayout(null);
		
		JLabel facultyIcon = new JLabel("");
		facultyIcon.setBounds(44, 21, 151, 150);
		faculties.add(facultyIcon);
		ImageIcon fImage=new ImageIcon(".\\asset\\faculty.png");
		method.resizeImage(fImage,150,150,facultyIcon);
		
		JLabel lblFaculty = new JLabel("Total faculties");
		lblFaculty.setForeground(Color.GRAY);
		lblFaculty.setFont(new Font("Footlight MT Light", Font.BOLD, 25));
		lblFaculty.setBounds(23, 182, 208, 32);
		faculties.add(lblFaculty);
		JLabel facultyCount = new JLabel("32");
		facultyCount.setForeground(Color.GRAY);
		facultyCount.setFont(new Font("Footlight MT Light", Font.BOLD, 30));
		facultyCount.setBounds(95, 222, 44, 32);
		faculties.add(facultyCount);
		
		JPanel department = new JPanel();
		department.setBorder(new LineBorder(Color.gray, 3));
		department.setBackground(Color.WHITE);
		department.setBounds(335, 273, 241, 282);
		add(department);
		department.setLayout(null);
		
		JLabel departmentIcon = new JLabel("");
		departmentIcon.setBounds(44, 21, 150, 150);
		department.add(departmentIcon);
		ImageIcon dImage=new ImageIcon(".\\asset\\department.png");
		method.resizeImage(dImage,150,150,departmentIcon);
		
		JLabel lblDepartment = new JLabel("Total department");
		lblDepartment.setForeground(Color.GRAY);
		lblDepartment.setFont(new Font("Footlight MT Light", Font.BOLD, 25));
		lblDepartment.setBounds(23, 182, 208, 32);
		department.add(lblDepartment);
		
		JLabel departmentCount = new JLabel(Method.departmentCount());
		departmentCount.setForeground(Color.GRAY);
		departmentCount.setFont(new Font("Footlight MT Light", Font.BOLD, 30));
		departmentCount.setBounds(95, 222, 44, 32);
		department.add(departmentCount);
		JPanel student = new JPanel();
		student.setBackground(Color.WHITE);
		student.setBounds(35, 273, 241, 282);
		student.setBorder(new LineBorder(Color.GRAY,3));
		add(student);
		
		JLabel studentIcon = new JLabel();
		studentIcon.setBounds(44, 21, 150, 150);
		ImageIcon stIcon=new ImageIcon(".\\asset\\student.png");
		method.resizeImage(stIcon,150,150,studentIcon);
		student.setLayout(null);
		
		JLabel studentLabel = new JLabel("Total students");
		studentLabel.setForeground(Color.GRAY);
		studentLabel.setFont(new Font("Footlight MT Light", Font.BOLD, 25));
		studentLabel.setBounds(44, 182, 155, 32);
		student.add(studentLabel);
		method.resizeImage(stIcon,150,150,studentIcon);
		student.add(studentIcon);
		
		JLabel totalStudentIcon = new JLabel("17");
		totalStudentIcon.setForeground(Color.GRAY);
		totalStudentIcon.setFont(new Font("Footlight MT Light", Font.BOLD, 30));
		totalStudentIcon.setBounds(88, 225, 44, 32);
		student.add(totalStudentIcon);
		upperBackground.setBackground(new Color(60, 179, 113));
		upperBackground.setBounds(0, 0, 1301, 333);
		add(upperBackground);
		
		JLabel welcomeName = new JLabel("Welcome Nejarul Islam");
		welcomeName.setForeground(Color.WHITE);
		welcomeName.setFont(new Font("Consolas", Font.BOLD, 20));
		welcomeName.setBounds(882, 30, 262, 35);
		upperBackground.add(welcomeName);
	}
	
	
}
