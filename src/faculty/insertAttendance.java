package faculty;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Table;

import ConnectionPackage.Connector;
import Method.Method;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class insertAttendance extends JPanel {
	private JTable table;
	private JPanel panel = new JPanel();

	/**
	 * Nejarul Islam
	 * mail id:nejarulislam45@gmail.com
	 */
	public insertAttendance(int sl) {
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
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(6);
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SEMESTER 1", "SEMESTER 2", "SEMESTER 3", "SEMESTER 4", "SEMESTER 5", "SEMESTER 6"}));
		comboBox.setBounds(112, 38, 756, 22);
		upperBackground.add(comboBox);
		panel.setBounds(0, 200, 1262, 483);
		add(panel);
		
		panel.setLayout(null);
//		panel.setVisible(false);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 25, 1262, 403);
//		panel.add(scrollPane);
		
		JButton attendanceSubmit = new JButton("SUBMIT ATTENDANCE");
		attendanceSubmit.setBackground(SystemColor.activeCaption);
		attendanceSubmit.setBounds(993, 437, 177, 23);
		
		String head[]= {"Serial","Name","Semester","Attendance"};
		panel.add(scrollPane);
		panel.add(attendanceSubmit);
		
		
		
//		table = new JTable();
		
		
		JButton studentSubmit = new JButton("SUBMIT");
		studentSubmit.setBackground(SystemColor.activeCaption);
		upperBackground.add(studentSubmit);
		studentSubmit.setBounds(902, 36, 89, 23);
		
		studentSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String combo=comboBox.getSelectedItem().toString();
				int n=JOptionPane.showConfirmDialog(null, "Are you sure take attendance for"+combo);
				System.out.println(n);
				if(n==1||n==2)
					return;
				else
				try {
					Connection con = Connector.connect();
					String query="Update attendance set Total=(Total+1) where semester =? and department=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, comboBox.getSelectedItem().toString());
					ps.setString(2,Method.facultyDepartmentNameBySerial(sl));
					ps.executeUpdate();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				Object data[][]=addTable(comboBox.getSelectedItem().toString(),sl);
				DefaultTableModel model=new DefaultTableModel(data,head);
				
					table = new JTable(model) {
					      public Class getColumnClass(int column) {
					        return getValueAt(0, column).getClass();
					      }
					    };
					   
						scrollPane.setViewportView(table);
						table.getTableHeader().setBackground(SystemColor.activeCaption);
						table.setRowHeight(40);
						table.getColumnModel().getColumn(0).setPreferredWidth(30);
						table.getColumnModel().getColumn(3).setPreferredWidth(30);
						attendanceSubmit.addActionListener(new ActionListener() {
			
							public void actionPerformed(ActionEvent e) {
								
								
//								System.out.println(model.getValueAt(1, 3));
								System.out.println(model.getRowCount());
								int row=model.getRowCount();
								int i=0;
								int flag=0;
								while(row!=0) {
									Object serial=model.getValueAt(i, 0);
									if((boolean) model.getValueAt(i,3)) {
										model.setValueAt(false, i,3);
										try {
											Connection con=Connector.connect();
											String sql="Update attendance set attend=(attend+1) where serial=? and department=?";
											PreparedStatement ps=con.prepareStatement(sql);
											ps.setInt(1, (int) serial);
											ps.setString(2,Method.facultyDepartmentNameBySerial(sl));
											ps.executeUpdate();
											con.close();
											flag=1;
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
											JOptionPane.showMessageDialog(null, "Some went wrong");
										}
									}
									row--;
									i++;
									
								}
								if(flag==1) {
									JOptionPane.showMessageDialog(null, "Attendance Updated Successfully");
								}
							}
							
						});
						
				}


			
		});
					


		
		

	}
	private Object[][] addTable(String string,int sl) {
//	DefaultTableModel model=(DefaultTableModel) table.getModel();
//	table.getTableHeader().setBackground(Color.cyan);
		try {
			Connection con=Connector.connect();
			String sql="select * from attendance  where semester=? and department=?  order by serial";
			String count="Select count(*) as rowcount from attendance where semester=? and department=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,string);
			ps.setString(2, Method.facultyDepartmentNameBySerial(sl));
			PreparedStatement co=con.prepareStatement(count);
			co.setString(1, string);
			co.setString(2, Method.facultyDepartmentNameBySerial(sl));
			ResultSet c=co.executeQuery();
			c.next();
			int count1=c.getInt(1);
			ResultSet rs=ps.executeQuery();
			ArrayList list=new ArrayList();
			Object arr[][]= new Object[count1][4];
			int i=0;
			while(rs.next()) {
				arr[i][0]=rs.getInt(1);
				arr[i][1]=rs.getString(2);
				arr[i][2]=rs.getString(3);
				arr[i][3]=false;
				i++;
//				model.addRow(list.toArray());
			}
			con.close();
			return arr;
			
	
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
}
}
