package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
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
					StudentMain frame = new StudentMain(null);
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
	public StudentMain(String str) {
		System.out.println(str);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Nejarul\\eclipse-workspace\\College Management System\\asset\\student.png"));
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
		MenuBar menu=new MenuBar(str);
		
		menu.setBackground(new Color(255,255,255,100));
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		background.add(menu);
		menu.setBounds(0,0,148,683);
		menu.setLayout(null);
		Home home=new Home(str);
		visible(home);
		home.setBounds(148,0,1300,683);
		home.setBackground(new Color(0,0,0,80));
		background.add(home);///this line is for adding home into background 
		
		Routine routine=new Routine();
		routine.setBounds(148,0,1300,683);
//		routine.setBorder(new LineBorder(Color.black,2));
		background.add(routine);
		invisible(routine);
		
		Fees fees=new Fees();
		fees.setBounds(148,0,1300,683);
		background.add(fees);
		invisible(fees);
		
		Reciept rec=new Reciept();
		rec.setBounds(148,0,1300,683);
		background.add(rec);
		invisible(rec);
		
		Marksheet ms=new Marksheet();
		ms.setBounds(148,0,1300,683);
		background.add(ms);
		invisible(ms);
		
		
		
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
		homeButton.setBackground(Color.cyan);
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
		}
	});
	}
	public void visible(JPanel panel) {
		panel.setVisible(true);
	}
	public void invisible(JPanel panel) {
		panel.setVisible(false);
	}

}
