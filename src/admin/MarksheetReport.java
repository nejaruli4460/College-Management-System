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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class MarksheetReport extends JPanel {
	private static JTable table;
	private JTextField searchField;
	
	/**
	 * Create the panel.
	 */
	public MarksheetReport() {
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
		scrollPane.setBounds(0, 198, 1207, 490);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		DefaultTableModel model=refreshReport();
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBackground(SystemColor.activeCaption);
		upperBackground.add(refreshButton);
		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		refreshButton.setBounds(1090, 163, 89, 23);
		refreshButton.setFocusable(false);
		
		JButton subjectButton = new JButton("Set Subject");
		subjectButton.setBackground(SystemColor.activeCaption);
		subjectButton.setBounds(976, 163, 104, 23);
		subjectButton.setFocusable(false);
		upperBackground.add(subjectButton);
		
		JButton announcedButton = new JButton("Announced");
		announcedButton.setBackground(SystemColor.activeCaption);
		announcedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Announce an=new Announce();
				an.setVisible(true);
			}
		});
		announcedButton.setFocusable(false);
		announcedButton.setBounds(857, 163, 104, 23);
		upperBackground.add(announcedButton);
		
		JButton searchButton = new JButton("SEARCH");
		
		searchButton.setFocusable(false);
		searchButton.setBackground(SystemColor.activeCaption);
		searchButton.setBounds(665, 164, 184, 23);
		upperBackground.add(searchButton);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		searchField.setColumns(10);
		searchField.setBounds(218, 165, 437, 26);
		upperBackground.add(searchField);
		
		JLabel lblNewLabel = new JLabel("!! YOU CAN ONLY SEARCH BY USERNAME ,SEMESTER,DEPARTMENT !!");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(235, 126, 411, 24);
		upperBackground.add(lblNewLabel);
		refreshButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				refreshReport();
				
			}
			
		});
		subjectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetSubject subject=new SetSubject(model,table);
				subject.setVisible(true);
				
			}
			
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=Connector.connect();
					String query="select * from result where (username like ?) or (semester like ?) or(department like ?) ";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,"%"+searchField.getText()+"%");
					ps.setString(2,"%"+searchField.getText()+"%");
					ps.setString(3,"%"+searchField.getText()+"%");
					ResultSet rs=ps.executeQuery();
					ArrayList list=new ArrayList();
					model.setRowCount(0);
					while(rs.next()) {
						list.removeAll(list);
						list.add(rs.getString(1));
						list.add(rs.getString(2));
						list.add(rs.getString(3));
						list.add(rs.getString(4));
						list.add(rs.getString(9));
						list.add(rs.getInt(5));
						list.add(rs.getInt(7));
						list.add(rs.getString(14));
						list.add(rs.getInt(10));
						list.add(rs.getInt(12));
						list.add(rs.getString(19));
						list.add(rs.getInt(15));
						list.add(rs.getInt(17));
						list.add(rs.getString(24));
						list.add(rs.getInt(20));
						list.add(rs.getInt(22));
						if(rs.getInt(25)==0) {
							list.add("Not set result");
						}else if(rs.getInt(25)==1) {
							list.add("Result not announced");
						}else {
							list.add("Result announced");
						}
						model.addRow(list.toArray());
					}
					if(model.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No record found");
					}
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}

	public static DefaultTableModel refreshReport() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		table.setRowHeight(40);
		String []head= {"serial","Userame","Department","Semester","Subject-1","Total Practical","Total Written","Subject-2","Total Practical","Total Written","Subject-3","Total Practical","Total Written","Subject-4","Total Practical","Total Written","Status"};
		model.setColumnIdentifiers(head);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(16).setPreferredWidth(150);
		try {
			Connection con=Connector.connect();
			String query="select * from result order by sl";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			ArrayList list=new ArrayList();
			while(rs.next()) {
				list.removeAll(list);
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(9));
				list.add(rs.getInt(5));
				list.add(rs.getInt(7));
				list.add(rs.getString(14));
				list.add(rs.getInt(10));
				list.add(rs.getInt(12));
				list.add(rs.getString(19));
				list.add(rs.getInt(15));
				list.add(rs.getInt(17));
				list.add(rs.getString(24));
				list.add(rs.getInt(20));
				list.add(rs.getInt(22));
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
