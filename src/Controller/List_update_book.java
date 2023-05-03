package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.books;
import Model.login;
import View.View_update_book;
import data_access_object.books_data;
import data_access_object.login_data;

public class List_update_book implements ActionListener{
	
	private View_update_book update_book;
	
	public List_update_book(View_update_book update_book) {
		this.update_book = update_book;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		boolean check = false;
		if (ac.equals("Cập nhật")) {
			String idBook = this.update_book.getUpdate_BookIDField().getText();
			String nameBook = this.update_book.getUpdate_BookNameField().getText();
			Double cost = Double.valueOf(this.update_book.getUpdate_CostField().getText());
			String typeBook = String.valueOf(this.update_book.getUpdate_KobBox().getSelectedItem());
			String authorBook = this.update_book.getUpdate_AuthorField().getText();
			int number = Integer.valueOf(this.update_book.getUpdate_NumberField().getText());
			String publisher = this.update_book.getUpdate_PublisherField().getText();
			int yearPublisher = Integer.valueOf(this.update_book.getUpdate_YearField().getText());
			
			books books1 = new books(idBook, nameBook, cost, typeBook, authorBook, number, publisher, yearPublisher);
			
			ArrayList<books> list = new ArrayList<>();
			list = books_data.getInstance().selectAll();
			
			
			for (books books2 : list) {
				if (books2.getIdBook().compareTo(idBook) == 0 ) {
					check = true;
				}
			}
			if (check == false) {
				JOptionPane.showMessageDialog(update_book,
						"không có idBook nào ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			if (check == true ) {
				books_data.getInstance().update(books1);
				JOptionPane.showMessageDialog(update_book,
						"cập nhật thành công ! ",
						"",
						JOptionPane.INFORMATION_MESSAGE
						
						);
			}
			
			
		}
		if (ac.equals("Thoát")) {
			this.update_book.dispose();
		}
		
	}

}
