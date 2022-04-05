package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JPanel {
	private static JTable table;

	/**
	 * Create the panel.
	 */
	public Student() {
		setBounds(0,0,1301,683);
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
		
		JButton refreshButton = new JButton("Refresh");
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
						String sql="delete from student where serial=?";
						
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,serial);
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
		
		JButton Insert = new JButton("Insert");
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
	
	
	}

	public static DefaultTableModel refreshTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(Color.cyan);
		String head[]= {"Seral No","Name","Fathers Name","Gender","Address","Pincode","Date of Birth","Department","Mobile NO","Email id"};
		model.setColumnIdentifiers(head);
		try {
			Connection con=Connector.connect();
			String q="select * from student order by serial";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			while(rs.next()) {
				String sl=rs.getString(1);
				String name=rs.getString(2);
				String father=rs.getString(3);
				String gender=rs.getString(4);
				String address=rs.getString(5);
				String pin=rs.getString(6);
				String dob=rs.getString(7);
				String dept=rs.getString(8);
				String mobile=rs.getString(9);
				String email=rs.getString(10);
				String data[]= {sl,name,father,gender,address,pin,dob,dept,mobile,email};
				model.addRow(data);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
