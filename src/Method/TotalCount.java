package Method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;

import ConnectionPackage.Connector;

public class TotalCount {
	
	public static int TotalStudent() {
		int n=0;
		try {
			Connection con=Connector.connect();
			String query="select count(*) from student";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				n=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	public static int TotalFaculty() {
		int n=0;
		try {
			Connection con=Connector.connect();
			String query="select count(*) from faculty";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				n=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	public static int TotalDepartment() {
		int n=0;
		try {
			Connection con=Connector.connect();
			String query="SELECT COUNT(*) from (SELECT d_name FROM department UNION SELECT d_name FROM department) as nem";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				n=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	public static void TotalNotification(JLabel label,int serial,String string) {
		try {
			Connection con=Connector.connect();
			String query="select count(*) from notice where ack=? or ack=? or ack=? and status=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1,string);
			stmt.setString(2,"all");
			stmt.setString(3,Method.usernameBySerial(serial));
			stmt.setInt(4, 0);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				label.setText(""+rs.getInt(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void TotalNotificationAll(JLabel notificationCount) {
		
		try {
			Connection con=Connector.connect();
			String query="select count(*) from notice";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				notificationCount.setText(""+rs.getInt(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
