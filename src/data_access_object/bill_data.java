package data_access_object;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.databaseUtil;
import Model.bill;

public class bill_data implements data_interface<bill>{

	public static bill_data getInstance() {
		return new bill_data();
	}
	
	
	@Override
	public int insert(bill t) {
		int check = 0 ;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "INSERT INTO bill "
					+" VALUES (?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, t.getId_out());
			preparedStatement.setDate(2, t.getDate());
			preparedStatement.setDouble(3, t.getTotal_bill());
			
			check = preparedStatement.executeUpdate();
			
			databaseUtil.closeConnection(connection);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check; 
	}

	@Override
	public int update(bill t) {
		int check = 0;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "UPDATE bill "+
						" SET "+
						" date=?"+
						", total_bill=?"+
						" WHERE id_out=?";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			pStatement.setDate(1, (Date) t.getDate());
			pStatement.setDouble(2, t.getTotal_bill());
			pStatement.setString(3, t.getId_out());
			
			check = pStatement.executeUpdate();
			
			
			databaseUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return check;
	}

	@Override
	public int delete(bill t) {
		int check = 0;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "DELETE FROM bill "
						+ "WHERE id_out=?";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			pStatement.setString(1, t.getId_out());
			
			databaseUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public ArrayList<bill> selectAll() {
		ArrayList<bill> list = new ArrayList<>();
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "SELECT * FROM bill";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				String id_out = resultSet.getString("id_out");
				Date date = resultSet.getDate("date");
				Double total_bill = resultSet.getDouble("total_bill");
				
				bill bill1 = new bill(id_out, date, total_bill);
				list.add(bill1);
			}
			
			
			databaseUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public bill selectById(bill t) {
		bill bill1 = null;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "SELECT * FROM bill "
						+" WHERE id_out=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, t.getId_out());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String id_out = resultSet.getString("id_out");
				Date date = resultSet.getDate("date");
				Double total_bill = resultSet.getDouble("total_bill");
				
				bill1 = new bill(id_out, date, total_bill);
			}
			
			databaseUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill1;
	}

	

}
