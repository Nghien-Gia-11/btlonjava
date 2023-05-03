package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.books;
import View.View_update_cost_book;
import data_access_object.books_data;

public class List_update_cost_book implements ActionListener{
	
	private View_update_cost_book update_cost_book;
	
	public List_update_cost_book(View_update_cost_book update_cost_book) {
		this.update_cost_book = update_cost_book;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		
		boolean check = false;
		
		
		if (ac.equals("Thêm")) {
			
			String idBook = this.update_cost_book.getUpdate_cost_BookIDField().getText();
			String nameBook = this.update_cost_book.getUpdate_cost_BookNameField().getText();
			Double cost = Double.valueOf(this.update_cost_book.getUpdate_cost_CostField().getText());
			books books1 = new books();
			
			ArrayList<books> list = new ArrayList<>();
			list = books_data.getInstance().selectAll();
		
			
			
			for (books books2 : list) {
				if (books2.getIdBook().compareTo(idBook) == 0 ) {
					books1 = books2;
					check = true;
				}
			}
			
			if (check == false) {
				JOptionPane.showMessageDialog(update_cost_book,
						"không có idBook nào ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			if (check == true) {
				books1.setCost(cost);
				books_data.getInstance().update(books1);
				JOptionPane.showMessageDialog(update_cost_book,
						"cập nhật thành công ! ",
						"",
						JOptionPane.INFORMATION_MESSAGE
						
						);
			}
		}
		if (ac.equals("Thoát")) {
			this.update_cost_book.dispose();
		}
	}

}
