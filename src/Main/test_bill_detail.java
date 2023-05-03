package Main;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Model.bill;
import Model.bill_detail;
import data_access_object.bill_data;
import data_access_object.bill_detail_data;	

public class test_bill_detail {
	public static void main(String[] args) {
		bill_detail bill_detail1 = new bill_detail("out1", "15", 20.00, 2);
		//bill_detail_data.getInstance().insert(bill_detail1);
//		bill_detail1.setId_out("out3");
//		System.out.println(bill_detail_data.getInstance().selectById(bill_detail1));
		
		Set<String> liStrings = new HashSet<>();
		
		liStrings = bill_detail_data.getInstance().selectId();
		
		ArrayList<String> list = new ArrayList<>();
		list.addAll(liStrings);
		
		
		ArrayList<bill_detail> list1 = new ArrayList<>();
		list1 = bill_detail_data.getInstance().selectAll();	
		int[] sum = new int[list.size()];
		for (int i : sum) {
			i = 0;
		}

		
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < list1.size(); j++) {
				if (list.get(i).equals(list1.get(j).getId_out()) ) {
					sum[i] += list1.get(j).getAmount() * list1.get(j).getPrice();
				}
			}
			System.out.println(sum[i]);
		}
		
		for(int i=0;i<sum.length;i++) {
			System.out.println(list.get(i) + " = " + sum[i]);
		}
		
		Date date = new Date();
		
		System.out.println(date);
	}
}
