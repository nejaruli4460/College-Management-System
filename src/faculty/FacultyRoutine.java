package faculty;

import java.awt.Color;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ConnectionPackage.Connector;
import Method.Method;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FacultyRoutine extends JPanel {
	String Filename;
	private JTextField departmentField;
	/**
	 * Create the panel.
	 */
	public FacultyRoutine(int serial) {
		setBounds(0,0,1301,683);
		setLayout(null);
		Method method=new Method();
		JLabel upperBackground = new JLabel("");
		upperBackground.setBackground(SystemColor.activeCaption);
		upperBackground.setForeground(Color.GRAY);
		ImageIcon image=new ImageIcon(".\\asset\\uperBack.jpg");
	
		method.resizeImage(image,1300,683,upperBackground);
		upperBackground.setBounds(0, 0, 1301, 683);
		add(upperBackground);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 23, 1180, 102);
		upperBackground.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Upload Routine Here");
		lblNewLabel.setBounds(532, 38, 133, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(20, 150, 1180, 502);
		upperBackground.add(panel2);
		panel2.setLayout(null);
		
		JLabel routine = new JLabel("");
		routine.setBounds(0, 0, 1180, 502);
		panel2.add(routine);
		
		JButton choose = new JButton("choose...");
		choose.setBackground(SystemColor.activeCaption);
		choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser c=new JFileChooser();
					c.showOpenDialog(null);
					File f=c.getSelectedFile();
					Filename=f.getAbsolutePath();
					ImageIcon routineImage=new ImageIcon(Filename);
					method.resizeImage(routineImage, 1180, 502, routine);
				}catch(NullPointerException ne) {
					JOptionPane.showMessageDialog(null, "No file chosen");
				}
				
				
			}
		});
		choose.setBounds(711, 38, 89, 23);
		choose.setFocusable(false);
		panel.add(choose);
		
		JLabel lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepartmentName.setBounds(10, 42, 133, 19);
		panel.add(lblDepartmentName);
		
		ArrayList list=new ArrayList();
		
		try {
			Connection con =Connector.connect();
			String	sql="select d_code from department";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton uploadButton = new JButton("Upload");
		uploadButton.setBackground(SystemColor.activeCaption);
		uploadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String department=Method.facultyDepartmentNameBySerial(serial);
				Boolean flag=false;
				try {
					Connection con =Connector.connect();
					String query="select department from routine";
					Statement  stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					while(rs.next()) {
						if(rs.getString(1).equals(department)) {
							flag=true;
							break;
						}
					}
					InputStream in=new FileInputStream(Filename);
					if(flag==false) {
						String q="insert into routine(department,routine) values(?,?)";
						PreparedStatement ps=con.prepareStatement(q);
						ps.setString(1, department);
						ps.setBlob(2, in);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Insertion successfull");
					}else {
						String q="update routine set routine=? where department=?";
						PreparedStatement ps=con.prepareStatement(q);
						ps.setString(2, department);
						ps.setBlob(1, in);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Updation successfull");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Something went wrong");
				}
			}
		});
		uploadButton.setBounds(823, 38, 89, 23);
		uploadButton.setFocusable(false);
		panel.add(uploadButton);
		
		departmentField = new JTextField(Method.facultyDepartmentNameBySerial(serial));
		departmentField.setEditable(false);
		departmentField.setBounds(153, 35, 359, 29);
		panel.add(departmentField);
		departmentField.setColumns(10);
		if(Filename==null) {
						
			Refresh(routine,serial);
		}
		
		
	}
	public static void Refresh(JLabel routine,int serial){
		Method method =new Method();
		Connection con;
		try {
			con = Connector.connect();
			String query="select routine from routine where department=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, Method.facultyDepartmentNameBySerial(serial));
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Blob b=rs.getBlob(1);
				InputStream in=b.getBinaryStream();
				Image img=ImageIO.read(in);
				ImageIcon icon=new ImageIcon(img);
				method.resizeImage(icon, 1180, 502, routine);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
