package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;
import javax.swing.JTextField;

public class Admin extends JPanel {

	private static JTable table;
	private JTextField searchField;

	/**
	 * Nejarul Islam
	 * nejarulislam45@gmail.com
	 * coded by me
	 * Full Stack Java Developer
	 */
	public Admin(MenuBar menu,JFrame frame,int serial) {
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
//		System.out.println("refreshing");
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
						String sql="delete from admin where sl=?";
						
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,serial);
						ps.executeUpdate();
						con.close();
						model.setRowCount(0);
						refreshTable();
						JOptionPane.showMessageDialog(null,"row successfully deleted");
						frame.setVisible(false);
						
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
					UpdateAdmin update=new UpdateAdmin(model,table,menu,frame,serial);
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
				InsertAdmin insert=new InsertAdmin(model);
				insert.setVisible(true);
				model.setRowCount(0);
				refreshTable();
			}
		});
		Insert.setBounds(829, 166, 89, 23);
		upperBackground.add(Insert);
		
		JButton btnShowProfile = new JButton("Show Profile");
		btnShowProfile.setFocusable(false);
		btnShowProfile.setBackground(SystemColor.activeCaption);
		btnShowProfile.setBounds(700, 166, 119, 23);
		upperBackground.add(btnShowProfile);
		
		JButton searchButton = new JButton("SEARCH");
		
		searchButton.setFocusable(false);
		searchButton.setBackground(SystemColor.activeCaption);
		searchButton.setBounds(502, 166, 184, 23);
		upperBackground.add(searchButton);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		searchField.setColumns(10);
		searchField.setBounds(55, 166, 437, 26);
		upperBackground.add(searchField);
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=Connector.connect();
					String q="select * from admin where (username like ?) or (name like ?) or(mobile like ?) or(email like ?) or"
							+ "(dob like ?) or (designation like ?) or (address like ?) or (qualification like ?)";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1,"%"+searchField.getText()+"%");
					ps.setString(2,"%"+searchField.getText()+"%");
					ps.setString(3,"%"+searchField.getText()+"%");
					ps.setString(4,"%"+searchField.getText()+"%");
					ps.setString(5,"%"+searchField.getText()+"%");
					ps.setString(6,"%"+searchField.getText()+"%");
					ps.setString(7,"%"+searchField.getText()+"%");
					ps.setString(8,"%"+searchField.getText()+"%");
					ResultSet rs=ps.executeQuery();
					model.setRowCount(0);
					ArrayList<Comparable> list=new ArrayList<Comparable>();
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
					model.addRow(list.toArray());
						
					}
					if(model.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No record found");
					}
					Connector.Close(con);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		btnShowProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No row selected","Wrong ",JOptionPane.WARNING_MESSAGE);
				}else {
					int row=table.getSelectedRow();
					showAdminProfile profile=new showAdminProfile(Integer.parseInt(model.getValueAt(row, 0).toString()));
					profile.setVisible(true);
				}
			}
		});
	
	
	}

	public static DefaultTableModel refreshTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		table.setRowHeight(40);
		
		String head[]= {"Seral No","Username","Name","mobile no","email id","date of birth","designation","address","Qualification"};
		model.setColumnIdentifiers(head);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		try {
			Connection con=Connector.connect();
			String q="select * from admin order by sl";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			ArrayList<Comparable> list=new ArrayList<Comparable>();
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
			model.addRow(list.toArray());
				
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
