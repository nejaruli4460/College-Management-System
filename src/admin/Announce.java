package admin;

import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import ConnectionPackage.Connector;
import Method.Method;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Announce extends JDialog {

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Announce() {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);

		setBounds(100, 100, 450, 300);
		
		Method method=new Method();
		JLabel Background = new JLabel("");
		Background.setBounds(0, 0, 450, 300);
		getContentPane().add(Background);
		ImageIcon icon=new ImageIcon(".//asset//uperBack.jpg");
		method.resizeImage(icon, 450, 300, Background);
		getContentPane().setLayout(null);
		String comboItem[]= {"SEMESTER 1","SEMESTER 2","SEMESTER 3","SEMESTER 4","SEMESTER 5","SEMESTER 6"};
		JComboBox comboBox = new JComboBox(comboItem);
		comboBox.setBounds(34, 58, 359, 29);
		Background.add(comboBox);
		
		JLabel semesterSelect = new JLabel("Select Semester");
		semesterSelect.setHorizontalAlignment(SwingConstants.CENTER);
		semesterSelect.setFont(new Font("Tahoma", Font.PLAIN, 21));
		semesterSelect.setBounds(34, 11, 359, 29);
		Background.add(semesterSelect);
		
		JButton btnAnnouncedAndPromote = new JButton("Announced And Promote");
		btnAnnouncedAndPromote.setBackground(SystemColor.activeCaption);
		btnAnnouncedAndPromote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection con =Connector.connect();
					String q="update result set status=2 where semester=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1, comboBox.getSelectedItem().toString());;
					ps.executeUpdate();
					
					String q1="insert into notice(title,notice,ack,date,memo) values(?,?,?,?,?)";
					PreparedStatement ps1=con.prepareStatement(q1);
					ps1.setString(1, "Result Announced");
					ps1.setString(2, "Result announced for "+comboBox.getSelectedItem().toString());
					SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
					Date date=new Date();
					ps1.setString(3,"student");
					ps1.setString(4, formatter.format(date));
					String q3="select max(sl) from notice";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(q3);
					int sl=0;
					if(rs.next()) {
						sl=rs.getInt(1)+1;
					}
					ps1.setString(5, "SNC/Result/"+sl);
					ps1.executeUpdate();
					String currentSem=comboBox.getSelectedItem().toString();
					String nextSem="";
					if(currentSem.equals("SEMESTER 6")) {
						nextSem=nextSem.concat("Passed");
						
						
					}else {
						int semNumber=Integer.parseInt(currentSem.substring(9));
						nextSem=nextSem+"SEMESTER "+(semNumber+1);
					}
					
					Connection con1=Connector.connect();
					String query="select username from student where current_sem=?";
					PreparedStatement stmt1=con1.prepareStatement(query);
					stmt1.setString(1, currentSem);
					ResultSet rs1=stmt1.executeQuery();
//					System.out.println(query);
					while(rs1.next()) {
						String user=rs1.getString(1);
						if(currentSem.equals("SEMESTER 6")==false) {
							
							String query1="insert into result(username,semester,department) values(?,?,(select department from student where username=?))";
							PreparedStatement resultps=con1.prepareStatement(query1);
							resultps.setString(1,user);
							resultps.setString(2, nextSem);
							resultps.setString(3,user);
							resultps.executeUpdate();
							
							String query2="insert into studentfees(username,sem,status) values(?,?,?)";
							PreparedStatement p2=con.prepareStatement(query2);
							p2.setString(1,user);
							p2.setString(2,nextSem);
							p2.setString(3, "due");
							p2.executeUpdate();
							
							String query3="update attendance set semester=?,total=0,attend=0 where username=?";
							PreparedStatement p3=con.prepareStatement(query3);
							p3.setString(2,user);
							p3.setString(1,nextSem);
							p3.executeUpdate();

						}else {
							String query5="delete from attendance where username=?";
							PreparedStatement p3=con.prepareStatement(query5);
							p3.setString(1,user);
							p3.executeUpdate();
						}
												
						String query4="update student set current_sem=? where username=?";
						PreparedStatement p4=con.prepareStatement(query4);
						p4.setString(2,user);
						p4.setString(1,nextSem);
						p4.executeUpdate();
						
					}
					

					
					JOptionPane.showMessageDialog(null,"Result Announced");
					setVisible(false);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAnnouncedAndPromote.setFocusable(false);
		btnAnnouncedAndPromote.setBounds(34, 169, 355, 23);
		Background.add(btnAnnouncedAndPromote);

	}
}
