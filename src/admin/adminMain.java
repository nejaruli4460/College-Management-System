package admin;

import java.awt.BorderLayout;
import java.awt.Color;

import Method.Method;
import faculty.Home;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class adminMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMain frame = new adminMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminMain() {
		Method method=new Method();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		JLabel Background = new JLabel();
		Background.setBounds(0, 0, 1480, 833);
		ImageIcon back=new ImageIcon(".\\asset\\back.jpg");
		method.resizeImage(back, 1480, 833, Background);
		contentPane.add(Background);
		contentPane.setVisible(true);
		setBounds(0, 0, 1480, 833);
		
		MenuBar menu=new MenuBar("Administrator");
		
		menu.setBackground(new Color(255,255,255,100));
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		menu.setBounds(0,0,148,683);
		menu.setLayout(null);
		Background.add(menu);
		
		Home home=new Home();
		home.setVisible(false);
		home.setBounds(148,0,1300,683);
		home.setBackground(new Color(0,0,0,80));
		Background.add(home);
		
		Department department=new Department();
		department.setVisible(false);
		department.setBounds(148,0,1300,683);
		department.setBackground(new Color(0,0,0,80));
		Background.add(department);
		
		Student student=new Student();
		student.setVisible(false);
		student.setBounds(148,0,1300,683);
		student.setBackground(new Color(0,0,0,80));
		Background.add(student);
		
		Faculty faculty=new Faculty();
		faculty.setVisible(true);
		faculty.setBounds(148,0,1300,683);
		faculty.setBackground(new Color(0,0,0,80));
		Background.add(faculty);
		
		
		JButton homeButton=menu.homeButton();
		JButton studentButton=menu.studentButton();
		JButton departmentButton=menu.departmentButton();
		JButton facultyButton=menu.facultyButton();
		JButton clerkButton=menu.clerkButton();
		JButton marksButton=menu.marksButton();
		JButton attendanceButton=menu.attendanceButton();
		JButton adminButton=menu.adminButton();
		JButton adminProfileButton=menu.adminProfileButton();
		JButton noticeButton=menu.noticeButton();
		
		
		menu.add(homeButton);
		menu.add(studentButton);
		menu.add(departmentButton);
		menu.add(facultyButton);
		menu.add(marksButton);
		menu.add(attendanceButton);
		menu.add(adminButton);
		menu.add(adminProfileButton);
		menu.add(clerkButton);
		menu.add(noticeButton);
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				department.setVisible(false);
				home.setVisible(true);
				student.setVisible(false);
				homeButton.setBackground(Color.cyan);
				departmentButton.setBackground(new Color(64, 224, 208));
				
			}
			
		});
		departmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				department.setVisible(true);
				home.setVisible(false);
				student.setVisible(false);
				departmentButton.setBackground(Color.cyan);
				homeButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				
			}
			
		});
		
		studentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(true);
				
				studentButton.setBackground(Color.cyan);
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				
			}
			
		});
		
	}

}
