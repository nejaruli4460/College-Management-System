package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ConnectionPackage.Connector;
import Method.Method;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetFees extends JDialog {
	private JTextField labFee;
	private JTextField tutionFee;



	/**
	 * Create the dialog.
	 */
	public SetFees(DefaultTableModel model) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModal(true);
		setTitle("Set Fees");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		JPanel panel = new JPanel();
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		setBounds(406, 59, 410, 313);
		getContentPane().setLayout(null);
		
		Method method=new Method();
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 410, 313);
		getContentPane().add(Background);
		ImageIcon icon=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon, 410, 313, Background);
		
		JLabel lblNewLabel = new JLabel("Department");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 37, 77, 26);
		Background.add(lblNewLabel);
		ArrayList list=new ArrayList();
		try {
			Connection con=Connector.connect();
			String sql="select d_code from department";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JComboBox comboBox = new JComboBox(list.toArray());
		comboBox.setBounds(104, 41, 269, 22);
		Background.add(comboBox);
		
		JLabel lblLabFee = new JLabel("Lab Fee");
		lblLabFee.setForeground(Color.WHITE);
		lblLabFee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblLabFee.setBounds(10, 102, 77, 26);
		Background.add(lblLabFee);
		
		labFee = new JTextField();
		labFee.setBounds(104, 93, 269, 26);
		Background.add(labFee);
		labFee.setColumns(10);
		
		JLabel lblTutionFee = new JLabel("Tution Fee");
		lblTutionFee.setForeground(Color.WHITE);
		lblTutionFee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTutionFee.setBounds(10, 163, 77, 26);
		Background.add(lblTutionFee);
		
		tutionFee = new JTextField();
		tutionFee.setColumns(10);
		tutionFee.setBounds(104, 163, 269, 26);
		Background.add(tutionFee);
		
		JButton btnSetFees = new JButton("Set Fees");
		btnSetFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(labFee.getText().equals("")||tutionFee.getText().equals("")) {
					
				}else {
					if(tableCheck(comboBox.getSelectedItem().toString())) {
						try {
							Connection con=Connector.connect();
							String q="update fees set lab=?,tution=? where department=?";
							PreparedStatement ps=con.prepareStatement(q);
							ps.setInt(1, Integer.parseInt(labFee.getText()));
							ps.setInt(2, Integer.parseInt(tutionFee.getText()));
							ps.setString(3, comboBox.getSelectedItem().toString());
							ps.executeUpdate();
					
						
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Updated");
							model.setRowCount(0);
							Fees.refreshTable();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						try {
							Connection con=Connector.connect();
							String q="insert into fees(lab,tution,department) values(?,?,?)";
							PreparedStatement ps=con.prepareStatement(q);
							ps.setInt(1, Integer.parseInt(labFee.getText()));
							ps.setInt(2, Integer.parseInt(tutionFee.getText()));
							ps.setString(3, comboBox.getSelectedItem().toString());
							ps.executeUpdate();
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Inserted");
							model.setRowCount(0);
							Fees.refreshTable();
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSetFees.setFocusable(false);
		btnSetFees.setBackground(SystemColor.activeCaption);
		btnSetFees.setBounds(141, 226, 89, 23);
		Background.add(btnSetFees);

	}
	public boolean tableCheck(String str) {
		boolean flag=false;
		try {
			Connection con=Connector.connect();
			String sql="select count(*) from fees where department=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, str);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					flag=true;
				}else {
					flag=false;
				}
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
}
