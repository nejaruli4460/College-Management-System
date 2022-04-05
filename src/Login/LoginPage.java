package Login;
import java.awt.EventQueue;
import ConnectionPackage.*;
import Method.Progress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import student.StudentMain;
import admin.adminMain;
import faculty.FacultyMain;
import javax.swing.JProgressBar;
@SuppressWarnings("serial")
public class LoginPage extends JFrame {
//	Connection con;
	private JPanel contentPane;
	JPanel studentPanel;
	JPanel facultyPanel;
	JPanel loginMainPanel;
	JPanel adminPanel;

	/**
	 * Coded BY---Nejarul Islam
	 *B.sc Computer Science(Honours)
	 *Surendranath College
	 *Batch 2022
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		//Background Code for Jframe started-------
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\asset\\logo.jpg"));
		setForeground(SystemColor.activeCaption);
		setTitle("Login");
		setBackground(SystemColor.windowBorder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1380, 833);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);///code for auto maximized
		//Logo and surendranath college naming panel started from here------------------------------
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(new Color(255, 255, 255));
		logoPanel.setBorder(new LineBorder(SystemColor.activeCaption));
		logoPanel.setBounds(10, 22, 1332, 123);
		contentPane.add(logoPanel);
		logoPanel.setLayout(null);
		//logo panel started here------------------------------------------
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(".\\asset\\logo.jpg"));
		logoLabel.setBounds(29, 11, 136, 101);
		logoPanel.add(logoLabel);
		//College name panel---------------------------------------------------
		JLabel collegeNaming = new JLabel("SURENDRANATH COLLEGE");
		collegeNaming.setForeground(Color.GRAY);
		collegeNaming.setFont(new Font("Eras Light ITC", Font.BOLD, 65));
		collegeNaming.setBounds(228, 11, 1005, 101);
		logoPanel.add(collegeNaming);
		//Code for Background set----------
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(".\\asset\\background.jpg"));
		Background.setBounds(0, 0, 1400, 830);
		contentPane.add(Background);///upto here background set code
		//Login Panel started here __________________________________________________________
		loginMainPanel = new JPanel();
		Background.add(loginMainPanel);
		loginMainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		loginMainPanel.setBounds(450, 251, 450, 432);
		loginMainPanel.setLayout(null);
		loginMainPanel.setBackground(new Color(255,255,255,125));
		//Student panel code started from here----------------------------------------
		JPanel studentPanel=Student();
		JPanel facultyPanel=faculty();
		JPanel adminPanel=admin();
		
		//student button code------------
				JButton studentButton = new JButton("   STUDENT");
				studentButton.setBackground(Color.cyan);
				studentButton.setForeground(Color.BLACK);
				studentButton.setFont(new Font("Nirmala UI", Font.BOLD, 15));
				studentButton.setBounds(32, 11, 132, 31);
				studentButton.setVerticalAlignment(SwingConstants.TOP);
				studentButton.setHorizontalAlignment(SwingConstants.LEFT);
				loginMainPanel.add(studentButton);
				studentButton.setFocusable(false);
				//-------------F-A-C-U-L-T-Y--------------------------------------------------------------
				JButton facultyButton = new JButton("   FACULTY");
				facultyButton.setBackground(new Color(135, 206, 235));
				
				facultyButton.setForeground(Color.BLACK);
				facultyButton.setFont(new Font("Nirmala UI", Font.BOLD, 15));
				facultyButton.setBounds(163, 11, 132, 31);
				facultyButton.setVerticalAlignment(SwingConstants.TOP);
				facultyButton.setHorizontalAlignment(SwingConstants.LEFT);
				loginMainPanel.add(facultyButton);
				facultyButton.setFocusable(false);
				//--------------------A-D-M-I-N---------------------------
				JButton adminButton = new JButton("   ADMIN");
				adminButton.setBackground(new Color(135, 206, 235));
				adminButton.setForeground(Color.BLACK);
				adminButton.setFont(new Font("Nirmala UI", Font.BOLD, 15));
				adminButton.setBounds(295, 11, 127, 31);
				adminButton.setVerticalAlignment(SwingConstants.TOP);
				adminButton.setHorizontalAlignment(SwingConstants.LEFT);
				adminButton.setFocusable(false);
				facultyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						facultyPanel.setVisible(true);
						studentPanel.setVisible(false);
						adminPanel.setVisible(false);
						facultyButton.setForeground(Color.BLACK);
						facultyButton.setBackground(Color.cyan);
						studentButton.setBackground(new Color(135, 206, 235));
						studentButton.setForeground(Color.black);
						adminButton.setBackground(new Color(135, 206, 235));
						adminButton.setForeground(Color.black);
					}
				});
				adminButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						LoginMainPanel.add(studentPanel);
						facultyPanel.setVisible(false);
						studentPanel.setVisible(false);
						adminPanel.setVisible(true);
						adminButton.setForeground(Color.BLACK);
						adminButton.setBackground(Color.cyan);
						facultyButton.setBackground(new Color(135, 206, 235));
						facultyButton.setForeground(Color.black);
						studentButton.setBackground(new Color(135, 206, 235));
						studentButton.setForeground(Color.black);
					}
				});
				loginMainPanel.add(adminButton);
				studentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				LoginMainPanel.add(studentPanel);
//				studentPanel.setLocation(30, 53);
				facultyPanel.setVisible(false);
				studentPanel.setVisible(true);
				adminPanel.setVisible(false);
				studentButton.setForeground(Color.BLACK);
				studentButton.setBackground(Color.cyan);
				facultyButton.setBackground(new Color(135, 206, 235));
				facultyButton.setForeground(Color.black);
				adminButton.setBackground(new Color(135, 206, 235));
				adminButton.setForeground(Color.black);
				
			}
		});
				
		
	}
	public JPanel Student() {
		studentPanel = new JPanel();
		studentPanel.setBackground(Color.WHITE);
		loginMainPanel.add(studentPanel);
		studentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		studentPanel.setBounds(30, 40, 389, 362);
//		studentPanel.setLocation(30, 53);
		studentPanel.setLayout(null);
//		studentPanel.setVisible(false);
		
		JButton hideShowToggler = new JButton("VIEW");
		hideShowToggler.setForeground(Color.RED);
		hideShowToggler.setFont(new Font("Arial", Font.PLAIN, 9));
		hideShowToggler.setFocusable(false);
		hideShowToggler.setBackground(Color.WHITE);
		hideShowToggler.setBounds(314, 235, 61, 20);
		studentPanel.add(hideShowToggler);
		JLabel studentLoginLogo = new JLabel("");
		studentLoginLogo.setIcon(new ImageIcon(".\\asset\\studentIcon.png"));
		studentLoginLogo.setBounds(149, 31, 98, 89);
		studentPanel.add(studentLoginLogo);
		
		JLabel usernameLabel = new JLabel("  USERNAME");
		usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		usernameLabel.setBounds(29, 196, 98, 33);
		studentPanel.add(usernameLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(137, 204, 167, 20);
		studentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("  PASSWORD");
		passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		passwordLabel.setBounds(29, 227, 98, 33);
		studentPanel.add(passwordLabel);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(137, 235, 167, 20);
		passwordField.setEchoChar('*');
		studentPanel.add(passwordField);
		
		JButton studentSubmitBTN = new JButton("LOGIN");
		studentSubmitBTN.setBackground(Color.red);
		studentSubmitBTN.setForeground(Color.WHITE);
		studentSubmitBTN.setBounds(149, 283, 98, 23);
		studentSubmitBTN.setFocusable(false);
		studentPanel.add(studentSubmitBTN);
		
		JLabel studentLoginLabel = new JLabel("    STUDENT LOGIN");
		studentLoginLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		studentLoginLabel.setBounds(125, 153, 167, 33);
		studentPanel.add(studentLoginLabel);
		hideShowToggler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hideShowToggler.getText().equals("VIEW")) {
					passwordField.setEchoChar((char)0);
					hideShowToggler.setText("HIDE");
				}else {
					passwordField.setEchoChar('*');
					hideShowToggler.setText("VIEW");
				}
			
			}
		});
		studentSubmitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginAuthenication(passwordField,textField,"student");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return studentPanel;
	}
	public JPanel faculty() {

		JPanel facultyPanel = new JPanel();
		facultyPanel.setLayout(null);
		facultyPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		facultyPanel.setBackground(Color.WHITE);
		facultyPanel.setBounds(30, 40, 389, 362);
		facultyPanel.setVisible(false);
		loginMainPanel.add(facultyPanel);
		JButton hideShowToggler = new JButton("VIEW");
		hideShowToggler.setForeground(Color.RED);
		hideShowToggler.setFont(new Font("Arial", Font.PLAIN, 9));
		hideShowToggler.setFocusable(false);
		hideShowToggler.setBackground(Color.WHITE);
		hideShowToggler.setBounds(314, 235, 61, 20);
		facultyPanel.add(hideShowToggler);
	
		
		JLabel facultyLoginLogo = new JLabel("");
		facultyLoginLogo.setIcon(new ImageIcon(".\\asset\\class.png"));
		facultyLoginLogo.setBounds(149, 11, 98, 109);
		facultyPanel.add(facultyLoginLogo);
		
		JLabel usernamefLabel = new JLabel("  USERNAME");
		usernamefLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		usernamefLabel.setBounds(29, 196, 98, 33);
		facultyPanel.add(usernamefLabel);
		
		JTextField textFieldFaculty = new JTextField();
		textFieldFaculty.setColumns(10);
		textFieldFaculty.setBounds(137, 204, 167, 20);
		facultyPanel.add(textFieldFaculty);
		
		JLabel passwordfLabel = new JLabel("  PASSWORD");
		passwordfLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		passwordfLabel.setBounds(29, 227, 98, 33);
		facultyPanel.add(passwordfLabel);
		
		JPasswordField passwordFieldFaculty = new JPasswordField();
		passwordFieldFaculty.setEchoChar('*');
		passwordFieldFaculty.setBounds(137, 235, 167, 20);
		facultyPanel.add(passwordFieldFaculty);
		
		JButton facultySubmitBTN = new JButton("LOGIN");
		facultySubmitBTN.setForeground(Color.WHITE);
		facultySubmitBTN.setFocusable(false);
		facultySubmitBTN.setBackground(Color.RED);
		facultySubmitBTN.setBounds(149, 283, 98, 23);
		facultyPanel.add(facultySubmitBTN);
		
		JLabel lblFacultyLogin = new JLabel("    FACULTY LOGIN");
		lblFacultyLogin.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblFacultyLogin.setBounds(125, 153, 167, 33);
		facultyPanel.add(lblFacultyLogin);
		hideShowToggler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hideShowToggler.getText().equals("VIEW")) {
					passwordFieldFaculty.setEchoChar((char)0);
					hideShowToggler.setText("HIDE");
				}else {
					passwordFieldFaculty.setEchoChar('*');
					hideShowToggler.setText("VIEW");
				}
			
			}
		});
		facultySubmitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginAuthenication(passwordFieldFaculty,textFieldFaculty,"faculty");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return facultyPanel;
		
	}
	public JPanel admin() {
		JPanel adminPanel = new JPanel();
		adminPanel.setLayout(null);
		adminPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		adminPanel.setBackground(Color.WHITE);
		adminPanel.setBounds(30, 40, 389, 362);
		adminPanel.setVisible(false);
		loginMainPanel.add(adminPanel);
		JButton hideShowToggler = new JButton("VIEW");
		hideShowToggler.setForeground(Color.RED);
		hideShowToggler.setFont(new Font("Arial", Font.PLAIN, 9));
		hideShowToggler.setFocusable(false);
		hideShowToggler.setBackground(Color.WHITE);
		hideShowToggler.setBounds(314, 235, 61, 20);
		adminPanel.add(hideShowToggler);
	
		
		JLabel adminLoginLogo = new JLabel("");
		adminLoginLogo.setIcon(new ImageIcon(".\\asset\\admin.png"));
		adminLoginLogo.setBounds(149, 11, 98, 109);
		adminPanel.add(adminLoginLogo);
		
		JLabel usernameaLabel = new JLabel("  USERNAME");
		usernameaLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		usernameaLabel.setBounds(29, 196, 98, 33);
		adminPanel.add(usernameaLabel);
		
		JTextField textField= new JTextField();
		textField.setColumns(10);
		textField.setBounds(137, 204, 167, 20);
		adminPanel.add(textField);
		
		JLabel passwordaLabel = new JLabel("  PASSWORD");
		passwordaLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		passwordaLabel.setBounds(29, 227, 98, 33);
		adminPanel.add(passwordaLabel);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(137, 235, 167, 20);
		adminPanel.add(passwordField);
		
		JButton adminSubmitBTN = new JButton("LOGIN");
		adminSubmitBTN.setForeground(Color.WHITE);
		adminSubmitBTN.setFocusable(false);
		adminSubmitBTN.setBackground(Color.RED);
		adminSubmitBTN.setBounds(149, 283, 98, 23);
		adminPanel.add(adminSubmitBTN);
		
		JLabel lblAdminLogin = new JLabel("    ADMIN LOGIN");
		lblAdminLogin.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblAdminLogin.setBounds(125, 153, 167, 33);
		adminPanel.add(lblAdminLogin);
		hideShowToggler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hideShowToggler.getText().equals("VIEW")) {
					passwordField.setEchoChar((char)0);
					hideShowToggler.setText("HIDE");
				}else {
					passwordField.setEchoChar('*');
					hideShowToggler.setText("VIEW");
				}
			
			}
		});
		adminSubmitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginAuthenication(passwordField,textField,"admin");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return adminPanel;
		

	}
	@SuppressWarnings("deprecation")
	public void loginAuthenication(JPasswordField pass,JTextField user,String str) throws ClassNotFoundException, SQLException{
		Pojo p=new Pojo(user.getText(),pass.getText());
		Dao d=new Dao();
		String session=d.studentLogin(p);
//		System.out.println(p);
		if(user.getText().isEmpty() || pass.getText().isEmpty()) {
			JOptionPane.showMessageDialog(contentPane,"Password or Username Field Empty","Wrong",JOptionPane.ERROR_MESSAGE);
			return;
		}else {
			
			if( session!= null) {
				setVisible(false);
				StudentMain sm=new StudentMain(session);
				sm.setVisible(true);
				return;
			}else if(user.getText().equals("faculty") && pass.getText().equals("12345")&&str.equals("faculty")) {
				setVisible(false);
				FacultyMain fm=new FacultyMain();
				fm.setVisible(true);
				return;
			}
			else if(user.getText().equals("admin")&&pass.getText().equals("12345")&&str.equals("admin")) {
				setVisible(false);
				adminMain am=new adminMain();
				am.setVisible(true);
				return;
			}else {
				JOptionPane.showMessageDialog(contentPane,"Error Password or Error username","Wrong",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
}
			
			
	
	
