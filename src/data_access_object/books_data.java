package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.databaseUtil;
import Model.books;

public class books_data implements data_interface<books>{
	public static books_data getInstance() {
		return new books_data();
	}

	@Override
	public int insert(books t) {
		int check = 0 ; 
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "INSERT INTO books (idBook, nameBook, cost, typeBook, authorBook, number, publisher, yearPublisher) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, t.getIdBook());
			pst.setString(2, t.getNameBook());
			pst.setDouble(3, t.getCost());
			pst.setString(4, t.getTypeBook());
			pst.setString(5, t.getAuthorBook());
			pst.setInt(6, t.getNumber());
			pst.setString(7, t.getPublisher());
			pst.setInt(8, t.getYearPublisher());
			
			check = pst.executeUpdate();
			
			databaseUtil.closeConnection(connection);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return check;
	}

	@Override
	public int update(books t) {
		int check = 0 ;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "UPDATE books "
					+" SET "
					+ " nameBook=?"
					+ ", cost=?"
					+ ", typeBook=?"
					+ ", authorBook=?"
					+ ", number=?"
					+ ", publisher=?"
					+ ", yearPublisher=?"
					+ " WHERE idBook=?";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, t.getNameBook());
			pst.setDouble(2, t.getCost());
			pst.setString(3, t.getTypeBook());
			pst.setString(4, t.getAuthorBook());
			pst.setInt(5, t.getNumber());
			pst.setString(6, t.getPublisher());
			pst.setInt(7, t.getYearPublisher());
			pst.setString(8, t.getIdBook());
			
			check = pst.executeUpdate();
			
			databaseUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public int delete(books t) {
		int check = 0 ;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "DELETE FROM books"+
						" WHERE idBook=?";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, t.getIdBook());
			
			check = pst.executeUpdate();
			
			databaseUtil.closeConnection(connection);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return check;
	}

	@Override
	public ArrayList<books> selectAll() {
		ArrayList<books> list = new ArrayList<>();
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "SELECT * FROM books";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			ResultSet rst = pst.executeQuery();
			
			while (rst.next()) {
				String idBook = rst.getString("idBook");
				String nameBook = rst.getString("nameBook");
				Double cost = rst.getDouble("cost");
				String typeBook = rst.getString("typeBook");
				String authorBook = rst.getString("authorBook");
				int number = rst.getInt("number");
				String publisher = rst.getString("publisher");
				int yearPublisher = rst.getInt("yearPublisher");
				
				books book1 = new books(idBook, nameBook, cost, typeBook, authorBook, number, publisher, yearPublisher);
				
				list.add(book1);
			}
			
			databaseUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public books selectById(books t) {
		books check = null ;
		
		try {
			Connection connection = databaseUtil.getConnection();
			
			String sql = "SELECT * FROM books "+
						" WHERE idBook=?";
			
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			pStatement.setString(1, t.getIdBook());
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				String idBook = resultSet.getString("idBook");
				String nameBook = resultSet.getString("nameBook");
				double cost = resultSet.getDouble("cost");
				String typeBook = resultSet.getString("typeBook");
				String authorBook = resultSet.getString("authorBook");
				int number = resultSet.getInt("number");
				String publisher = resultSet.getString("publisher");
				int yearPublisher = resultSet.getInt("yearPublisher");
				
				check = new books(idBook, nameBook, cost, typeBook, authorBook, number, publisher, yearPublisher);
				
			}
			
			
			
			databaseUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return check;
	}

	
}
