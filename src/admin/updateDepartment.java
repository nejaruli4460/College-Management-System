package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;
import Method.Validation;

import java.awt.Dialog.ModalityType;
import java.awt.SystemColor;

public class updateDepartment extends JDialog {

	private final JPanel contentPanel = new JPanel();



	/**
	 * Create the dialog.
	 * @param <JDefultTableModel>
	 */
	public updateDepartment(JTable table,DefaultTableModel model) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModal(true);
		setTitle("Update Deparment");
		
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		setBounds(406, 120, 410, 389);
//		setBorder(new LineBorder(Color.gray,3));
		getContentPane().setLayout(null);
		
		JLabel background = new JLabel("");
		background.setBackground(Color.WHITE);
		background.setBounds(0, 0, 394, 350);
		getContentPane().add(background);
		ImageIcon icon=new ImageIcon(".//asset//uperBack.jpg");
		Method method=new Method();
		method.resizeImage(icon, 394, 350, background);
		
		JLabel departmentLabel = new JLabel("Department Code");
		departmentLabel.setForeground(Color.WHITE);
		departmentLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		departmentLabel.setBounds(10, 39, 128, 25);
		background.add(departmentLabel);
		
		JLabel departmentName = new JLabel("Department Name");
		departmentName.setForeground(Color.WHITE);
		departmentName.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		departmentName.setBounds(10, 92, 128, 25);
		background.add(departmentName);
		
		JTextArea dname = new JTextArea();
		dname.setFont(new Font("Monospaced", Font.PLAIN, 15));
		dname.setBackground(Color.WHITE);
		dname.setBounds(148, 93, 199, 25);
//		dname.setText(dn);
		background.add(dname);
		
		JTextArea dcode = new JTextArea();
//		dcode.setEditable(false);
//		dcode.setText(dc);
		dcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			dcode.setText(dcode.getText().toUpperCase());
			}
		});
		dcode.setFont(new Font("Monospaced", Font.PLAIN, 15));
		dcode.setTabSize(9);
		dcode.setBackground(Color.WHITE);
		dcode.setBounds(148, 40, 199, 25);
		background.add(dcode);
		dcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			dcode.setText(dcode.getText().toUpperCase());
			}
		});
		
		JLabel lblDepartmentType = new JLabel("Department Type");
		lblDepartmentType.setForeground(Color.WHITE);
		lblDepartmentType.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lblDepartmentType.setBounds(10, 148, 128, 25);
		background.add(lblDepartmentType);
		
		JTextArea typeArea = new JTextArea();
		typeArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
//		typeArea.setText(dt);
		typeArea.setBackground(Color.WHITE);
		typeArea.setBounds(148, 149, 199, 25);
		background.add(typeArea);
		typeArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			typeArea.setText(typeArea.getText().toUpperCase());
			}
		});
		
		JLabel Seat = new JLabel("Number of Seat");
		Seat.setForeground(Color.WHITE);
		Seat.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		Seat.setBounds(10, 203, 128, 25);
//		Seat.setText(st);
		background.add(Seat);
		JTextArea seatArea = new JTextArea();
		seatArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		seatArea.setBackground(Color.WHITE);
		seatArea.setBounds(148, 204, 199, 25);
		background.add(seatArea);
		seatArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			seatArea.setText(seatArea.getText().toUpperCase());
			}
		});
		JButton updateButton = new JButton("UPDATE");
		updateButton.setBackground(SystemColor.activeCaption);
		if(table!=null||model!=null) {
			int rowIndex=table.getSelectedRow();
			String dc=model.getValueAt(rowIndex, 1).toString();
			String dn=model.getValueAt(rowIndex, 2).toString();
			String dt=model.getValueAt(rowIndex, 3).toString();
			String st=model.getValueAt(rowIndex, 4).toString();
				seatArea.setText(st);
				typeArea.setText(dt);
				dcode.setText(dc);
				dname.setText(dn);
		}
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Validation.departmentValid(dcode.getText(),dname.getText(),seatArea.getText())==false) {
					
				}
				else {
				try {
//					int seat=Integer.parseInt(st);
					Connection con=Connector.connect();
					String query="Update Department set d_name=?,d_type=?,seat=? where d_code=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, dname.getText());
					ps.setString(2, typeArea.getText());
					ps.setInt(3,Integer.parseInt(seatArea.getText()) );
					ps.setString(4, dcode.getText());
					ps.executeUpdate();
					con.close();
					setVisible(false);
					JOptionPane.showMessageDialog(null,"Updated Successfully");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Updation not done",JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				}
				
				model.setRowCount(0);
				Department.refreshTable();
			}
		});
		updateButton.setBounds(74, 277, 89, 23);
		background.add(updateButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setBackground(SystemColor.activeCaption);
		resetButton.setFocusable(false);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dname.setText("");
				dcode.setText("");
				typeArea.setText("");
				seatArea.setText("");
			}
		});
		resetButton.setBounds(208, 277, 89, 23);
		background.add(resetButton);
		
		

	}

	}


