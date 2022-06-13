package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;
import Method.Validation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Student extends JPanel {
	private static JTable table;
	private JTextField searchField;

	/**
	 * Create the panel.
	 */
	public Student() {
		setBounds(0,0,1501,683);
		setLayout(null);
		Method method=new Method();
		JLabel upperBackground = new JLabel("");
		upperBackground.setBackground(SystemColor.activeCaption);
		upperBackground.setForeground(Color.GRAY);
		ImageIcon image=new ImageIcon(".\\asset\\uperBack.jpg");
	
		method.resizeImage(image,1300,382,upperBackground);
		upperBackground.setBounds(0, 0, 1301, 200);
		add(upperBackground);
//		upperBackground.setBorder(new LineBorder(Color.black,2));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 200, 1215, 483);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		add(scrollPane);
		DefaultTableModel model=refreshTable();
		
		JButton refreshButton = new JButton("Full List");
		refreshButton.setFocusable(false);
		refreshButton.setBackground(SystemColor.activeCaption);
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				refreshTable();
			}
		});
		refreshButton.setBounds(1126, 166, 89, 23);
		upperBackground.add(refreshButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No row selected","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						Connection con=Connector.connect();
						int row=table.getSelectedRow();
						int serial=Integer.parseInt(model.getValueAt(row, 0).toString());
						
						String sql1="delete from studentfees where username=?";
						
						PreparedStatement ps1=con.prepareStatement(sql1);
						ps1.setString(1,Method.usernameBySerial(serial));
						ps1.executeUpdate();
						
						String sql2="delete from result where username=?";
						
						PreparedStatement ps2=con.prepareStatement(sql2);
						ps2.setString(1,Method.usernameBySerial(serial));
						ps2.executeUpdate();
						
						String query="delete from attendance where username=?";
						PreparedStatement p1=con.prepareStatement(query);
						p1.setString(1,Method.usernameBySerial(serial));
						p1.executeUpdate();
						
						String sql="delete from student where username=?";
						
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1,Method.usernameBySerial(serial));
						ps.executeUpdate();
						
						
						con.close();
						model.setRowCount(0);
						refreshTable();
						JOptionPane.showMessageDialog(null,"row successfully deleted");
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"something wrong");
						e1.printStackTrace();
					}
				}
				
			}
		});
		deleteButton.setBackground(SystemColor.activeCaption);
		deleteButton.setBounds(1027, 166, 89, 23);
		deleteButton.setFocusable(false);
		upperBackground.add(deleteButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(table.getSelectedRow());
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No row selected","Wrong ",JOptionPane.WARNING_MESSAGE);
				}else {
					UpdateStudent update=new UpdateStudent(model,table);
					update.setVisible(true);
				}
				
				
			}
		});
		updateButton.setBackground(SystemColor.activeCaption);
		updateButton.setBounds(928, 166, 89, 23);
		updateButton.setFocusable(false);
		upperBackground.add(updateButton);
		
		JButton Insert = new JButton("Admit");
		Insert.setBackground(SystemColor.activeCaption);
		Insert.setFocusable(false);
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertStudent insert=new InsertStudent(model);
				insert.setVisible(true);
				model.setRowCount(0);
				refreshTable();
			}
		});
		Insert.setBounds(829, 166, 89, 23);
		upperBackground.add(Insert);
		
		JButton btnShowProfile = new JButton("Show Profile");
		btnShowProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No row selected","Wrong ",JOptionPane.WARNING_MESSAGE);
				}else {
					int row=table.getSelectedRow();
					showStudentProfile profile=new showStudentProfile(Integer.parseInt(model.getValueAt(row, 0).toString()));
					profile.setVisible(true);
				}
			}
		});
		btnShowProfile.setFocusable(false);
		btnShowProfile.setBackground(SystemColor.activeCaption);
		btnShowProfile.setBounds(707, 166, 113, 23);
		upperBackground.add(btnShowProfile);
		
		JButton searchButton = new JButton("SEARCH");
		
		searchButton.setFocusable(false);
		searchButton.setBackground(SystemColor.activeCaption);
		searchButton.setBounds(510, 167, 184, 23);
		upperBackground.add(searchButton);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		searchField.setColumns(10);
		searchField.setBounds(63, 167, 437, 26);
		upperBackground.add(searchField);
	
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					model.setRowCount(0);
					Connection con=Connector.connect();
					String query="select s.serial,s.username,s.name,s.father,s.gender,s.address,s.pin,s.dob,s.department,s.mobile,s.email,sf.status from student s,studentfees sf where (s.username=sf.username and sf.sem=s.current_sem) and"
					+"((s.serial=?) or (s.username like ?) or(s.name like ?) or (s.father like?)"
					+ "or (s.gender like ?) or (s.address like ?) or (s.pin like ?) or(s.dob like ?) or (s.department like ?) or (s.mobile like ?) or(s.email like ?) or (sf.status like ?))";
					
					PreparedStatement ps=con.prepareStatement(query);
					String search=searchField.getText();
					if(Validation.stringContainsString(search)) {
						ps.setInt(1, Integer.parseInt(search));
					}else {
						ps.setInt(1, 0);
					}
					ps.setString(2,"%"+ search+"%");
					ps.setString(3,"%"+ search+"%");
					ps.setString(4,"%"+ search+"%");
					ps.setString(5,"%"+ search+"%");
					ps.setString(6,"%"+ search+"%");
					ps.setString(7,"%"+ search+"%");
					ps.setString(8,"%"+ search+"%");
					ps.setString(9,"%"+ search+"%");
					ps.setString(10,"%"+ search+"%");
					ps.setString(11,"%"+ search+"%");
					ps.setString(12,"%"+ search+"%");
					ResultSet rs=ps.executeQuery();
					ArrayList list=new ArrayList();
					while(rs.next()) {
						list.removeAll(list);
						list.add(rs.getInt(1));
						list.add(rs.getString(2));
						list.add(rs.getString(3));
						list.add(rs.getString(4));
						list.add(rs.getString(5));
						list.add(rs.getString(6));
						list.add(rs.getString(7));
						list.add(rs.getString(8));
						list.add(rs.getString(9));
						list.add(rs.getString(10));
						list.add(rs.getString(11));
						list.add(rs.getString(12));
						model.addRow(list.toArray());

						
					}
					if(model.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "no Record found");
					}
					con.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
	}

	public static DefaultTableModel refreshTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		
		model.setRowCount(0);
		
		String head[]= {"Sl","Username","Name","C/O","Gender","Address","Pincode","Date of Birth","Department","Mobile NO","Email id","Fees"};
		model.setColumnIdentifiers(head);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.getColumnModel().getColumn(10).setPreferredWidth(200);
		table.getColumnModel().getColumn(11).setPreferredWidth(40);
		try {
			Connection con=Connector.connect();
			String q="select s.serial,s.username,s.name,s.father,s.gender,s.address,s.pin,s.dob,s.department,s.mobile,"
					+ "s.email,sf.status from student s,studentfees sf where (s.username=sf.username and sf.sem=s.current_sem) or (s.current_sem=? and sf.sem=?) order by s.serial";
			PreparedStatement st=con.prepareStatement(q);
			st.setString(1, "passed");
			st.setString(2, "SEMESTER 6");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				String sl=rs.getString(1);
				String username=rs.getString(2);
				String name=rs.getString(3);
				String father=rs.getString(4);
				String gender=rs.getString(5);
				String address=rs.getString(6);
				String pin=rs.getString(7);
				String dob=rs.getString(8);
				String dept=rs.getString(9);
				String mobile=rs.getString(10);
				String email=rs.getString(11);
				String feeStatus=rs.getString(12);
				String data[]= {sl,username,name,father,gender,address,pin,dob,dept,mobile,email,feeStatus};
				model.addRow(data);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
