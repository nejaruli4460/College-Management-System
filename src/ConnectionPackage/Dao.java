package ConnectionPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	public String studentLogin(Pojo p){
		String flag=null;
		try {
		Connection con=Connector.connect();
		String q="select * from student where mobile=? and dob=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setString(1,p.getUser());
		ps.setString(2, p.getPass());
//		System.out.println(q);
		ResultSet demo=ps.executeQuery();
		String user=p.getUser();
		String pass=p.getPass();

		while(demo.next()) {
			if(user.equalsIgnoreCase(demo.getString(9)) && pass.equals(demo.getString(7))) {
				flag=demo.getString(2);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}

