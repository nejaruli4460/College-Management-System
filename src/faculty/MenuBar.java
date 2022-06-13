package faculty;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ConnectionPackage.Connector;
import Login.LoginPage;
import Method.Method;

public class MenuBar extends JPanel {
	public MenuBar(int serial) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(0, 204, 153,0));
		setLayout(null);
		setBounds(0,0,148,683);
		
		
		setVisible(true);
		
		JLabel image = new JLabel("");
		image.setBounds(27, 11, 78, 90);
		add(image);
		
		JLabel userName = new JLabel();
		userName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		userName.setBounds(10, 107, 125, 27);
		add(userName);
		
		try {
			Connection con=Connector.connect();
			String query="select image,designation from faculty where sl=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Method method=new Method();
				Blob b=rs.getBlob(1);
				InputStream is=b.getBinaryStream();
				Image img=ImageIO.read(is);
				ImageIcon icon=new ImageIcon(img);
				method.resizeImage(icon, 78, 90, image);
				userName.setText(rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		
		
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
		JButton btnContactUs = new JButton("Message US");
		btnContactUs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnContactUs.setFocusable(false);
		btnContactUs.setBackground(new Color(64, 224, 208));
		btnContactUs.setBounds(10, 466, 125, 27);
		return(btnContactUs);
	}
}


