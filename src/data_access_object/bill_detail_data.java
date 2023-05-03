package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import Database.databaseUtil;
import Model.bill;
import Model.bill_detail;

public class bill_detail_data implements data_interface<bill_detail>{

	public static bill_detail_data getInstance() {
		return new bill_detail_data();
	}
	
	
	
	
	@Override
	public int insert(bill_detail t) {
		int check = 0;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "INSERT INTO bill_detail "
						+" VALUES (?, ?, ?, ?)";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			pStatement.setString(1, t.getId_out());
			pStatement.setString(2, t.getIdBook_out());
			pStatement.setDouble(3, t.getPrice());
			pStatement.setInt(4, t.getAmount());
			
			check = pStatement.executeUpdate();	
			
			databaseUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public int update(bill_detail t) {
		int check = 0 ;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "UPDATE bill_detail "
						+" SET "
						+" idBook_out=?"
						+", price=?"
						+", amount=?"
						+" WHERE id_out=?";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, t.getIdBook_out());
			pst.setDouble(2, t.getPrice());
			pst.setInt(3, t.getAmount());
			pst.setString(4, t.getId_out());
			
			
			check = pst.executeUpdate();
			
			databaseUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return check;
	}

	@Override
	public int delete(bill_detail t) {
		int check = 0;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "DELETE FROM bill_detail "
						+" WHERE id_out=?";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			pStatement.setString(1, t.getId_out());
			
			check = pStatement.executeUpdate();
			
			databaseUtil.closeConnection(connection);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return check;
	}

	@Override
	public ArrayList<bill_detail> selectAll() {
		 ArrayList<bill_detail> list = new ArrayList<>();
		 
		 try {
			Connection connection = databaseUtil.getConnection();
			 
			 String sql = "SELECT * FROM bill_detail";
			 
			 PreparedStatement pStatement = connection.prepareStatement(sql);
			 
			 ResultSet rstResultSet = pStatement.executeQuery();
			 
			 while (rstResultSet.next()) {
				String id_out = rstResultSet.getString("id_out");
				String idBook_out = rstResultSet.getString("idBook_out");
				Double price = rstResultSet.getDouble("price");
				int amount = rstResultSet.getInt("amount");
				
				bill_detail bill_detail1 = new bill_detail(id_out, idBook_out, price, amount);
				
				list.add(bill_detail1);
				
			}
			 
			 databaseUtil.closeConnection(connection);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 return list;
	}

	@Override
	public bill_detail selectById(bill_detail t) {
		return null;
	}

	
	public Set<String> selectId(){
		
		Set<String> listId = new HashSet<>();
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "SELECT id_out FROM bill_detail";		
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				String id_out = resultSet.getString("id_out");
				
				listId.add(id_out);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listId;
		
	}
	
	public ArrayList<bill_detail> selectById(String id_out) {
		ArrayList<bill_detail> list = new ArrayList<>();
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "SELECT * FROM bill_detail "
						+ " WHERE id_out=?";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id_out);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				String id_out1 = resultSet.getString("id_out");
				String idBook_out = resultSet.getString("idBook_out");
				Double price = resultSet.getDouble("price");
				int amount = resultSet.getInt("amount");
				
				bill_detail bill_detail1 = new bill_detail(id_out1, idBook_out, price, amount);
				
				list.add(bill_detail1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
public ArrayList<String> selectAllId(){
		
		ArrayList<String> listId = new ArrayList<>();
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "SELECT id_out FROM bill_detail";		
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				String id_out = resultSet.getString("id_out");
				
				listId.add(id_out);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listId;
		
	}
	
	
}
