package student;

import java.awt.Color;
import javax.imageio.*;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ConnectionPackage.Connector;
import Method.Method;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Marksheet extends JPanel {
	private JTextField totalField;
	private JTextField txtTotalMarks;
	private JTextField txtMarksGet;
	private JTextField txtGrade;
	private JTextField txtStatus;
	private JTextField txtPracticaltheoritical;
	private JTextField txtWritten;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtTotalGet;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField subonename;
	private JTextField subtwoname;
	private JTextField subthreename;
	private JTextField subfourname;
	private JTextField sub1pt;
	private JTextField sub2pt;
	private JTextField sub3pt;
	private JTextField sub4pt;
	private JTextField sub1pg;
	private JTextField sub2pg;
	private JTextField sub3pg;
	private JTextField sub4pg;
	private JTextField sub1wt;
	private JTextField sub2wt;
	private JTextField sub3wt;
	private JTextField sub4wt;
	private JTextField sub1wg;
	private JTextField sub2wg;
	private JTextField sub3wg;
	private JTextField sub4wg;
	private JTextField sub1total;
	private JTextField sub2total;
	private JTextField sub3total;
	private JTextField sub4total;
	private JTextField sub1get;
	private JTextField sub2get;
	private JTextField sub3get;
	private JTextField sub4get;
	private JTextField sub1grade;
	private JTextField sub2grade;
	private JTextField sub3grade;
	private JTextField sub4grade;
	private JTextField sub1status;
	private JTextField sub2status;
	private JTextField sub3status;
	private JTextField sub4status;
	private JTextField txtTotalMarksObtained;
	private JTextField fullTotal;
	private JTextField fullGet;
	private JTextField totalStatus;
	private JTextField tsgpa;

	/**
	 * Create the panel.
	 */
	public Marksheet(int serial) {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(169, 207, 848, 465);
		add(panel);
		panel.setVisible(false);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(SystemColor.activeCaption);
		panel2.setBounds(169, 207, 848, 465);
		panel2.setBorder(new LineBorder(Color.BLACK));
		panel2.setVisible(true);
		panel2.setLayout(null);
		add(panel2);
		
		JLabel lblNewLabel = new JLabel("RESULT NOT ANNOUNENCED");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MS Mincho", Font.PLAIN, 63));
		lblNewLabel.setBounds(34, 51, 804, 313);
		panel2.add(lblNewLabel);
		
		
		
		
		
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setText("SUBJECT NAME");
		totalField.setBounds(38, 65, 118, 20);
		panel.add(totalField);
		totalField.setColumns(10);
		
		txtTotalMarks = new JTextField();
		txtTotalMarks.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtTotalMarks.setEditable(false);
		txtTotalMarks.setText("TOTAL MARKS");
		txtTotalMarks.setColumns(10);
		txtTotalMarks.setBounds(166, 65, 80, 20);
		panel.add(txtTotalMarks);
		
		txtMarksGet = new JTextField();
		txtMarksGet.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtMarksGet.setEditable(false);
		txtMarksGet.setText("MARKS GET");
		txtMarksGet.setColumns(10);
		txtMarksGet.setBounds(245, 65, 69, 20);
		panel.add(txtMarksGet);
		
		txtGrade = new JTextField();
		txtGrade.setText("Grade");
		txtGrade.setEditable(false);
		txtGrade.setColumns(10);
		txtGrade.setBounds(661, 65, 58, 20);
		panel.add(txtGrade);
		
		txtStatus = new JTextField();
		txtStatus.setText("Status");
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		txtStatus.setBounds(720, 65, 118, 20);
		panel.add(txtStatus);
		
		txtPracticaltheoritical = new JTextField();
		txtPracticaltheoritical.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtPracticaltheoritical.setText("PRACTICAL(PR)/TUTORIAL(TU)");
		txtPracticaltheoritical.setEditable(false);
		txtPracticaltheoritical.setColumns(10);
		txtPracticaltheoritical.setBounds(166, 42, 148, 20);
		panel.add(txtPracticaltheoritical);
		
		txtWritten = new JTextField();
		txtWritten.setText("THEORY(TH)");
		txtWritten.setEditable(false);
		txtWritten.setColumns(10);
		txtWritten.setBounds(336, 42, 145, 20);
		panel.add(txtWritten);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField.setText("TOTAL MARKS");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(335, 65, 77, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField_1.setText("MARKS GET");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(412, 65, 69, 20);
		panel.add(textField_1);
		
		txtTotalGet = new JTextField();
		txtTotalGet.setText("TOTAL GET");
		txtTotalGet.setEditable(false);
		txtTotalGet.setColumns(10);
		txtTotalGet.setBounds(502, 42, 145, 20);
		panel.add(txtTotalGet);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField_2.setText("TOTAL MARKS");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(501, 65, 77, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField_3.setText("MARKS GET");
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(577, 65, 69, 20);
		panel.add(textField_3);
		
		subonename = new JTextField();
		subonename.setEditable(false);
		subonename.setColumns(10);
		subonename.setBounds(38, 107, 118, 20);
		panel.add(subonename);
		
		subtwoname = new JTextField();
		subtwoname.setEditable(false);
		subtwoname.setColumns(10);
		subtwoname.setBounds(38, 150, 118, 20);
		panel.add(subtwoname);
		
		subthreename = new JTextField();
		subthreename.setEditable(false);
		subthreename.setColumns(10);
		subthreename.setBounds(38, 192, 118, 20);
		panel.add(subthreename);
		
		subfourname = new JTextField();
		subfourname.setEditable(false);
		subfourname.setColumns(10);
		subfourname.setBounds(38, 235, 118, 20);
		panel.add(subfourname);
		
		sub1pt = new JTextField();
		sub1pt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub1pt.setEditable(false);
		sub1pt.setColumns(10);
		sub1pt.setBounds(166, 107, 80, 20);
		panel.add(sub1pt);
		
		sub2pt = new JTextField();
		sub2pt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub2pt.setEditable(false);
		sub2pt.setColumns(10);
		sub2pt.setBounds(166, 150, 80, 20);
		panel.add(sub2pt);
		
		sub3pt = new JTextField();
		sub3pt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub3pt.setEditable(false);
		sub3pt.setColumns(10);
		sub3pt.setBounds(166, 192, 80, 20);
		panel.add(sub3pt);
		
		sub4pt = new JTextField();
		sub4pt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub4pt.setEditable(false);
		sub4pt.setColumns(10);
		sub4pt.setBounds(166, 235, 80, 20);
		panel.add(sub4pt);
		
		sub1pg = new JTextField();
		sub1pg.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub1pg.setEditable(false);
		sub1pg.setColumns(10);
		sub1pg.setBounds(245, 107, 69, 20);
		panel.add(sub1pg);
		
		sub2pg = new JTextField();
		sub2pg.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub2pg.setEditable(false);
		sub2pg.setColumns(10);
		sub2pg.setBounds(245, 150, 69, 20);
		panel.add(sub2pg);
		
		sub3pg = new JTextField();
		sub3pg.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub3pg.setEditable(false);
		sub3pg.setColumns(10);
		sub3pg.setBounds(245, 192, 69, 20);
		panel.add(sub3pg);
		
		sub4pg = new JTextField();
		sub4pg.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub4pg.setEditable(false);
		sub4pg.setColumns(10);
		sub4pg.setBounds(245, 235, 69, 20);
		panel.add(sub4pg);
		
		sub1wt = new JTextField();
		sub1wt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub1wt.setEditable(false);
		sub1wt.setColumns(10);
		sub1wt.setBounds(336, 107, 77, 20);
		panel.add(sub1wt);
		
		sub2wt = new JTextField();
		sub2wt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub2wt.setEditable(false);
		sub2wt.setColumns(10);
		sub2wt.setBounds(336, 150, 77, 20);
		panel.add(sub2wt);
		
		sub3wt = new JTextField();
		sub3wt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub3wt.setEditable(false);
		sub3wt.setColumns(10);
		sub3wt.setBounds(336, 192, 77, 20);
		panel.add(sub3wt);
		
		sub4wt = new JTextField();
		sub4wt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub4wt.setEditable(false);
		sub4wt.setColumns(10);
		sub4wt.setBounds(336, 235, 77, 20);
		panel.add(sub4wt);
		
		sub1wg = new JTextField();
		sub1wg.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub1wg.setEditable(false);
		sub1wg.setColumns(10);
		sub1wg.setBounds(412, 107, 69, 20);
		panel.add(sub1wg);
		
		sub2wg = new JTextField();
		sub2wg.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub2wg.setEditable(false);
		sub2wg.setColumns(10);
		sub2wg.setBounds(412, 150, 69, 20);
		panel.add(sub2wg);
		
		sub3wg = new JTextField();
		sub3wg.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub3wg.setEditable(false);
		sub3wg.setColumns(10);
		sub3wg.setBounds(412, 192, 69, 20);
		panel.add(sub3wg);
		
		sub4wg = new JTextField();
		sub4wg.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub4wg.setEditable(false);
		sub4wg.setColumns(10);
		sub4wg.setBounds(412, 235, 69, 20);
		panel.add(sub4wg);
		
		sub1total = new JTextField();
		sub1total.setText("100");
		sub1total.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub1total.setEditable(false);
		sub1total.setColumns(10);
		sub1total.setBounds(501, 107, 77, 20);
		panel.add(sub1total);
		
		sub2total = new JTextField();
		sub2total.setText("100");
		sub2total.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub2total.setEditable(false);
		sub2total.setColumns(10);
		sub2total.setBounds(502, 150, 77, 20);
		panel.add(sub2total);
		
		sub3total = new JTextField();
		sub3total.setText("100");
		sub3total.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub3total.setEditable(false);
		sub3total.setColumns(10);
		sub3total.setBounds(501, 192, 77, 20);
		panel.add(sub3total);
		
		sub4total = new JTextField();
		sub4total.setText("100");
		sub4total.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub4total.setEditable(false);
		sub4total.setColumns(10);
		sub4total.setBounds(501, 235, 77, 20);
		panel.add(sub4total);
		
		sub1get = new JTextField();
		sub1get.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub1get.setEditable(false);
		sub1get.setColumns(10);
		sub1get.setBounds(577, 107, 69, 20);
		panel.add(sub1get);
		
		sub2get = new JTextField();
		sub2get.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub2get.setEditable(false);
		sub2get.setColumns(10);
		sub2get.setBounds(577, 150, 69, 20);
		panel.add(sub2get);
		
		sub3get = new JTextField();
		sub3get.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub3get.setEditable(false);
		sub3get.setColumns(10);
		sub3get.setBounds(577, 192, 69, 20);
		panel.add(sub3get);
		
		sub4get = new JTextField();
		sub4get.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sub4get.setEditable(false);
		sub4get.setColumns(10);
		sub4get.setBounds(578, 235, 69, 20);
		panel.add(sub4get);
		
		sub1grade = new JTextField();
		sub1grade.setEditable(false);
		sub1grade.setColumns(10);
		sub1grade.setBounds(661, 107, 58, 20);
		panel.add(sub1grade);
		
		sub2grade = new JTextField();
		sub2grade.setEditable(false);
		sub2grade.setColumns(10);
		sub2grade.setBounds(661, 150, 58, 20);
		panel.add(sub2grade);
		
		sub3grade = new JTextField();
		sub3grade.setEditable(false);
		sub3grade.setColumns(10);
		sub3grade.setBounds(661, 192, 58, 20);
		panel.add(sub3grade);
		
		sub4grade = new JTextField();
		sub4grade.setEditable(false);
		sub4grade.setColumns(10);
		sub4grade.setBounds(661, 235, 58, 20);
		panel.add(sub4grade);
		
		sub1status = new JTextField();
		sub1status.setEditable(false);
		sub1status.setColumns(10);
		sub1status.setBounds(720, 107, 118, 20);
		panel.add(sub1status);
		
		sub2status = new JTextField();
		sub2status.setEditable(false);
		sub2status.setColumns(10);
		sub2status.setBounds(720, 150, 118, 20);
		panel.add(sub2status);
		
		sub3status = new JTextField();
		sub3status.setEditable(false);
		sub3status.setColumns(10);
		sub3status.setBounds(720, 192, 118, 20);
		panel.add(sub3status);
		
		sub4status = new JTextField();
		sub4status.setEditable(false);
		sub4status.setColumns(10);
		sub4status.setBounds(720, 235, 118, 20);
		panel.add(sub4status);
		
		txtTotalMarksObtained = new JTextField();
		txtTotalMarksObtained.setText("TOTAL MARKS");
		txtTotalMarksObtained.setEditable(false);
		txtTotalMarksObtained.setColumns(10);
		txtTotalMarksObtained.setBounds(336, 280, 145, 20);
		panel.add(txtTotalMarksObtained);
		
		fullTotal = new JTextField();
		fullTotal.setText("500");
		fullTotal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		fullTotal.setEditable(false);
		fullTotal.setColumns(10);
		fullTotal.setBounds(501, 280, 77, 20);
		panel.add(fullTotal);
		
		fullGet = new JTextField();
		fullGet.setFont(new Font("Tahoma", Font.PLAIN, 9));
		fullGet.setEditable(false);
		fullGet.setColumns(10);
		fullGet.setBounds(578, 280, 69, 20);
		panel.add(fullGet);
		
		totalStatus = new JTextField();
		totalStatus.setFont(new Font("Tahoma", Font.PLAIN, 7));
		totalStatus.setEditable(false);
		totalStatus.setColumns(10);
		totalStatus.setBounds(720, 280, 118, 20);
		panel.add(totalStatus);
		
		tsgpa = new JTextField();
		tsgpa.setEditable(false);
		tsgpa.setColumns(10);
		tsgpa.setBounds(661, 280, 58, 20);
		panel.add(tsgpa);
		
		JButton btnGetResult = new JButton("Get Result");
		
		upperBackground.add(btnGetResult);
		btnGetResult.setFocusable(false);
		btnGetResult.setBackground(SystemColor.activeCaption);
		btnGetResult.setBounds(1012, 163, 170, 23);
		
		String comboItem[]= {"SEMESTER 1","SEMESTER 2","SEMESTER 3","SEMESTER 4","SEMESTER 5","SEMESTER 6"};
		JComboBox comboBox = new JComboBox(comboItem);
		comboBox.setBounds(280, 164, 700, 22);
		upperBackground.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Select Your Semester");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(85, 168, 181, 22);
		upperBackground.add(lblNewLabel_1);
		btnGetResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sem=comboBox.getSelectedItem().toString();
				if(availabilty(serial,sem)) {
					panel.setVisible(true);
					panel2.setVisible(false);
					try {
						Connection con=Connector.connect();
						String q="select * from result where username =(select username from student where serial=?) and semester=?";
						PreparedStatement ps=con.prepareStatement(q);
						ps.setInt(1, serial);
						ps.setString(2,sem);
						ResultSet rs=ps.executeQuery();
						if(rs.next()) {
							subonename.setText(rs.getString(9));
							subtwoname.setText(rs.getString(14));
							subthreename.setText(rs.getString(19));
							subfourname.setText(rs.getString(24));
							
//							-------------------------------------------------------
							sub1pt.setText(""+rs.getInt(5));
							sub2pt.setText(""+rs.getInt(10));
							sub3pt.setText(""+rs.getInt(15));
							sub4pt.setText(""+rs.getInt(20));
							int sub1ptotal=rs.getInt(5);
							int sub2ptotal=rs.getInt(10);
							int sub3ptotal=rs.getInt(15);
							int sub4ptotal=rs.getInt(20);
							
//							-------------------------------------------------------
							sub1wt.setText(""+rs.getInt(7));
							sub2wt.setText(""+rs.getInt(12));
							sub3wt.setText(""+rs.getInt(17));
							sub4wt.setText(""+rs.getInt(22));
//							-----------------------------------------------------------
							sub1pg.setText(""+rs.getInt(6));
							sub2pg.setText(""+rs.getInt(11));
							sub3pg.setText(""+rs.getInt(16));
							sub4pg.setText(""+rs.getInt(21));
							int sub1pget=rs.getInt(6);
							int sub2pget=rs.getInt(11);
							int sub3pget=rs.getInt(16);
							int sub4pget=rs.getInt(21);
							
//							-----------------------------------------------------------
							sub1wg.setText(""+rs.getInt(8));
							sub2wg.setText(""+rs.getInt(13));
							sub3wg.setText(""+rs.getInt(18));
							sub4wg.setText(""+rs.getInt(23));
							int sub1wget=rs.getInt(8);
							int sub2wget=rs.getInt(13);
							int sub3wget=rs.getInt(18);
							int sub4wget=rs.getInt(23);
							
//							----------------------------------------------------------------
							int sub1t=sub1pget+sub1wget;
							int sub2t=sub2pget+sub2wget;
							int sub3t=sub3pget+sub3wget;
							int sub4t=sub4pget+sub4wget;
							sub1get.setText(""+sub1t);
							sub2get.setText(""+sub2t);
							sub3get.setText(""+sub3t);
							sub4get.setText(""+sub4t);
//							-------------------------------------------------
							sub1grade.setText(gradeByTotal(sub1t));
							sub2grade.setText(gradeByTotal(sub2t));
							sub3grade.setText(gradeByTotal(sub3t));
							sub4grade.setText(gradeByTotal(sub4t));
//             ---------------------------------------------------------------------------------
							sub1status.setText(statusByMarks(sub1pget,sub1wget,sub1t,sub1ptotal));
							sub2status.setText(statusByMarks(sub2pget,sub2wget,sub2t,sub2ptotal));
							sub3status.setText(statusByMarks(sub3pget,sub3wget,sub3t,sub3ptotal));
							sub4status.setText(statusByMarks(sub4pget,sub4wget,sub4t,sub4ptotal));
							int total=sub1t+sub2t+sub3t+sub4t;
							fullGet.setText(""+total);
							tsgpa.setText(""+(((double)total/50)));
							if(statusByMarks(sub1pget,sub1wget,sub1t,sub1ptotal).equals("PASSED")&&statusByMarks(sub2pget,sub2wget,sub2t,sub2ptotal).equals("PASSED")&&statusByMarks(sub3pget,sub3wget,sub3t,sub3ptotal).equals("PASSED")&&statusByMarks(sub4pget,sub4wget,sub4t,sub4ptotal).equals("PASSED")) {
								totalStatus.setText("SEMESETER CLEARED");
							}else {
								totalStatus.setText("SEMESETER NOT CLEARED");
							}
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					panel.setVisible(false);
					panel2.setVisible(true);
//					JOptionPane.showMessageDialog(null, "Result Not Announced Yet");
					
				}
			}

			private String statusByMarks(int practical, int theory, int total,int ptotal) {
				if(practical <=9 && theory>21 && total>=30) {
					if(ptotal==20) {return "FAILED IN (TU)";}else {return "FAILED IN (PR)";}
				}else if(practical >9 && theory<=21 && total>=30) {
					return "FAILED IN (TH)";
				}else if(practical>9 && theory>21 && total >=30){
					return "PASSED";
				}else {
					return "FAILED";
				}
			}

			private String gradeByTotal(int total) {
				if(total>=90) {
					return "AA";
				}else if(total>=80 && total<90) {
					return "A+";
				}else if(total>=60 && total<80) {
					return "A";
				}else if(total>=50 && total<60) {
					return "B+";
				}else if(total>=40 && total<50) {
					return "B";
				}else if(total>=30 && total<40) {
					return "C";
				}else {
					return "D";
				}
			}

			private boolean availabilty(int serial,String sem) {
				try {
					Connection con=Connector.connect();
					String q="select status from result where username =(select username from student where serial=?) and semester=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, serial);
					ps.setString(2,sem);
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						if(rs.getInt(1)==2) {
							return true;
						}
					}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		});
//		
	}
}

