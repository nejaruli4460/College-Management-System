package Method;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import ConnectionPackage.Connector;
import admin.DateLabelFormatter;

public class Method {
	public void resizeImage(ImageIcon img,int x,int y,JLabel set) {
		ImageIcon setIcon=new ImageIcon(img.getImage().getScaledInstance(x, y,Image.SCALE_DEFAULT));
		set.setIcon(setIcon);
	}
	public static String departmentCount() {
		int i=0;
		try {
			Connection con=Connector.connect();
			String q="Select * from department";
			Statement st=con.createStatement();
			ResultSet demo=st.executeQuery(q);
			while(demo.next()) {
				i++;
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (""+i);
	}
	public static void main(String args[]) {
		Method.departmentCount();
	}
	public static JDatePickerImpl datePicker() {
		UtilDateModel model1 = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model1, p);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		
		return datePicker;
		
	}
	public static String currentSem(int serial) {
		try {
			Connection con=Connector.connect();
			String query="select current_sem from student where serial=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static String usernameBySerial(int serial) {
		try {
			Connection con=Connector.connect();
			String query="select username from student where serial=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static String usernameBySerialFaculty(int serial) {
		try {
			Connection con=Connector.connect();
			String query="select username from faculty where sl=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public static String usernameBySerialAdmin(int serial) {
		try {
			Connection con=Connector.connect();
			String query="select username from admin where sl=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
	public static String nameBySerial(int serial) {
		try {
			Connection con=Connector.connect();
			String query="select name from student where serial=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static String departmentBySerial(int serial) {
		try {
			Connection con=Connector.connect();
			String query="select department from student where serial=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static String nameByUsername(String username,String Ack) {
		try {
			Connection con=Connector.connect();
			String query="";
			if(Ack.equals("faculty")) {
				query=query.concat("select name from faculty where username=?");
			}else if(Ack.equals("student")) {
				query=query.concat("select name from student where username=?");
			}else {
				query=query.concat("select name from admin where username=?");
			}
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			Connector.Close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static int countTotalMessage() {
		int i=0;
		try {
			Connection con=Connector.connect();
			String q="Select count(*) from message";
			Statement st=con.createStatement();
			ResultSet demo=st.executeQuery(q);
			while(demo.next()) {
				i=demo.getInt(1);
			}
			Connector.Close(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (i);
	}
	public static int countTotalMessageBySearch(String username,String str) {
		int i=0;
		try {
			Connection con=Connector.connect();
			String q="Select count(*) from message where senderId=? or recId=? or (reciever=? and recId=?) or (sender=? and senderId=?)";
			PreparedStatement st=con.prepareStatement(q);
			st.setString(1,username);
			st.setString(2,username);
			st.setString(3, str);
			st.setString(4,username);
			st.setString(5, str);
			st.setString(6,username);
			ResultSet demo=st.executeQuery();
			while(demo.next()) {
				i=demo.getInt(1);
			}
			Connector.Close(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (i);
	}
	public static int RecievedMessageBySearch(String username,String str) {
		int i=0;
		try {
			Connection con=Connector.connect();
			String q="Select count(*) from message where  recId=? or (reciever=? and recId=?)";
			PreparedStatement st=con.prepareStatement(q);
			st.setString(1,username);
			st.setString(2,str);
			st.setString(3,username);
			ResultSet demo=st.executeQuery();
			while(demo.next()) {
				i=demo.getInt(1);
			}
			Connector.Close(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (i);
	}

	public static String lastLoginTime(int serial,String str) {
		try {
			Connection con=Connector.connect();
			String query="select max(logintime) from loginrecord where username=?";
			PreparedStatement ps=con.prepareStatement(query);
			if(str.equals("student")) {
				ps.setString(1, usernameBySerial(serial));
			}else if(str.equals("faculty")) {
				ps.setString(1, usernameBySerialFaculty(serial));
			}else {
				ps.setString(1, usernameBySerialAdmin(serial));
			}
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getTimestamp(1).toString();
			}
			Connector.Close(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not login yet";
		
	}
public static void lastLoginInsert(int serial,String str) {
		
	try {
		Connection con=Connector.connect();
		String query="insert into loginrecord(username) values(?)";
		PreparedStatement ps=con.prepareStatement(query);
		if(str.equals("student")) {
			ps.setString(1, usernameBySerial(serial));
		}else if(str.equals("faculty")) {
			ps.setString(1, usernameBySerialFaculty(serial));
		}else {
			ps.setString(1, usernameBySerialAdmin(serial));
		}
		ps.executeUpdate();
		Connector.Close(con);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
public static String facultyDepartmentNameBySerial(int serial) {
	
	try {
		Connection con=Connector.connect();
		String query="select department from faculty where sl=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, serial);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}
		Connector.Close(con);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
		
	}

}
