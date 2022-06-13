package admin;

import java.awt.BorderLayout;
import ConnectionPackage.Connector;
import Method.Method;

import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class SetSubject extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField sub1;
	private JTextField sub2;
	private JTextField sub3;
	private JTextField sub4;
	private JTextField sub4p;
	private JTextField sub4w;
	private JTextField sub3w;
	private JTextField sub3p;
	private JTextField sub2w;
	private JTextField sub2p;
	private JTextField sub1w;
	private JTextField sub1p;

	/**
	 * Launch the application.
	 */
	public SetSubject(DefaultTableModel model,JTable table) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModal(true);
		
		
		
		setBounds(250, 0, 550, 697);
		Method method=new Method();
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 550, 697);
		getContentPane().add(Background);
		ImageIcon icon=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon, 550, 697, Background);
		getContentPane().setLayout(null);
		String comboItem[]= {"SEMESTER 1","SEMESTER 2","SEMESTER 3","SEMESTER 4","SEMESTER 5","SEMESTER 6"};
		JComboBox comboBox = new JComboBox(comboItem);
		comboBox.setBounds(127, 68, 347, 22);
		Background.add(comboBox);
		
		int row=table.getSelectedRow();
//		comboBox.setSelectedItem(model.getValueAt(row, 3).toString());
		
		JLabel lblNewLabel = new JLabel("Semester");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 65, 97, 22);
		Background.add(lblNewLabel);
		
		JLabel lblSubject = new JLabel("Subject-1");
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject.setBounds(28, 134, 89, 22);
		Background.add(lblSubject);
		
		JLabel lblSubject_2lebel = new JLabel("Subject-2");
		lblSubject_2lebel.setForeground(Color.WHITE);
		lblSubject_2lebel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject_2lebel.setBounds(20, 256, 89, 22);
		Background.add(lblSubject_2lebel);
		
		JLabel lblSubject_2 = new JLabel("Subject-3");
		lblSubject_2.setForeground(Color.WHITE);
		lblSubject_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject_2.setBounds(20, 365, 89, 22);
		Background.add(lblSubject_2);
		
		JLabel lblSubject_3 = new JLabel("Subject-4");
		lblSubject_3.setForeground(Color.WHITE);
		lblSubject_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject_3.setBounds(20, 482, 97, 22);
		Background.add(lblSubject_3);
		
		sub1 = new JTextField();
		sub1.setBounds(127, 138, 347, 20);
		Background.add(sub1);
		sub1.setColumns(10);
		
		sub2 = new JTextField();
		sub2.setColumns(10);
		sub2.setBounds(127, 258, 347, 20);
		Background.add(sub2);
		
		sub3 = new JTextField();
		sub3.setColumns(10);
		sub3.setBounds(127, 369, 347, 20);
		Background.add(sub3);
		
		sub4 = new JTextField();
		sub4.setColumns(10);
		sub4.setBounds(127, 486, 347, 20);
		Background.add(sub4);
		
		JButton subjectSet = new JButton("SUBJECT  AND TOTAL SET");
		subjectSet.setBackground(SystemColor.activeCaption);
		
		subjectSet.setBounds(35, 625, 461, 22);
		subjectSet.setFocusable(false);
		Background.add(subjectSet);
		
		JLabel lblSubject_3_1 = new JLabel("Total Practical ");
		lblSubject_3_1.setForeground(Color.WHITE);
		lblSubject_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubject_3_1.setBounds(20, 526, 97, 22);
		Background.add(lblSubject_3_1);
		
		sub4p = new JTextField();
		sub4p.setText("30");
		sub4p.setColumns(10);
		sub4p.setBounds(127, 529, 347, 20);
		Background.add(sub4p);
		
		JLabel lblSubject_3_1_1 = new JLabel("Total Written");
		lblSubject_3_1_1.setForeground(Color.WHITE);
		lblSubject_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubject_3_1_1.setBounds(20, 572, 97, 22);
		Background.add(lblSubject_3_1_1);
		
		sub4w = new JTextField();
		sub4w.setText("70");
		sub4w.setColumns(10);
		sub4w.setBounds(127, 575, 347, 20);
		Background.add(sub4w);
		
		JLabel lblSubject_3_1_1_1 = new JLabel("Total Written");
		lblSubject_3_1_1_1.setForeground(Color.WHITE);
		lblSubject_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubject_3_1_1_1.setBounds(20, 449, 97, 22);
		Background.add(lblSubject_3_1_1_1);
		
		sub3w = new JTextField();
		sub3w.setText("70");
		sub3w.setColumns(10);
		sub3w.setBounds(127, 452, 347, 20);
		Background.add(sub3w);
		
		JLabel lblSubject_3_1_2 = new JLabel("Total Practical ");
		lblSubject_3_1_2.setForeground(Color.WHITE);
		lblSubject_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubject_3_1_2.setBounds(20, 409, 97, 22);
		Background.add(lblSubject_3_1_2);
		
		sub3p = new JTextField();
		sub3p.setText("30");
		sub3p.setColumns(10);
		sub3p.setBounds(127, 412, 347, 20);
		Background.add(sub3p);
		
		sub2w = new JTextField();
		sub2w.setText("70");
		sub2w.setColumns(10);
		sub2w.setBounds(127, 338, 347, 20);
		Background.add(sub2w);
		
		JLabel lblSubject2tw = new JLabel("Total Written");
		lblSubject2tw.setForeground(Color.WHITE);
		lblSubject2tw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubject2tw.setBounds(20, 340, 97, 22);
		Background.add(lblSubject2tw);
		
		sub2p = new JTextField();
		sub2p.setText("30");
		sub2p.setColumns(10);
		sub2p.setBounds(127, 298, 347, 20);
		Background.add(sub2p);
		
		JLabel lblSubject2tp = new JLabel("Total Practical ");
		lblSubject2tp.setForeground(Color.WHITE);
		lblSubject2tp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubject2tp.setBounds(20, 299, 97, 22);
		Background.add(lblSubject2tp);
		
		sub1w = new JTextField();
		sub1w.setText("70");
		sub1w.setColumns(10);
		sub1w.setBounds(127, 224, 347, 20);
		Background.add(sub1w);
		
		JLabel lblSubject1tw = new JLabel("Total Written");
		lblSubject1tw.setForeground(Color.WHITE);
		lblSubject1tw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubject1tw.setBounds(20, 224, 97, 22);
		Background.add(lblSubject1tw);
		
		JLabel sub1TotalLebel = new JLabel("Total Practical ");
		sub1TotalLebel.setForeground(Color.WHITE);
		sub1TotalLebel.setBackground(Color.WHITE);
		sub1TotalLebel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sub1TotalLebel.setBounds(20, 179, 97, 22);
		Background.add(sub1TotalLebel);
		
		sub1p = new JTextField();
		sub1p.setText("30");
		sub1p.setColumns(10);
		sub1p.setBounds(127, 182, 347, 20);
		Background.add(sub1p);
		
		JLabel lblSetSubjectAlong = new JLabel("Set Subject Along With Total Marks");
		lblSetSubjectAlong.setForeground(Color.WHITE);
		lblSetSubjectAlong.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblSetSubjectAlong.setBounds(123, 11, 298, 22);
		Background.add(lblSetSubjectAlong);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartment.setBounds(20, 101, 97, 22);
		Background.add(lblDepartment);
		
		ArrayList list=new ArrayList();
		try {
			Connection con=Connector.connect();
			String query="select d_code from department";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JComboBox departmentCombo = new JComboBox(list.toArray());
		departmentCombo.setBounds(127, 101, 347, 22);
		Background.add(departmentCombo);
		
		subjectSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sub1.getText().equals("")||sub2.getText().equals("")||sub3.getText().equals("")||sub4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fil all the field","error",JOptionPane.ERROR_MESSAGE);
				}else {
				try {
					Connection con=Connector.connect();
					String query="Update result set subonename=?,subtwoname=?,subthreename=?,subfourname=?,subonepracticaltotal=?,subonewrittentotal=?,subtwopracticaltotal=?,subtwowrittentotal=?,subthreepracticaltotal=?,subthreewrittentotal=?,subfourpracticaltotal=?,subfourwrittentotal=? where semester=? and department=?" ;
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, sub1.getText());
					ps.setString(2, sub2.getText());
					ps.setString(3, sub3.getText());
					ps.setString(4, sub4.getText());
					ps.setInt(5,Integer.parseInt(sub1p.getText()));
					ps.setInt(6,Integer.parseInt(sub1w.getText()));
					ps.setInt(7,Integer.parseInt(sub2p.getText()));
					ps.setInt(8,Integer.parseInt(sub2w.getText()));
					ps.setInt(9,Integer.parseInt(sub3p.getText()));
					ps.setInt(10,Integer.parseInt(sub3w.getText()));
					ps.setInt(11,Integer.parseInt(sub4p.getText()));
					ps.setInt(12,Integer.parseInt(sub4w.getText()));
					ps.setString(13, comboBox.getSelectedItem().toString());
					ps.setString(14, departmentCombo.getSelectedItem().toString());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Updated");
					setVisible(false);
					model.setRowCount(0);
					MarksheetReport.refreshReport();
			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
	}
}
