package admin;

import java.awt.BorderLayout;
import java.awt.Color;

import Method.Method;
import faculty.Home;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Login.LoginPage;
import java.awt.Toolkit;

public class adminMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Nejarul Islam
	 * nejarulislam45@gmail.com
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMain frame = new adminMain(7,0);
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
	public adminMain(int serial,int flag) {
		if(flag==2) {
			Method.lastLoginInsert(serial, "admin");
		}
		
		setTitle("Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\asset\\logo.jpg"));
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
		
		MenuBar menu=new MenuBar(serial);
		
		menu.setBackground(new Color(255,255,255,100));
//		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		menu.setBounds(0,0,148,683);
		menu.setLayout(null);
		Background.add(menu);
		
		AdminHome home=new AdminHome(serial);
		home.setVisible(false);
		home.setBounds(148,0,1300,683);
		home.setBackground(new Color(0,0,0,80));
		Background.add(home);
		
		Department department=new Department();
		department.setBounds(148,0,1300,683);
		department.setVisible(false);
		department.setBackground(new Color(0,0,0,80));
		Background.add(department);
		
		Student student=new Student();
		student.setVisible(false);
		student.setBounds(148,0,1300,683);
		student.setBackground(new Color(0,0,0,80));
		Background.add(student);
		
		Faculty faculty=new Faculty();
		faculty.setVisible(false);
		faculty.setBounds(148,0,1300,683);
		faculty.setBackground(new Color(0,0,0,80));
		Background.add(faculty);
		
		AttendanceReport areport=new AttendanceReport();
		areport.setVisible(false);
		areport.setBounds(148,0,1300,683);
		areport.setBackground(new Color(0,0,0,80));
		Background.add(areport);
		
		Admin admin=new Admin(menu,this,serial);
		admin.setVisible(false);
		admin.setBounds(148,0,1300,683);
		admin.setBackground(new Color(0,0,0,80));
		Background.add(admin);
		
		Profile profile=new Profile(serial);
		profile.setVisible(false);
		profile.setBounds(148,0,1300,683);
		Background.add(profile);
		
		AdminNotice notice=new AdminNotice();
		notice.setVisible(false);
		notice.setBounds(148,0,1300,683);
		Background.add(notice);
		
		MarksheetReport report=new MarksheetReport();
		report.setVisible(false);
		report.setBounds(148,0,1300,683);
		Background.add(report);
		
		Fees fees=new Fees();
		fees.setVisible(false);
		fees.setBounds(148,0,1300,683);
		Background.add(fees);
		
		MessageUs msg=new MessageUs(serial,this);
		msg.setVisible(false);
		msg.setBounds(148,0,1300,683);
		Background.add(msg);
		
		
		
		JButton homeButton=menu.homeButton();
		JButton studentButton=menu.studentButton();
		JButton departmentButton=menu.departmentButton();
		JButton facultyButton=menu.facultyButton();
		JButton marksButton=menu.marksButton();
		JButton attendanceButton=menu.attendanceButton();
		JButton adminButton=menu.adminButton();
		JButton adminProfileButton=menu.adminProfileButton();
		JButton noticeButton=menu.noticeButton();
		JButton feesButton=menu.feesButton();
		
		JButton queryButton = new JButton("All Queries");
		queryButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		queryButton.setFocusable(false);
		queryButton.setBackground(new Color(64, 224, 208));
		queryButton.setBounds(10, 527, 125, 27);
		menu.add(queryButton);
		
		menu.add(homeButton);
		menu.add(studentButton);
		menu.add(departmentButton);
		menu.add(facultyButton);
		menu.add(marksButton);
		menu.add(attendanceButton);
		menu.add(adminButton);
		menu.add(adminProfileButton);
		menu.add(noticeButton);
		menu.add(feesButton);
		
		if(flag==0||flag==2) {
			home.setVisible(true);
			homeButton.setBackground(Color.cyan);
			
		}else {
			msg.setVisible(true);
			queryButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
		}
		
		homeButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				department.setVisible(false);
				home.setVisible(true);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(false);
				homeButton.setBackground(Color.cyan);
				departmentButton.setBackground(new Color(64, 224, 208));
				facultyButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				admin.setVisible(false);
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				profile.setVisible(false);
				noticeButton.setBackground(new Color(64, 224, 208));
				notice.setVisible(false);
				marksButton.setBackground(new Color(64, 224, 208));
				report.setVisible(false);
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

				
			}
			
		});
		departmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				department.setVisible(true);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(false);
				departmentButton.setBackground(Color.cyan);
				homeButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				facultyButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				admin.setVisible(false);
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				profile.setVisible(false);
				noticeButton.setBackground(new Color(64, 224, 208));
				notice.setVisible(false);
				marksButton.setBackground(new Color(64, 224, 208));
				report.setVisible(false);
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

				
			}
			
		});
		
		studentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(true);
				faculty.setVisible(false);
				areport.setVisible(false);
				
				studentButton.setBackground(Color.cyan);
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				facultyButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				admin.setVisible(false);
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				profile.setVisible(false);
				noticeButton.setBackground(new Color(64, 224, 208));
				notice.setVisible(false);
				marksButton.setBackground(new Color(64, 224, 208));
				report.setVisible(false);
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

				
			}
			
		});
		facultyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(true);
				areport.setVisible(false);
				
				facultyButton.setBackground(Color.cyan);
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				admin.setVisible(false);
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				profile.setVisible(false);
				noticeButton.setBackground(new Color(64, 224, 208));
				notice.setVisible(false);
				marksButton.setBackground(new Color(64, 224, 208));
				report.setVisible(false);
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

				
			}
			
		});
		attendanceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(true);
				
				attendanceButton.setBackground(Color.cyan);
				facultyButton.setBackground(new Color(64, 224, 208));
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				admin.setVisible(false);
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				profile.setVisible(false);
				noticeButton.setBackground(new Color(64, 224, 208));
				notice.setVisible(false);
				marksButton.setBackground(new Color(64, 224, 208));
				report.setVisible(false);
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

			}
			
		});
		adminButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(false);
				admin.setVisible(true);
				
				adminButton.setBackground(Color.cyan);
				facultyButton.setBackground(new Color(64, 224, 208));
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				profile.setVisible(false);
				noticeButton.setBackground(new Color(64, 224, 208));
				notice.setVisible(false);
				marksButton.setBackground(new Color(64, 224, 208));
				report.setVisible(false);
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

				
			}
			
		});
		adminProfileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(false);
				admin.setVisible(false);
				profile.setVisible(true);
				
				adminProfileButton.setBackground(Color.cyan);
				facultyButton.setBackground(new Color(64, 224, 208));
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				adminButton.setBackground(new Color(64, 224, 208));
				noticeButton.setBackground(new Color(64, 224, 208));
				notice.setVisible(false);
				marksButton.setBackground(new Color(64, 224, 208));
				report.setVisible(false);
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

			}
			
		});
		noticeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(false);
				admin.setVisible(false);
				profile.setVisible(false);
				notice.setVisible(true);
				
				noticeButton.setBackground(Color.cyan);
				facultyButton.setBackground(new Color(64, 224, 208));
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				marksButton.setBackground(new Color(64, 224, 208));
				report.setVisible(false);
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

			}
			
		});

		marksButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(false);
				admin.setVisible(false);
				profile.setVisible(false);
				notice.setVisible(false);
				report.setVisible(true);
				
				marksButton.setBackground(Color.cyan);
				facultyButton.setBackground(new Color(64, 224, 208));
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				noticeButton.setBackground(new Color(64, 224, 208));
				fees.setVisible(false);
				feesButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));

			}
			
		});
		
		feesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(false);
				admin.setVisible(false);
				profile.setVisible(false);
				notice.setVisible(false);
				report.setVisible(false);
				fees.setVisible(true);
				
				feesButton.setBackground(Color.cyan);
				marksButton.setBackground(new Color(64, 224, 208));
				facultyButton.setBackground(new Color(64, 224, 208));
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				noticeButton.setBackground(new Color(64, 224, 208));
				msg.setVisible(false);
				queryButton.setBackground(new Color(64, 224, 208));
			}
			
		});
		
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				department.setVisible(false);
				home.setVisible(false);
				student.setVisible(false);
				faculty.setVisible(false);
				areport.setVisible(false);
				admin.setVisible(false);
				profile.setVisible(false);
				notice.setVisible(false);
				report.setVisible(false);
				fees.setVisible(false);
				msg.setVisible(true);
				queryButton.setBackground(Color.cyan);
				feesButton.setBackground(new Color(64, 224, 208));
				marksButton.setBackground(new Color(64, 224, 208));
				facultyButton.setBackground(new Color(64, 224, 208));
				homeButton.setBackground(new Color(64, 224, 208));
				departmentButton.setBackground(new Color(64, 224, 208));
				studentButton.setBackground(new Color(64, 224, 208));
				attendanceButton.setBackground(new Color(64, 224, 208));
				adminButton.setBackground(new Color(64, 224, 208));
				adminProfileButton.setBackground(new Color(64, 224, 208));
				noticeButton.setBackground(new Color(64, 224, 208));
			}
			
		});


		JButton logoutButton=logout(menu,this);
		
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		logoutButton.setFocusable(false);
		logoutButton.setBackground(new Color(64, 224, 208));
		logoutButton.setBounds(10, 565, 125, 27);
		
		
		
		
				
	}
	public static JButton logout(MenuBar menu,JFrame frame) {
		JButton logoutButton = new JButton("Log Out");
		menu.add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int j=JOptionPane.showConfirmDialog(null, "Are You Sure?","Log out",JOptionPane.YES_NO_OPTION);
				if(j==0) {
					LoginPage lp=new LoginPage("admin");
					lp.setVisible(true);
					frame.setVisible(false);
					
				}
			}
			});
		return logoutButton;
	}
	}
