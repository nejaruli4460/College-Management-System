package student;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;

import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import Method.Method;
import faculty.FacultyRoutine;
public class Routine extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Routine(int serial) {
		setBounds(0,0,1440,883);
		setLayout(null);
		setBackground(new Color(0,0,0,80));
		Method method=new Method();
		
		JLabel routineLabel = new JLabel("ROUTINE");
		routineLabel.setForeground(Color.ORANGE);
		routineLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 45));
		routineLabel.setBorder(new EtchedBorder(3));
		
		routineLabel.setBounds(522, 36, 182, 56);
		add(routineLabel);
		
		JLabel routineBackground = new JLabel("");
		routineBackground.setBounds(34, 102, 1169, 586);
		add(routineBackground);
		Refresh(routineBackground,serial);
	
		
		
	}
	public static void Refresh(JLabel routine,int serial){
		Method method =new Method();
		Connection con;
		try {
			con = Connector.connect();
			String query="select routine from routine where department=(select department from student where serial=?)";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, serial);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Blob b=rs.getBlob(1);
				InputStream in=b.getBinaryStream();
				Image img=ImageIO.read(in);
				ImageIcon icon=new ImageIcon(img);
				method.resizeImage(icon, 1169, 586, routine);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
