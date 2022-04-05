package faculty;

import java.awt.BorderLayout;
import java.awt.Color;

import Method.Method;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
					FacultyMain frame = new FacultyMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FacultyMain() {
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
		MenuBar menu=new MenuBar();
		menu.setBackground(new Color(255,255,255,100));
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		Background.add(menu);
		menu.setBounds(0,0,148,683);
		menu.setLayout(null);
		Home home=new Home();
		home.setVisible(false);
		home.setBounds(148,0,1300,683);
		home.setBackground(new Color(0,0,0,80));
		Background.add(home);
		
		MarksDistribute md=new MarksDistribute();
		md.setBounds(148,0,1300,683);
		md.setBackground(new Color(0,0,0,80));
		Background.add(md);
		
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
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			home.setVisible(true);
			homeButton.setBackground(Color.cyan);
		}
	});
	}
}
