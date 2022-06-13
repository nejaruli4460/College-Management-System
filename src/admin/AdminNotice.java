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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;

public class AdminNotice extends JPanel {
	private static JTable table;
	/**
	 * Create the panel.
	 */
	public AdminNotice() {
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
						String sql="delete from notice where sl=?";
						
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
					UpdateNotice notice=new UpdateNotice(table,model);
					notice.setVisible(true);
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
				InsertNotice notice=new InsertNotice(model);
				notice.setVisible(true);
				model.setRowCount(0);
				refreshTable();
			}
		});
		Insert.setBounds(829, 166, 89, 23);
		upperBackground.add(Insert);
	
	
	}

	public static DefaultTableModel refreshTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		String head[]= {"Title","Notice","Notice For","Date","Memo"};
		model.setColumnIdentifiers(head);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		try {
			Connection con=Connector.connect();
			String q="select * from notice order by sl desc";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			ArrayList list=new ArrayList();
			while(rs.next()) {
				list.removeAll(list);
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				model.addRow(list.toArray());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

}


