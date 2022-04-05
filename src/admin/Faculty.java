package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;

public class Faculty extends JPanel {
	private static JTable table;

	/**
	 * Create the panel.
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
		upperBackground.setBorder(new LineBorder(Color.black,2));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 200, 1215, 483);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		add(scrollPane);
		DefaultTableModel model=refreshTable();
		
		
	}

	public static DefaultTableModel refreshTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(Color.cyan);
		String head[]= {"Serial No","Name","Date Of Birth","Gender","Address","Mobile","Email","Department","Designation","Qualification","Area of Interest"};
		model.setColumnIdentifiers(head);
		try {
			Connection con=Connector.connect();
			String query="select * from faculty order by sl";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			@SuppressWarnings("rawtypes")
			ArrayList<Comparable> list=new ArrayList<Comparable>();
			while(rs.next()) {
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
				model.addRow(list.toArray());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

}
