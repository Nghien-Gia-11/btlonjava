package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.databaseUtil;
import Model.bill_detail;
import Model.login;

public class login_data implements data_interface<login>{
	
	public static login_data getInstance() {
		return new login_data();
	}

	@Override
	public int insert(login t) {
		int check = 0 ;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "INSERT INTO sign_up "
						+ " VALUES (?, ?)";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			pStatement.setString(1, t.getUsername());
			pStatement.setString(2, t.getPassword());
			
			check = pStatement.executeUpdate();
			
			
			
			
			databaseUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return check;
	}

	@Override
	public int update(login t) {
		int check = 0 ;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "UPDATE sign_up "
						+ " SET "
						+ " password=?"
						+ " WHERE username=?";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			pStatement.setString(1, t.getPassword());
			pStatement.setString(2, t.getUsername());
			
			
			check = pStatement.executeUpdate();
			
			
			
			
			databaseUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return check;
	}

	@Override
	public int delete(login t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<login> selectAll() {
		ArrayList<login> list = new ArrayList<>();
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "SELECT * FROM sign_up";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				
				login login1 = new login(username, password);
				
				list.add(login1);
				
			}
			
			databaseUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}

	@Override
	public login selectById(login t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
