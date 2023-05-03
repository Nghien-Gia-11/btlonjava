package Main;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.sql.Date;

import Model.bill;
import Model.bill_detail;
import data_access_object.bill_data;
import data_access_object.bill_detail_data;

public class test_bill {
	public static void main(String[] args) {
		
		Set<String> liStrings = new HashSet<>();
		
		liStrings = bill_detail_data.getInstance().selectId();
		
		ArrayList<String> list = new ArrayList<>();
		list.addAll(liStrings);
		
		long millis=System.currentTimeMillis();
		Date date = new Date(millis);
		System.out.println(date);
		bill bil1 = new bill("out1", date, 100.00);
		System.out.println(list.get(0));
		for (int i = 0; i < list.size(); i++) {
			if (bil1.getId_out().equals(list.get(i))) {
				bill_data.getInstance().update(bil1);
			}
			else if (bil1.getId_out().equalsIgnoreCase(list.get(i))) {
				bill_data.getInstance().insert(bil1);
			}
		}
		
	}
}
