package admin;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;
import Method.Validation;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Department extends JPanel {
	private static JTable table;
	private JTextField searchField;
//	JPanel panel;
	
	public Department() {
		setBounds(0,0,1301,683);
		setLayout(null);
		Method method=new Method();
		JLabel upperBackground = new JLabel("");
		upperBackground.setBackground(SystemColor.activeCaption);
		upperBackground.setForeground(Color.GRAY);
		ImageIcon image=new ImageIcon(".\\asset\\uperBack.jpg");
	
		method.resizeImage(image,1300,382,upperBackground);
		upperBackground.setBounds(0, 0, 1301, 200);
//		upperBackground.setBorder(new LineBorder(Color.black,2));
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 200, 1215, 483);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		DefaultTableModel model=refreshTable();
		
		JButton deleteButton = new JButton("Delete");
		
		deleteButton.setBounds(1027, 166, 89, 23);
		deleteButton.setBackground(SystemColor.activeCaption);
		upperBackground.add(deleteButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No row Selected","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					
					updateDepartment update=new updateDepartment(table,model);
					update.setVisible(true);
					update.setBounds(406, 120, 410, 389);
//					add(update);
//					update.toFront();
				
					
				}
			}

			});
		updateButton.setBounds(928, 166, 89, 23);
		updateButton.setBackground(SystemColor.activeCaption);
		upperBackground.add(updateButton);
		JButton insertButton = new JButton("Insert");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertDepartment panel=new insertDepartment(model);
				panel.toFront();
				panel.setVisible(true);
				
				
//				add(panel);
				
			}
		});
		insertButton.setBounds(829, 166, 89, 23);
		insertButton.setBackground(SystemColor.activeCaption);
		insertButton.setFocusable(false);
		upperBackground.add(insertButton);
		JButton refreshButton = new JButton("Full List");
		upperBackground.add(refreshButton);
		refreshButton.setBackground(SystemColor.activeCaption);
		refreshButton.setBounds(1126, 166, 89, 23);
		refreshButton.setFocusable(false);
		
		refreshButton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				refreshTable();
				
			}
			
		});

		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((table.getSelectedRowCount()==0)) {
					JOptionPane.showMessageDialog(null, "No row Selected","Error",JOptionPane.ERROR_MESSAGE);
				}else{
					try {
						int n=JOptionPane.showConfirmDialog(null, "Are you sure ?");
						System.out.println(n);
						if(n==0) {
							Connection con=Connector.connect();
							int rowIndex=table.getSelectedRow();
							String dcode=model.getValueAt(rowIndex, 1).toString();
							String query="delete from Department where d_code=?";
							PreparedStatement ps=con.prepareStatement(query);
							ps.setString(1, dcode);
							ps.executeUpdate();
							con.close();
							model.setRowCount(0);
							refreshTable();
							JOptionPane.showMessageDialog(null, "Deleted Successfully");
						}
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,"Not Deleted");
						e1.printStackTrace();
					}
					model.setRowCount(0);
					refreshTable();
				}
				
			}
		});
		add(upperBackground);
		add(scrollPane);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		searchField.setBounds(180, 163, 437, 26);
		upperBackground.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					String search=searchField.getText().toUpperCase();
					Connection con=Connector.connect();
					String sql="select * from department where (d_code like ?) or (d_name like ?) or (sl_no like ?) or (d_type like ?) ";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, "%"+search+"%");
					ps.setString(2, "%"+search+"%");
					if(Validation.stringContainsString(search)) {
						ps.setInt(3, Integer.parseInt(search));
					}else {
						ps.setInt(3, 0);
					}
					
					ps.setString(4,"%"+search+"%");
					ResultSet rs=ps.executeQuery();
					ArrayList list=new ArrayList();
					model.setRowCount(0);
					while(rs.next()) {
						list.removeAll(list);
						list.add(rs.getInt(1));
						list.add(rs.getString(2));
						list.add(rs.getString(3));
						list.add(rs.getString(4));
						list.add(rs.getInt(5));
						model.addRow(list.toArray());
					}
					
					if(model.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No record Found");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		searchButton.setFocusable(false);
		searchButton.setBackground(SystemColor.activeCaption);
		searchButton.setBounds(637, 165, 184, 23);
		upperBackground.add(searchButton);
		
	}
	

	
	
	public static DefaultTableModel refreshTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		String head[]= {"Seral No","Department Code","Department Name","Department Type","Seat"};
		model.setColumnIdentifiers(head);
		ResultSet rs = null;
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.setRowHeight(30);
		try {
			Connection con=Connector.connect();
			String query="select * from department order by sl_no";
			Statement st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				String sl=rs.getString(1);
				String dcode=rs.getString(2);
				String dname=rs.getString(3);
				String dtype=rs.getString(4);
				String seat=""+(rs.getInt(5));
				String row[]= {sl,dcode,dname,dtype,seat};
				model.addRow(row);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
		
	}
}
