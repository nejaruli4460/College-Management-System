package admin;

import java.awt.Color;

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

import javax.swing.JTextField;

public class Faculty extends JPanel {
	private static JTable table;
	static insertFaculty insert;
	private JTextField searchField;

	/**
	 * Nejarul Islam
	 * 193115-21-0053
	 * Surendranath College
	 */
	public Faculty() {
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
		
		JButton refreshButton = new JButton("Full List");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				refreshTable();
			}
		});
		refreshButton.setFocusable(false);
		refreshButton.setBackground(SystemColor.activeCaption);
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
						String sql="delete from faculty where sl=?";
						
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
					UpdateFaculty update=new UpdateFaculty(table,model);
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
				insert=new insertFaculty(model);
				insert.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		btnShowProfile.setBounds(701, 166, 114, 23);
		upperBackground.add(btnShowProfile);
		
		JButton searchButton = new JButton("SEARCH");
		
		searchButton.setFocusable(false);
		searchButton.setBackground(SystemColor.activeCaption);
		searchButton.setBounds(508, 166, 184, 23);
		upperBackground.add(searchButton);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		searchField.setColumns(10);
		searchField.setBounds(61, 166, 437, 26);
		upperBackground.add(searchField);

		btnShowProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No row selected","Wrong ",JOptionPane.WARNING_MESSAGE);
				}else {
					int row=table.getSelectedRow();
					showFacultyProfile profile=new showFacultyProfile(Integer.parseInt(model.getValueAt(row, 0).toString()));
					profile.setVisible(true);
				}
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String search=searchField.getText();
				searchField.setText("");
				Connection con=Connector.connect();
				String query="select * from faculty where (sl=?) or (name like ?) or (username like ?) or (dob like ?) or (gender like ?) or (address like ?) or(mobile like ?) or (email like ?) or(department like ?) or(designation like ?) or (Qualification like ?) or (aot like ?)";
				PreparedStatement ps=con.prepareStatement(query);
				if(Validation.stringContainsString(search)) {
					ps.setInt(1, Integer.parseInt(search));
				}else {
					ps.setInt(1, 0);
				}
				for(int i=2;i<=12;i++) {
					ps.setString(i,"%"+search+"%");
				}
				
				ResultSet rs=ps.executeQuery();
				ArrayList<Object> list=new ArrayList<>();
				model.setRowCount(0);
				while(rs.next()) {
					list.removeAll(list);
					list.add(rs.getInt(1));
					
					for(int i=2;i<=12;i++) {
						list.add(rs.getString(i));
					}
						model.addRow(list.toArray());
				}
				if(model.getRowCount()==0) {
					JOptionPane.showMessageDialog(null,"No record found");
				}
				con.close();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
				e1.printStackTrace();
			}

			}
		});
		
		
	}

	public static DefaultTableModel refreshTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		String head[]= {"Sl","Name","Username","Date Of Birth","Gender","Address","Mobile","Email","Department","Designation","Qualification","Area of Interest"};
		model.setColumnIdentifiers(head);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(9).setPreferredWidth(200);
		table.getColumnModel().getColumn(11).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		try {
			Connection con=Connector.connect();
			String query="select * from faculty order by sl";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			ArrayList<Object> list=new ArrayList<>();
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
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
		}
		return model;
	}
}
