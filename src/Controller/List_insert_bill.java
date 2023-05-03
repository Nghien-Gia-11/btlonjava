package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.sql.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Main.test;
import Model.bill;
import Model.bill_detail;
import Model.books;
import View.QLBSView;
import data_access_object.bill_data;
import data_access_object.bill_detail_data;
import data_access_object.books_data;

public class List_insert_bill implements ActionListener{

private QLBSView view;

public List_insert_bill(QLBSView view) {
		this.view = view;
}
//package
//controller
//class
//ListUpdateBook
//attrib
//insertBook
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ac = e.getActionCommand();
		int sequenceNumber = 0;
		if (ac.equals("Nhập")) {
			
			ArrayList<books> list = new ArrayList<>();
			
			list = books_data.getInstance().selectAll();
			
			
			boolean check_id = false;
			
			books insert_book = new books();
			
			for (books check_id_book : list) {
				if (check_id_book.getIdBook().compareTo(this.view.getInsert_idBookField().getText()) == 0 ) {
					check_id = true;
					insert_book = check_id_book;
				}
			}
		
			if (check_id == false) {
				JOptionPane.showMessageDialog(view,
						"không có idBook nào ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
		
			boolean check_number = false;
			
			if (insert_book.getNumber() >= Integer.valueOf(this.view.getInsert_numberBookField().getText()) ) {
				check_number = true;
			}
			
			if (check_number == false) {
				JOptionPane.showMessageDialog(view,
						"không đủ số lượng ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			
			if (check_id == true && check_number == true) {
				
				
				
				Double total_money = Integer.valueOf(this.view.getInsert_numberBookField().getText())*insert_book.getCost();
				
				DefaultTableModel model = (DefaultTableModel) this.view.getBillTable().getModel();
					model.addRow(new Object[] {
							insert_book.getIdBook(),
							insert_book.getNameBook(),
							this.view.getInsert_numberBookField().getText(),
							insert_book.getCost(),
							insert_book.getPublisher(),
							total_money
					});
				Double total_bill = 0.0 ;
				
				for (int i = 0; i < this.view.getBillTable().getRowCount(); i++) {
					total_bill += (Double) this.view.getBillTable().getValueAt(i, 5);
				}
				
				this.view.getTotalPriceLable().setText(String.valueOf(total_bill));
				insert_book.setNumber(insert_book.getNumber() - Integer.valueOf(this.view.getInsert_numberBookField().getText()));
				books_data.getInstance().update(insert_book);
				}
			

					
				    bill_detail bill_update = new bill_detail(test.generateInvoiceNumber(), insert_book.getIdBook(), insert_book.getCost(), Integer.valueOf(this.view.getInsert_numberBookField().getText()));
				    bill_detail_data.getInstance().insert(bill_update);
				}
			
			
		
		
		if (ac.equals("Xuất")) {
			this.view.getChangeLable().setText(String.valueOf(Double.valueOf(this.view.getInsert_costBookField().getText())-Double.valueOf(this.view.getTotalPriceLable().getText())));
			
			Set<String> liStrings = new HashSet<>();
			
			liStrings = bill_detail_data.getInstance().selectId();
			
			ArrayList<String> list = new ArrayList<>();
			list.addAll(liStrings);
			
			
			for (int i = 0; i < list.size(); i++) {
				long millis=System.currentTimeMillis();
				Date date = new Date(millis);
				bill bill_insert = new bill(list.get(i),date, Double.valueOf(this.view.getTotalPriceLable().getText()));
				bill_data.getInstance().insert(bill_insert);
			}
		
			
			DefaultTableModel model = (DefaultTableModel) this.view.getBillTable().getModel();
			model.setRowCount(0);
			
			ArrayList<bill> listTotal = new ArrayList<>();
			
			Double totalBill = 0.0;
			
			listTotal = bill_data.getInstance().selectAll();
			
			for (bill billCash : listTotal) {
				totalBill += billCash.getTotal_bill();
				System.out.println(billCash.getTotal_bill());
			}
			
			this.view.getTotalLable().setText(String.valueOf(totalBill));
			
		}

	}






	
	
}
