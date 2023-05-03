package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Model.books;
import View.QLBSView;
import data_access_object.books_data;

public class List_search_book implements ActionListener{
	
	private QLBSView view;
	
	public List_search_book(QLBSView view) {
		this.view = view;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		
		
		
		if (ac.equals("Tìm kiếm")) {
			
			ArrayList<books> list = new ArrayList<>();
			
			list = books_data.getInstance().selectAll();
			
			boolean check_name_book = false;
			boolean check_author_book = false;
			
			books search_book = new books();
			
			for (books books_check_name : list) {
				if (books_check_name.getNameBook().equals(this.view.getSearchBookNameField().getText())) {
					check_name_book = true;
				}
				if (books_check_name.getAuthorBook().equals(this.view.getSearchAuthorField().getText()) ) {
					check_author_book = true;
					
				}
				if (check_name_book == true) {
					search_book = books_check_name;
					break;
				}
			}
			
			if (check_name_book == false) {
				JOptionPane.showMessageDialog(view,
						"không có tên sách nào ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			
			if (check_author_book == false) {
				JOptionPane.showMessageDialog(view,
						"không có tên tác giả nào ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			
			if (check_author_book == true && check_name_book == true) {
				DefaultTableModel model = (DefaultTableModel) this.view.getInformationTable().getModel();
				
				model.setRowCount(0);
					model.addRow(new Object[] {
							search_book.getIdBook(),
							search_book.getNameBook(),
							search_book.getAuthorBook(),
							search_book.getPublisher(),
							search_book.getTypeBook(),
							search_book.getYearPublisher(),
							search_book.getNumber(),
							search_book.getCost()
					});
				
				
			}
			
		}
		
	}

}
