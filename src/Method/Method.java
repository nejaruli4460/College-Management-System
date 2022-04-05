package Method;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ConnectionPackage.Connector;

public class Method {
	public void resizeImage(ImageIcon img,int x,int y,JLabel set) {
		ImageIcon setIcon=new ImageIcon(img.getImage().getScaledInstance(x, y,Image.SCALE_DEFAULT));
		set.setIcon(setIcon);
	}
	public static String departmentCount() {
		int i=0;
		try {
			Connection con=Connector.connect();
			String q="Select * from Department";
			Statement st=con.createStatement();
			ResultSet demo=st.executeQuery(q);
			while(demo.next()) {
				i++;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (""+i);
	}
	public static void main(String args[]) {
		Method.departmentCount();
	}
}
