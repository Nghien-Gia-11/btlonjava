package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Model.books;
import View.AddBookView;
import View.QLBSView;
import View.View_update_book;
import data_access_object.books_data;

public class List_insert_book implements ActionListener{
	
	private AddBookView addBookView;
	
	
	public List_insert_book(AddBookView addBookView) {
		this.addBookView = addBookView;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ac = e.getActionCommand();
		
		if (ac.equals("Thêm")) {
			String idBook = this.addBookView.getAddBookIDField().getText();
			String nameBook = this.addBookView.getAddBookNameField().getText();
			Double cost = Double.valueOf(this.addBookView.getAddCostField().getText());
			String typeBook = String.valueOf(this.addBookView.getAddKobBox().getSelectedItem());
			String authorBook = this.addBookView.getAddAuthorField().getText();
			int number = Integer.valueOf(this.addBookView.getAddNumberField().getText());
			String publisher = this.addBookView.getAddPublisherField().getText();
			int yearPublisher = Integer.valueOf(this.addBookView.getAddYearField().getText());
			
			books books1 = new books(idBook, nameBook, cost, typeBook, authorBook, number, publisher, yearPublisher);
			
			ArrayList<books> list = new ArrayList<>();
			list = books_data.getInstance().selectAll();
			
			boolean check = false;
			
			for (books books_check : list) {
				if (books_check.getIdBook().compareTo(idBook) == 0) {
					check = true;
				}
			}
			
			if (check == true) {
				JOptionPane.showMessageDialog(addBookView,
						"đã có idBook ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			if (check == false) {
				books_data.getInstance().insert(books1);
				JOptionPane.showMessageDialog(addBookView,
						"thêm thành công ! ",
						"",
						JOptionPane.INFORMATION_MESSAGE
						
						);
				
			}
		}
		if (ac.equals("Thoát")) {
			this.addBookView.dispose();
		}
		
	}

}
