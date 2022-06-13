package student;

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
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;
import faculty.Notice;

public class StudentNotice extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public StudentNotice(int serial) {
		setBounds(0,0,1301,683);
		setLayout(null);
		Method method=new Method();
		JLabel upperBackground = new JLabel("");
		upperBackground.setBackground(SystemColor.activeCaption);
		upperBackground.setForeground(Color.GRAY);
		ImageIcon image=new ImageIcon(".\\asset\\uperBack.jpg");
	
		method.resizeImage(image,1300,283,upperBackground);
		upperBackground.setBounds(0, 0, 1301, 283);
		add(upperBackground);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 283, 1215, 400);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBackground(SystemColor.activeCaption);
		refreshButton.setBounds(1100, 249, 89, 23);
		refreshButton.setFocusable(false);
		upperBackground.add(refreshButton);
		
		JButton showButton = new JButton("Show");
		showButton.setBackground(SystemColor.activeCaption);
		showButton.setBounds(993, 248, 89, 23);
		showButton.setFocusable(false);
		upperBackground.add(showButton);
		
		JLabel lblNewLabel = new JLabel("NOTICE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 52));
		lblNewLabel.setBounds(502, 59, 189, 73);
		upperBackground.add(lblNewLabel);
		DefaultTableModel model=refreshRoutine(serial);
		refreshButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				refreshRoutine(serial);
				
			}
		
			
		});
		showButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No row selected","Wrong ",JOptionPane.WARNING_MESSAGE);
				}else {
				int row=table.getSelectedRow();
				String memo=model.getValueAt(row, 0).toString();
				NoticeShow notice=new NoticeShow(memo);
				notice.setVisible(true);
				}
				
			}
		
			
		});
	
	}
	public DefaultTableModel refreshRoutine(int serial) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		String []head= {"Memo","Title","Date"};
		model.setColumnIdentifiers(head);
		
		table.getTableHeader().setBackground(SystemColor.activeCaption);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(700);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.setRowHeight(40);
		try {
			Connection con=Connector.connect();
			String query="select memo,title,date from notice where ack='student' or ack='all' or ack=(select name from student where serial=?)  order by sl desc";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, serial);
			ResultSet rs=stmt.executeQuery();
			ArrayList list=new ArrayList();
			while(rs.next()) {
				list.removeAll(list);
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
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


