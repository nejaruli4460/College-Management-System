package student;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ConnectionPackage.Connector;

public class UserFetch {
	static String name;
	static ImageIcon icon;
	public static String nameFetch(int serial) {
		try {
			Connection con=Connector.connect();
			String query="select name from student where serial=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				name=rs.getString(1);
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return name;
	}
	public static void photoFetch(int serial,JLabel photo) {
		try {
			Connection con=Connector.connect();
			String query="select image from student where serial=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, serial);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(1);
				InputStream is=b.getBinaryStream();
				Image image=ImageIO.read(is);
				icon=new ImageIcon(image);
				Method.Method method=new Method.Method();
				method.resizeImage(icon, 78, 90, photo);
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
