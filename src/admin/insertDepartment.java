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

public class insertDepartment extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			insertDepartment dialog = new insertDepartment(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public insertDepartment(DefaultTableModel model) {
		setTitle("Insert Department");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		JPanel panel = new JPanel();
		setBackground(Color.WHITE);
		setForeground(Color.DARK_GRAY);
		setBounds(406, 59, 410, 389);
		getContentPane().setLayout(null);
		
		JLabel departmentLabel = new JLabel("Department Code");
		departmentLabel.setForeground(Color.GRAY);
		departmentLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		departmentLabel.setBounds(10, 39, 128, 25);
		getContentPane().add(departmentLabel);

		
		JLabel departmentName = new JLabel("Department Name");
		departmentName.setForeground(Color.GRAY);
		departmentName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		departmentName.setBounds(10, 92, 128, 25);
		getContentPane().add(departmentName);
		
		JTextArea dname = new JTextArea();
		dname.setFont(new Font("Monospaced", Font.PLAIN, 15));
		dname.setBackground(Color.LIGHT_GRAY);
		dname.setBounds(148, 93, 199, 25);
		getContentPane().add(dname);
		dname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			dname.setText(dname.getText().toUpperCase());
			}
		});
		
		JTextArea dcode = new JTextArea();
		dcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			dcode.setText(dcode.getText().toUpperCase());
			}
		});
		dcode.setFont(new Font("Monospaced", Font.PLAIN, 15));
		dcode.setTabSize(9);
		dcode.setBackground(Color.LIGHT_GRAY);
		dcode.setBounds(148, 40, 199, 25);
		getContentPane().add(dcode);
		
		JLabel lblDepartmentType = new JLabel("Department Type");
		lblDepartmentType.setForeground(Color.GRAY);
		lblDepartmentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepartmentType.setBounds(10, 148, 128, 25);
		getContentPane().add(lblDepartmentType);
		
		JTextArea typeArea = new JTextArea();
		typeArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		typeArea.setBackground(Color.LIGHT_GRAY);
		typeArea.setBounds(148, 149, 199, 25);
		getContentPane().add(typeArea);
		typeArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			typeArea.setText(typeArea.getText().toUpperCase());
			}
		});
		
		JLabel Seat = new JLabel("Number of Seat");
		Seat.setForeground(Color.GRAY);
		Seat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Seat.setBounds(10, 203, 128, 25);
		getContentPane().add(Seat);
		
		JTextArea seatArea = new JTextArea();
		seatArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		seatArea.setBackground(Color.LIGHT_GRAY);
		seatArea.setBounds(148, 204, 199, 25);
		getContentPane().add(seatArea);
		
		seatArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			seatArea.setText(seatArea.getText().toUpperCase());
			}
		});
		JButton insertButton = new JButton("INSERT");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dcode.getText().isEmpty()||dname.getText().isEmpty()||typeArea.getText().isEmpty()||seatArea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the field..","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
				try {
					Connection con=Connector.connect();
					String query="insert into department(d_code,d_name,d_type,seat) values(?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
//					ps.setInt(1,(Integer) null);
					ps.setString(1, dcode.getText());
					ps.setString(2, dname.getText());
					ps.setString(3, typeArea.getText());
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
		getContentPane().add(insertButton);
		
		JButton resetButton = new JButton("RESET");
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
		getContentPane().add(resetButton);

	}

}
