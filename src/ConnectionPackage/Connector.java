package ConnectionPackage;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {
	static java.sql.Connection con;
	public  static java.sql.Connection connect() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");///load class
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/snc_college", "root", "");
			if(con==null) {
				System.out.println("connection not done");
			}else {
				System.out.println("connection done");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
		
	}
		
		
	}

