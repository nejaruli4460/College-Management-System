package faculty;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;
import admin.SetSubject;

import javax.swing.JSlider;
import javax.swing.JCheckBoxMenuItem;

public class MarksDistribute extends JPanel {
	JComboBox<?> combo;
	private static JTable table;
	/**
	 * Create the panel.
	 */
	public MarksDistribute(int serial) {
		setBounds(0,0,1301,683);
		setLayout(null);		
		Method method=new Method();
		JLabel upperBackground = new JLabel("");
		upperBackground.setBackground(SystemColor.activeCaption);
		upperBackground.setForeground(Color.GRAY);
		ImageIcon image=new ImageIcon(".\\asset\\uperBack.jpg");
//		upperBackground.setBorder(new LineBorder(Color.black,3));
		method.resizeImage(image,1300,382,upperBackground);
		upperBackground.setBounds(0, 0, 1301, 200);
		add(upperBackground);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 198, 1202, 485);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		DefaultTableModel model=refreshReport(serial);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBackground(SystemColor.activeCaption);
		upperBackground.add(refreshButton);
		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		refreshButton.setBounds(1090, 163, 89, 23);
		refreshButton.setFocusable(false);
		
		JButton marksButton = new JButton("Update Marks");
		marksButton.setBackground(SystemColor.activeCaption);
		marksButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		marksButton.setBounds(974, 163, 104, 26);
		marksButton.setFocusable(false);
		upperBackground.add(marksButton);
		
		JButton filterButton = new JButton("Filter");
		filterButton.setBackground(SystemColor.activeCaption);
		filterButton.setFocusable(false);
		filterButton.setBounds(859, 164, 104, 23);
		upperBackground.add(filterButton);
		String comboItem[]= {"SEMESTER 1","SEMESTER 2","SEMESTER 3","SEMESTER 4","SEMESTER 5","SEMESTER 6"};
		JComboBox<?> comboBox = new JComboBox<Object>(comboItem);
		comboBox.setBounds(529, 165, 284, 22);
		upperBackground.add(comboBox);
		
		filterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				refreshReport(comboBox.getSelectedItem().toString(),serial);
				
			}

			
			
		});
		
		refreshButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				refreshReport(serial);
				
			}
			
		});
		marksButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No row selected");
				}else {
					try {
					SetMarks marks=new SetMarks(model,table,serial);
					marks.setVisible(true);
					}catch(NullPointerException ne) {
					JOptionPane.showMessageDialog(null,"Subject not set yet contact to administrator","Error",JOptionPane.ERROR_MESSAGE);
					
					}
				}
				
			}
			
		});
		
		
	}

	public static DefaultTableModel refreshReport(int serial) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		String []head= {"serial","Name","Department","Semester","Subject-1","Practical Marks","Written Marks","Subject-2","Practical Marks","Written Marks","Subject-3","Practical Marks","Written Marks","Subject-4","Practical Marks","Written Marks","Status"};
		model.setColumnIdentifiers(head);
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(16).setPreferredWidth(200);
		try {
			Connection con=Connector.connect();
			String query="select * from result where department=? order by sl";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1,Method.facultyDepartmentNameBySerial(serial));
			ResultSet rs=stmt.executeQuery();
			ArrayList<Comparable> list=new ArrayList<Comparable>();
			while(rs.next()) {
				list.removeAll(list);
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(9));
				list.add(rs.getInt(6));
				list.add(rs.getInt(8));
				list.add(rs.getString(14));
				list.add(rs.getInt(11));
				list.add(rs.getInt(13));
				list.add(rs.getString(19));
				list.add(rs.getInt(16));
				list.add(rs.getInt(18));
				list.add(rs.getString(24));
				list.add(rs.getInt(21));
				list.add(rs.getInt(23));
				if(rs.getInt(25)==0) {
					list.add("Not set result");
				}else if(rs.getInt(25)==1) {
					list.add("Result not announced");
				}else {
					list.add("Result announced");
				}
				model.addRow(list.toArray());
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
		
	}
	private DefaultTableModel refreshReport(String selectedItem,int serial) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		String []head= {"serial","Name","Department","Semester","Subject-1","Practical Marks","Written Marks","Subject-2","Practical Marks","Written Marks","Subject-3","Practical Marks","Written Marks","Subject-4","Practical Marks","Written Marks","Status"};
		model.setColumnIdentifiers(head);
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		table.setRowHeight(40);
		try {
			Connection con=Connector.connect();
			String query="select * from result where semester=? and department=? order by sl";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, selectedItem);
			stmt.setString(2, Method.facultyDepartmentNameBySerial(serial));
			ResultSet rs=stmt.executeQuery();
			
			ArrayList<Comparable> list=new ArrayList<Comparable>();
			while(rs.next()) {
				list.removeAll(list);
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(9));
				list.add(rs.getInt(6));
				list.add(rs.getInt(8));
				list.add(rs.getString(14));
				list.add(rs.getInt(11));
				list.add(rs.getInt(13));
				list.add(rs.getString(19));
				list.add(rs.getInt(16));
				list.add(rs.getInt(18));
				list.add(rs.getString(24));
				list.add(rs.getInt(21));
				list.add(rs.getInt(23));
				if(rs.getInt(25)==0) {
					list.add("Not set result");
				}else if(rs.getInt(25)==1) {
					list.add("Result not announced");
				}else {
					list.add("Result announced");
				}
							model.addRow(list.toArray());
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;

		
	}
	
}
	

