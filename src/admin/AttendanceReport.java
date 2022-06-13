package admin;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class AttendanceReport extends JPanel {
	private JTable table;
	private JTextField searchField;

	/**
	 * Nejarul Islam
	 * nejarulislam45@gmail.com
	 */
	public AttendanceReport() {
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
		scrollPane.setBounds(0, 200, 1267, 472);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton refresh = new JButton("Refresh");
		refresh.setBackground(SystemColor.activeCaption);
		refresh.setFocusable(false);
		upperBackground.add(refresh);
		refresh.setBounds(1100, 161, 107, 23);
		
		JButton searchButton = new JButton("SEARCH");
				searchButton.setFocusable(false);
		searchButton.setBackground(SystemColor.activeCaption);
		searchButton.setBounds(908, 157, 184, 23);
		upperBackground.add(searchButton);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		searchField.setColumns(10);
		searchField.setBounds(461, 158, 437, 26);
		upperBackground.add(searchField);
		
		JLabel lblYouCan = new JLabel("!! YOU CAN ONLY SEARCH BY USERNAME ,SEMESTER  !!");
		lblYouCan.setForeground(Color.WHITE);
		lblYouCan.setFont(new Font("Segoe UI Emoji", Font.BOLD, 11));
		lblYouCan.setBounds(461, 123, 411, 24);
		upperBackground.add(lblYouCan);
		DefaultTableModel model=addTable();
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				addTable();
				
			}
			
		});
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=Connector.connect();
					String q="select * from attendance where (username like ?) or (semester like ?)";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1, "%"+searchField.getText()+"%");
					ps.setString(2, "%"+searchField.getText()+"%");
					ResultSet rs=ps.executeQuery();
					ArrayList list=new ArrayList();
					model.setRowCount(0);
					while(rs.next()) {
						list.removeAll(list);
						list.add(rs.getInt(1));
						list.add(rs.getString(2));
						list.add(rs.getString(3));
						float x=((float)rs.getInt(5)/(float)rs.getInt(4))*100;
						list.add(x+"%");
						list.add(rs.getTimestamp(6));
						model.addRow(list.toArray());
					}
					if(model.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No Record Found");
					}
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		

	}

	private DefaultTableModel addTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		table.setRowHeight(40);
		String []head= {"serial","name","semester","attendance percentage","last attendance"};
		model.setColumnIdentifiers(head);
		try {
			Connection con=Connector.connect();
			String q="select * from attendance order by serial";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			ArrayList list=new ArrayList();
			while(rs.next()) {
				list.removeAll(list);
				list.add(rs.getInt(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				float x=((float)rs.getInt(5)/(float)rs.getInt(4))*100;
				list.add(x+"%");
				list.add(rs.getTimestamp(6));
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
