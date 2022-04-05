package student;

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
		setBorder(new LineBorder(new Color(0, 0, 0)));
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
					StudentMain sm=new StudentMain("exit");
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
		logoutButton.setBounds(10, 454, 125, 27);
		add(logoutButton);
		
	}
	public JButton homeButton() {
		JButton homeButton = new JButton("Home");
		homeButton.setBackground(new Color(64, 224, 208));
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		homeButton.setBounds(10, 156, 125, 27);
		homeButton.setFocusable(false);
		return homeButton;
	}
	public JButton routineButton() {
		JButton routineButton = new JButton("Routine");
		routineButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		routineButton.setBackground(new Color(64, 224, 208));
		routineButton.setBounds(10, 188, 125, 27);
		routineButton.setFocusable(false);
		return routineButton;
	}
	public JButton feeButton() {
		JButton feeButton = new JButton("Fees Pay");
		feeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		feeButton.setFocusable(false);
		feeButton.setBackground(new Color(64, 224, 208));
		feeButton.setBounds(10, 226, 125, 27);
		return feeButton;
		
	}
	public JButton recieptButton() {
		JButton recieptButton = new JButton("Reciept");
		recieptButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		recieptButton.setFocusable(false);
		recieptButton.setBackground(new Color(64, 224, 208));
		recieptButton.setBounds(10, 264, 125, 27);
		return recieptButton;
	}
	public JButton noticeButton() {
		JButton noticeButton = new JButton("Notice");
		noticeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		noticeButton.setFocusable(false);
		noticeButton.setBackground(new Color(64, 224, 208));
		noticeButton.setBounds(10, 302, 125, 27);
		return(noticeButton);
	}
public JButton marksheetButton() {
	JButton marksheetButton = new JButton("Marksheet");
	marksheetButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
	marksheetButton.setFocusable(false);
	marksheetButton.setBackground(new Color(64, 224, 208));
	marksheetButton.setBounds(10, 340, 125, 27);
	return(marksheetButton);
	}
public JButton profileButton() {
	JButton profileButton = new JButton("Profile");
	profileButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
	profileButton.setFocusable(false);
	profileButton.setBackground(new Color(64, 224, 208));
	profileButton.setBounds(10, 378, 125, 27);
	return(profileButton);
	}
public JButton contactButton() {
	JButton contactButton = new JButton("Contact Us");
	contactButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
	contactButton.setFocusable(false);
	contactButton.setBackground(new Color(64, 224, 208));
	contactButton.setBounds(10, 416, 125, 27);
	return(contactButton);
 }
}
