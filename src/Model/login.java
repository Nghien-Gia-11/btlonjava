package Model;

public class login {
	private String username;
	private String password;
	
	
	
	
	

	public login() {
		super();
	}


	public login(String username, String pass) {
		super();
		this.username = username;
		this.password = pass;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "login [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
