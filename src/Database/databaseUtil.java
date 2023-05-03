package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseUtil {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			String url = "jdbc:mySQL://localhost:3306/qlbooks";
			String username = "root";
			String password = "";
			
			
			c = DriverManager.getConnection(url, username, password);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}