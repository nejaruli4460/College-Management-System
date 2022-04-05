package ConnectionPackage;

public class Pojo {
	private String user;
	private String pass;
	public Pojo(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	public Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Pojo [user=" + user + ", pass=" + pass + "]";
	}
	

}
