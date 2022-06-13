package admin;

import java.awt.BorderLayout;
import Method.Validation;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import Method.Method;

import java.awt.Dialog.ModalityType;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class insertDepartment extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Nejarul Islam.
	 * Roll No.193115-21-0053
	 * nejarulislam45@gmail.com
	 */
	
	public insertDepartment(DefaultTableModel model) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\asset\\logo.jpg"));
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModal(true);
		setTitle("Insert Department");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		JPanel panel = new JPanel();
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		setBounds(406, 59, 410, 389);
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
		dname.setForeground(Color.BLACK);
		dname.setFont(new Font("Monospaced", Font.PLAIN, 15));
		dname.setBackground(Color.WHITE);
		dname.setBounds(148, 93, 199, 25);
		background.add(dname);
		dname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			dname.setText(dname.getText().toUpperCase());
			}
		});
		
		JTextArea dcode = new JTextArea();
		dcode.setForeground(Color.BLACK);
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
		
		JLabel lblDepartmentType = new JLabel("Department Type");
		lblDepartmentType.setForeground(Color.WHITE);
		lblDepartmentType.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lblDepartmentType.setBounds(10, 148, 128, 25);
		background.add(lblDepartmentType);
		
		JLabel Seat = new JLabel("Number of Seat");
		Seat.setForeground(Color.WHITE);
		Seat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Seat.setBounds(10, 203, 128, 25);
		background.add(Seat);
		
		JTextArea seatArea = new JTextArea();
		seatArea.setForeground(Color.BLACK);
		seatArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		seatArea.setBackground(Color.WHITE);
		seatArea.setBounds(148, 204, 199, 25);
		background.add(seatArea);
		String item[]={"HONOURS","GENERAL"};
		JComboBox typeArea = new JComboBox(item) ;
		typeArea.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		typeArea.setForeground(Color.BLACK);
		typeArea.setBackground(Color.WHITE);
		typeArea.setBounds(151, 147, 195, 25);
		background.add(typeArea);
		
		seatArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			seatArea.setText(seatArea.getText().toUpperCase());
			}
		});
		JButton insertButton = new JButton("INSERT");
		insertButton.setForeground(Color.BLACK);
		insertButton.setBackground(SystemColor.activeCaption);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Validation.departmentValid(dcode.getText(),dname.getText(),seatArea.getText())==false) {
					
				}
				else {
				try {
					Connection con=Connector.connect();
					String query="insert into department(d_code,d_name,d_type,seat) values(?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
//					ps.setInt(1,(Integer) null);
					ps.setString(1, dcode.getText());
					ps.setString(2, dname.getText());
					ps.setString(3, typeArea.getSelectedItem().toString());
					ps.setInt(4, Integer.parseInt(seatArea.getText()));
					ps.executeUpdate();
					con.close();
					setVisible(false);
					JOptionPane.showMessageDialog(null,"Inserted Successfully");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Insertion not done",JOptionPane.ERROR_MESSAGE);
				}
				
				}
				
				model.setRowCount(0);
				Department.refreshTable();
			}
		});
		insertButton.setBounds(74, 277, 89, 23);
		background.add(insertButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setForeground(Color.BLACK);
		resetButton.setBackground(SystemColor.activeCaption);
		resetButton.setFocusable(false);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dname.setText("");
				dcode.setText("");
				seatArea.setText("");
			}
		});
		resetButton.setBounds(208, 277, 89, 23);
		background.add(resetButton);
		
		
		
		

	}
}
