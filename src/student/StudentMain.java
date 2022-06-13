package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import Login.LoginPage;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;

public class StudentMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMain frame = new StudentMain(36,0);
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
	public StudentMain(Integer serial,int flag) {
		if(flag==2) {
			Method.Method.lastLoginInsert(serial, "student");
		}
		
		
		setTitle("Student");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\asset\\logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);///code for auto maximized
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(".\\asset\\back.jpg"));
		setBounds(0, 0, 1380, 733);
		background.setBounds(0, 0, 1480, 833);
		contentPane.add(background);
		//code for adding menu class into frame 
		MenuBar menu=new MenuBar(serial);
		
		menu.setBackground(new Color(255,255,255,100));
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		background.add(menu);
		menu.setBounds(0,0,148,683);
		menu.setLayout(null);
		Home home=new Home(serial);
		invisible(home);
		home.setBounds(148,0,1300,683);
		home.setBackground(new Color(0,0,0,80));
		background.add(home);///this line is for adding home into background 
		home.setLayout(null);
		
		Routine routine=new Routine(serial);
		routine.setBounds(148,0,1300,683);
//		routine.setBorder(new LineBorder(Color.black,2));
		background.add(routine);
		invisible(routine);
		
		Fees fees=new Fees(serial);
		fees.setBounds(148,0,1300,683);
		background.add(fees);
		invisible(fees);
		
		Reciept rec=new Reciept(serial);
		rec.setBounds(148,0,1300,683);
		background.add(rec);
		invisible(rec);
		
		Marksheet ms=new Marksheet(serial);
		ms.setBounds(148,0,1300,683);
		background.add(ms);
		invisible(ms);
		
		StudentNotice notice=new StudentNotice(serial);
		notice.setBounds(148,0,1300,683);
		background.add(notice);
		invisible(notice);
		
		StudentProfile profile=new StudentProfile(serial);
		profile.setBounds(148,0,1300,683);
		background.add(profile);
		invisible(profile);
		
		MessageUs msg=new MessageUs(serial,this);
		msg.setBounds(148,0,1300,683);
		background.add(msg);
		invisible(msg);
		
		
		
		JButton homeButton=menu.homeButton();
		JButton routineButton=menu.routineButton();
		JButton feeButton=menu.feeButton();
		JButton marksheetButton=menu.marksheetButton();
		JButton recieptButton = menu.recieptButton();
		JButton noticeButton = menu.noticeButton();
		JButton profileButton = menu.profileButton();
		JButton contactButton=menu.contactButton();
		
		
		menu.add(homeButton);
		menu.add(routineButton);
		menu.add(feeButton);
		menu.add(marksheetButton);
		menu.add(recieptButton);
		menu.add(noticeButton);
		menu.add(profileButton);
		menu.add(contactButton);
		
		
		if(flag==0||flag==2) {
			visible(home);
			homeButton.setBackground(Color.cyan);
		}else{
			visible(msg);
			contactButton.setBackground(Color.cyan);
		}
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			visible(home);
			invisible(routine);
			invisible(fees);
			invisible(rec);
			invisible(ms);
			homeButton.setBackground(Color.cyan);
			routineButton.setBackground(new Color(64, 224, 208));
			feeButton.setBackground(new Color(64, 224, 208));
			recieptButton.setBackground(new Color(64, 224, 208));
			marksheetButton.setBackground(new Color(64, 224, 208));
			invisible(notice);
			noticeButton.setBackground(new Color(64, 224, 208));
			invisible(profile);
			profileButton.setBackground(new Color(64, 224, 208));
			contactButton.setBackground(new Color(64, 224, 208));
			invisible(msg);
		}
	});
		routineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invisible(home);
				visible(routine);
				invisible(fees);
				invisible(rec);
				invisible(ms);
			routineButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			feeButton.setBackground(new Color(64, 224, 208));
			recieptButton.setBackground(new Color(64, 224, 208));
			marksheetButton.setBackground(new Color(64, 224, 208));
			invisible(notice);
			noticeButton.setBackground(new Color(64, 224, 208));
			invisible(profile);
			profileButton.setBackground(new Color(64, 224, 208));
			contactButton.setBackground(new Color(64, 224, 208));
			invisible(msg);
		}
	});
		feeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invisible(home);
				invisible(routine);
				visible(fees);
				invisible(rec);
				invisible(ms);
			feeButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			recieptButton.setBackground(new Color(64, 224, 208));
			marksheetButton.setBackground(new Color(64, 224, 208));
			invisible(notice);
			noticeButton.setBackground(new Color(64, 224, 208));
			invisible(profile);
			profileButton.setBackground(new Color(64, 224, 208));
			contactButton.setBackground(new Color(64, 224, 208));
			invisible(msg);
		}
	});
		recieptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invisible(home);
				invisible(routine);
				invisible(fees);
				visible(rec);
				invisible(ms);
			recieptButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			feeButton.setBackground(new Color(64, 224, 208));
			marksheetButton.setBackground(new Color(64, 224, 208));
			invisible(notice);
			noticeButton.setBackground(new Color(64, 224, 208));
			invisible(profile);
			profileButton.setBackground(new Color(64, 224, 208));
			contactButton.setBackground(new Color(64, 224, 208));
			invisible(msg);
		}
	});
		marksheetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invisible(home);
				invisible(routine);
				invisible(fees);
				invisible(rec);
				visible(ms);
			marksheetButton.setBackground(Color.cyan);
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			feeButton.setBackground(new Color(64, 224, 208));
			recieptButton.setBackground(new Color(64, 224, 208));
			invisible(notice);
			noticeButton.setBackground(new Color(64, 224, 208));
			invisible(profile);
			profileButton.setBackground(new Color(64, 224, 208));
			contactButton.setBackground(new Color(64, 224, 208));
			invisible(msg);
		}
	});
		
		noticeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invisible(home);
				invisible(routine);
				invisible(fees);
				invisible(rec);
				invisible(ms);
				visible(notice);
			noticeButton.setBackground(Color.cyan);
			marksheetButton.setBackground(new Color(64, 224, 208));
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			feeButton.setBackground(new Color(64, 224, 208));
			recieptButton.setBackground(new Color(64, 224, 208));
			invisible(profile);
			profileButton.setBackground(new Color(64, 224, 208));
			contactButton.setBackground(new Color(64, 224, 208));
			invisible(msg);
		}
	});
		
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invisible(home);
				invisible(routine);
				invisible(fees);
				invisible(rec);
				invisible(ms);
				invisible(notice);
				visible(profile);
			profileButton.setBackground(Color.cyan);
			marksheetButton.setBackground(new Color(64, 224, 208));
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			feeButton.setBackground(new Color(64, 224, 208));
			recieptButton.setBackground(new Color(64, 224, 208));
			noticeButton.setBackground(new Color(64, 224, 208));
			contactButton.setBackground(new Color(64, 224, 208));
			invisible(msg);
		}
	});
		
		contactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invisible(home);
				invisible(routine);
				invisible(fees);
				invisible(rec);
				invisible(ms);
				invisible(notice);
				invisible(profile);
				visible(msg);
			contactButton.setBackground(Color.cyan);
			marksheetButton.setBackground(new Color(64, 224, 208));
			homeButton.setBackground(new Color(64, 224, 208));
			routineButton.setBackground(new Color(64, 224, 208));
			feeButton.setBackground(new Color(64, 224, 208));
			recieptButton.setBackground(new Color(64, 224, 208));
			noticeButton.setBackground(new Color(64, 224, 208));
			profileButton.setBackground(new Color(64, 224, 208));
		}
	});
		
		
		
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int j=JOptionPane.showConfirmDialog(null, "Are You Sure?","Log out",JOptionPane.YES_NO_OPTION);
				if(j==0) {
					setVisible(false);
					LoginPage lp=new LoginPage("student");
					lp.setVisible(true);
				}
//				System.out.println(j);
			}
		});
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		logoutButton.setFocusable(false);
		logoutButton.setBackground(new Color(64, 224, 208));
		logoutButton.setBounds(10, 454, 125, 27);
		menu.add(logoutButton);
	
	}
	public void visible(JPanel panel) {
		panel.setVisible(true);
	}
	public void invisible(JPanel panel) {
		panel.setVisible(false);
	}

}
