package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPanel;

import ConnectionPackage.Connector;

public class LoginDao {
	static Connection con;
	public static int admin(String str,String str1) {
		int serial=0;
		try {
			con=Connector.connect();
			String Query="Select username,dob,sl from admin where username=? and dob=?";
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, str);
			ps.setString(2, str1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String user=rs.getString(1);
				String pass=rs.getString(2);
				if(str.equalsIgnoreCase(user)&&str1.equals(pass)){
					serial=rs.getInt(3);
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serial;
		
	}
	public static int faculty(String str,String str1) {
		int serial=0;
		try {
			con=Connector.connect();
			String Query="Select username,dob,sl from faculty where username=? and dob=?";
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, str);
			ps.setString(2, str1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String user=rs.getString(1);
				String pass=rs.getString(2);
				if(str.equalsIgnoreCase(user)&&str1.equals(pass)){
					serial=rs.getInt(3);
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serial;
		
	}

	public static int student(String str,String str1) {
		
		int serial=0;
		try {
			con=Connector.connect();
			String Query="Select username,dob,serial from student where username=? and dob=?";
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, str);
			ps.setString(2, str1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String user=rs.getString(1);
				String pass=rs.getString(2);
//				System.out.println(str+"   "+user);
				if(str.equalsIgnoreCase(user)&&str1.equals(pass)){
					serial=rs.getInt(3);
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serial;
		
	}


}
