package student;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import ConnectionPackage.Connector;
import Method.Method;
import java.awt.Color;

public class NoticeShow extends JDialog {


	/**
	 * Create the dialog.
	 */
	public NoticeShow(String memo) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
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
		
		JLabel date = new JLabel();
		date.setForeground(Color.WHITE);
		date.setBounds(427, 43, 107, 19);
		Background.add(date);
		
		JLabel memoLabel = new JLabel();
		memoLabel.setForeground(Color.WHITE);
		memoLabel.setText(memo);
		memoLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		memoLabel.setBounds(23, 43, 107, 19);
		Background.add(memoLabel);
		
		JTextArea noticeBoard = new JTextArea();
//		noticeBoard.setEnabled(false);
		noticeBoard.setEditable(false);
		noticeBoard.setBounds(23, 101, 530, 201);
		Background.add(noticeBoard);
		
		try {
			Connection con=Connector.connect();
			String sql="select date,notice from notice where memo=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, memo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				noticeBoard.setText(rs.getString(2));
				date.setText("dated: "+rs.getString(1));
			}
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
