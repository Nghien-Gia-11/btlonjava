package Model;

import java.sql.Date;

public class bill {
	private String id_out;
	private Date date;
	private double total_bill;
	
	
	public bill() {
		super();
	}


	public bill(String id_out, Date date, double total_bill) {
		super();
		this.id_out = id_out;
		this.date = date;
		this.total_bill = total_bill;
	}


	public String getId_out() {
		return id_out;
	}


	public void setId_out(String id_out) {
		this.id_out = id_out;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	
	public double getTotal_bill() {
		return total_bill;
	}


	public void setTotal_bill(double total_bill) {
		this.total_bill = total_bill;
	}
	
	
	@Override
	public String toString() {
		return "bill [id_out=" + id_out + ", date=" + date + ", total_bill=" + total_bill + "]";
	}


	
	
	
	
}