package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePickerImpl;

import ConnectionPackage.Connector;
import Method.Method;
import Method.TotalCount;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class InsertNotice extends JDialog {
	static String dobInput=null;
	private JTextField memoField1;
	private JTextField memoField2;
	private JTextField titleField;
	/**
	 * Create the dialog.
	 */
	public InsertNotice(DefaultTableModel model) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		
		setBounds(300, 100, 591, 441);
		getContentPane().setLayout(null);
		
		Method method=new Method();
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 591, 441);
		getContentPane().add(Background);
		ImageIcon icon=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon, 591, 441, Background);

		
		JLabel lblNewLabel = new JLabel("NOTICE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(252, 11, 94, 14);
		Background.add(lblNewLabel);
		JDatePickerImpl datePicker=Method.datePicker();
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dobInput=datePicker.getJFormattedTextField().getText();
			}
		});
		datePicker.setFocusable(false);
		datePicker.setBounds(427, 43, 107, 19);
		datePicker.setBorder(new LineBorder(Color.black,1));
		Background.add(datePicker);
		
		JLabel memoLabel = new JLabel("Memo No");
		memoLabel.setForeground(Color.WHITE);
		memoLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		memoLabel.setBounds(23, 43, 74, 19);
		Background.add(memoLabel);
		
		JTextArea noticeBoard = new JTextArea();
		noticeBoard.setBounds(23, 115, 530, 187);
		Background.add(noticeBoard);
		
		memoField1 = new JTextField();
		memoField1.setEditable(false);
		memoField1.setText("SNC");
		memoField1.setBounds(104, 44, 37, 20);
		Background.add(memoField1);
		memoField1.setColumns(10);
		
		memoField2 = new JTextField();
		memoField2.setColumns(10);
		memoField2.setBounds(151, 44, 47, 20);
		Background.add(memoField2);
		
		try {
			Connection con=Connector.connect();
			String sql="select max(sl) from notice";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				memoField2.setText(""+(rs.getInt(1)+1));
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JButton generate = new JButton("Notice Generate");
		generate.setBackground(SystemColor.activeCaption);
		generate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		generate.setBounds(37, 368, 229, 23);
		Background.add(generate);
		String str[]={"student","faculty","all"};
		JComboBox comboBox = new JComboBox(str);
		comboBox.setBounds(151, 313, 402, 23);
		Background.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Notice For?");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(23, 313, 111, 23);
		Background.add(lblNewLabel_1);
		
		JButton reset = new JButton("Reset");
		reset.setBackground(SystemColor.activeCaption);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noticeBoard.setText("");
				memoField2.setText("");
				titleField.setText("");
			}
		});
		reset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reset.setBounds(324, 368, 229, 23);
		Background.add(reset);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(23, 73, 47, 23);
		Background.add(lblNewLabel_2);
		
		titleField = new JTextField();
		titleField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleField.setBounds(71, 76, 482, 28);
		Background.add(titleField);
		titleField.setColumns(10);
		
		
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(datePicker.getJFormattedTextField().getText().equals("")||memoField2.getText().equals("")||noticeBoard.getText().equals("")||titleField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill all the Field","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					String memo=memoField1.getText()+"/"+memoField2.getText();
					try {
						Connection con=Connector.connect();
						String query="Insert into notice(title,Notice,ack,date,memo) values(?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, titleField.getText());
						ps.setString(2,noticeBoard.getText());
						ps.setString(3, comboBox.getSelectedItem().toString());
						ps.setString(4, dobInput);
						ps.setString(5, memo);
						ps.executeUpdate();
						setVisible(false);
						con.close();
						JOptionPane.showMessageDialog(null, "Notice Generated");
						model.setRowCount(0);
						AdminNotice.refreshTable();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Notice not Generated");
						e1.printStackTrace();
					}
				}
				
				
			}
		});
	}
}
