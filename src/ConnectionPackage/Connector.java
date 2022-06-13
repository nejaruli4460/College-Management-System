package ConnectionPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connector {
	static java.sql.Connection con;
	public  static java.sql.Connection connect() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");///load class
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/snc_college", "root", "");
//			con=DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6491738", "sql6491738", "xwCQgIFvy3");
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Connection failed!!!!","Network error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return con;
		
	}
	public static void Close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
		
	}

