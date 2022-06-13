package faculty;

import java.awt.BorderLayout;
import java.awt.Color;

import Method.Method;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Login.LoginPage;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyMain extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyMain frame = new FacultyMain(6,0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FacultyMain(int serial,int flag) {
		if(flag==2) {
			Method.lastLoginInsert(serial, "faculty");
		}
		
		setTitle("Faculty");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\asset\\logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 833);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 1480, 833);
		contentPane.add(Background);
		setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		ImageIcon background=new ImageIcon(".\\asset\\back.jpg");
		Method method=new Method();
		method.resizeImage(background, 1480, 833, Background);	
		MenuBar menu=new MenuBar(serial);
		menu.setBackground(new Color(255,255,255,100));
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		Background.add(menu);
		menu.setBounds(0,0,148,683);
		menu.setLayout(null);
		Home home=new Home(serial);
		home.setVisible(false);
		home.setBounds(148,0,1300,683);
		home.setBackground(new Color(0,0,0,80));
		Background.add(home);
		
		MarksDistribute md=new MarksDistribute(serial);
		md.setBounds(148,0,1300,683);
		md.setBackground(new Color(0,0,0,80));
		md.setVisible(false);
		Background.add(md);
		
		insertAttendance attendance=new insertAttendance(serial);
		attendance.setBounds(148,0,1300,683);
		attendance.setBackground(new Color(0,0,0,80));
		attendance.setVisible(false);
		Background.add(attendance);
		
		FacultyRoutine routine=new FacultyRoutine(serial);
		routine.setBounds(148,0,1300,683);
		routine.setBackground(new Color(0,0,0,80));
		routine.setVisible(false);
		Background.add(routine);
		
		FacultyNotice notice=new FacultyNotice();
		notice.setBounds(148,0,1300,683);
		notice.setBackground(new Color(0,0,0,80));
		notice.setVisible(false);
		Background.add(notice);
		
		FacultyProfile profile=new FacultyProfile(serial);
		profile.setBounds(148,0,1300,683);
		profile.setBackground(new Color(0,0,0,80));
		profile.setVisible(false);
		Background.add(profile);
		
		MessageUs msg=new MessageUs(serial,this);
		msg.setBounds(148,0,1300,683);
		msg.setBackground(new Color(0,0,0,80));
		msg.setVisible(false);
		Background.add(msg);
		
		JButton homeButton=menu.homeButton();
		JButton routineButton=menu.routineButton();
		JButton noticeButton=menu.noticeButton();
		JButton marksButton=menu.marksButton();
		JButton attendanceButton=menu.attendanceButton();
		JButton profileButton=menu.profileButton();
		JButton contactButton=menu.contactButton();
		
		homeButton.setBackground(Color.cyan);
		
		menu.add(homeButton);
		menu.add(routineButton);
		menu.add(noticeButton);
		menu.add(marksButton);
		menu.add(attendanceButton);
		menu.add(profileButton);
		menu.add(contactButton);
		
		if(flag==0 ||flag==2) {
			home.setVisible(true);
			homeButton.setBackground(Color.cyan);
		}else {
			msg.setVisible(true);
			contactButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
		}
//		msg.setVisible(true);
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int j=JOptionPane.showConfirmDialog(null, "Are You Sure?","Log out",JOptionPane.YES_NO_OPTION);
				if(j==0) {
					setVisible(false);
					LoginPage lp=new LoginPage("faculty");
					lp.setVisible(true);
				}
//				System.out.println(j);
			}
		});
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		logoutButton.setFocusable(false);
		logoutButton.setBackground(new Color(64, 224, 208));
		logoutButton.setBounds(10, 517, 125, 27);
		menu.add(logoutButton);
		
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			home.setVisible(true);
			routine.setVisible(false);
			homeButton.setBackground(Color.cyan);
			routineButton.setBackground(new Color(64, 224, 208));
			notice.setVisible(false);
			noticeButton.setBackground(new Color(64, 224, 208));
			md.setVisible(false);
			marksButton.setBackground(new Color(64, 224, 208));
			attendance.setVisible(false);
			attendanceButton.setBackground(new Color(64, 224, 208));
			profile.setVisible(false);
			profileButton.setBackground(new Color(64, 224, 208));
			msg.setVisible(false);
			contactButton.setBackground(new Color(64, 224, 208));
		}
	});
		routineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			routine.setVisible(true);
			home.setVisible(false);
			routineButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			notice.setVisible(false);
			noticeButton.setBackground(new Color(64, 224, 208));
			md.setVisible(false);
			marksButton.setBackground(new Color(64, 224, 208));
			attendance.setVisible(false);
			attendanceButton.setBackground(new Color(64, 224, 208));
			profile.setVisible(false);
			profileButton.setBackground(new Color(64, 224, 208));
			msg.setVisible(false);
			contactButton.setBackground(new Color(64, 224, 208));
		}
	});
		noticeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			routine.setVisible(false);
			home.setVisible(false);
			notice.setVisible(true);
			noticeButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			md.setVisible(false);
			marksButton.setBackground(new Color(64, 224, 208));
			attendance.setVisible(false);
			attendanceButton.setBackground(new Color(64, 224, 208));
			profile.setVisible(false);
			profileButton.setBackground(new Color(64, 224, 208));
			msg.setVisible(false);
			contactButton.setBackground(new Color(64, 224, 208));
		}
	});
		marksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			routine.setVisible(false);
			home.setVisible(false);
			notice.setVisible(false);
			md.setVisible(true);
			marksButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			noticeButton.setBackground(new Color(64, 224, 208));
			attendance.setVisible(false);
			attendanceButton.setBackground(new Color(64, 224, 208));
			profile.setVisible(false);
			profileButton.setBackground(new Color(64, 224, 208));
			msg.setVisible(false);
			contactButton.setBackground(new Color(64, 224, 208));
		}
	});
		attendanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			routine.setVisible(false);
			home.setVisible(false);
			notice.setVisible(false);
			md.setVisible(false);
			attendance.setVisible(true);
			attendanceButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			noticeButton.setBackground(new Color(64, 224, 208));
			marksButton.setBackground(new Color(64, 224, 208));
			profile.setVisible(false);
			profileButton.setBackground(new Color(64, 224, 208));
			msg.setVisible(false);
			contactButton.setBackground(new Color(64, 224, 208));
		}
	});
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			routine.setVisible(false);
			home.setVisible(false);
			notice.setVisible(false);
			md.setVisible(false);
			attendance.setVisible(false);
			profile.setVisible(true);
			profileButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			noticeButton.setBackground(new Color(64, 224, 208));
			marksButton.setBackground(new Color(64, 224, 208));
			attendanceButton.setBackground(new Color(64, 224, 208));
			msg.setVisible(false);
			contactButton.setBackground(new Color(64, 224, 208));
		}
	});
		contactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			routine.setVisible(false);
			home.setVisible(false);
			notice.setVisible(false);
			md.setVisible(false);
			attendance.setVisible(false);
			profile.setVisible(false);
			msg.setVisible(true);
			contactButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			noticeButton.setBackground(new Color(64, 224, 208));
			marksButton.setBackground(new Color(64, 224, 208));
			attendanceButton.setBackground(new Color(64, 224, 208));
			profileButton.setBackground(new Color(64, 224, 208));
		}
	});


		
	}
}
