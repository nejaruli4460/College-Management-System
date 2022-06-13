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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Fees extends JPanel {
	private static JTable table;

	/**
	 * Create the panel.
	 */
	public Fees() {
		setBounds(0,0,1301,683);
		setLayout(null);
		Method method=new Method();
		JLabel upperBackground = new JLabel("");
		upperBackground.setBackground(SystemColor.activeCaption);
		upperBackground.setForeground(Color.GRAY);
		ImageIcon image=new ImageIcon(".\\asset\\uperBack.jpg");
	
		method.resizeImage(image,1300,382,upperBackground);
		upperBackground.setBounds(0, 0, 1301, 200);
		upperBackground.setBorder(new LineBorder(Color.black,2));
		add(upperBackground);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 199, 1228, 484);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model=refreshTable();
		JButton btnSetFees = new JButton("Set Fees");
		btnSetFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetFees dialog = new SetFees(model);
				dialog.setVisible(true);
			}
		});
		btnSetFees.setFocusable(false);
		btnSetFees.setBackground(SystemColor.activeCaption);
		btnSetFees.setBounds(1026, 165, 89, 23);
		upperBackground.add(btnSetFees);
		
		JButton btnRefresh = new JButton("Refresh");
		upperBackground.add(btnRefresh);
		btnRefresh.setFocusable(false);
		btnRefresh.setBackground(SystemColor.activeCaption);
		btnRefresh.setBounds(1126, 164, 89, 23);
		
		JButton btnDeleteRow = new JButton("Delete Row");
		btnDeleteRow.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnDeleteRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				int serial=Integer.parseInt(model.getValueAt(row,0).toString());
				try {
					Connection con=Connector.connect();
					String q="delete from fees where sl=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1,serial);
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Deleted");
					model.setRowCount(0);
					refreshTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDeleteRow.setFocusable(false);
		btnDeleteRow.setBackground(SystemColor.activeCaption);
		btnDeleteRow.setBounds(923, 165, 95, 23);
		upperBackground.add(btnDeleteRow);
		

		btnRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);;
				refreshTable();
			}
			
		});
	}
	public static DefaultTableModel refreshTable() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		String head[]={"Serial","Department Name","Lab Fees","Tution Fees"};
		model.setColumnIdentifiers(head);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.setRowHeight(40);
		try {
			Connection con=Connector.connect();
			String sql="select * from fees order by sl";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			ArrayList list=new ArrayList();
			while(rs.next()) {
				list.removeAll(list);
				list.add(rs.getInt(1));
				list.add(rs.getString(2));
				list.add(rs.getInt(3));
				list.add(rs.getInt(4));
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
