package Main;

import java.util.ArrayList;

import Database.databaseUtil;
import Model.books;
import data_access_object.books_data;

public class test_books {
	public static void main(String[] args) {
		books book1 = new books();
		book1.setIdBook("1");
		System.out.println(books_data.getInstance().selectById(book1));
		System.out.println(books_data.getInstance().selectAll());
	}
}
