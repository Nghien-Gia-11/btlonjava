package Model;

public class bill_detail {
	private String id_out;
	private String idBook_out;
	private double price;
	private int amount;


	public bill_detail() {
		super();
	}
	

	public bill_detail(String id_out, String idBook_out, double price, int amount) {
		super();
		this.id_out = id_out;
		this.idBook_out = idBook_out;
		this.price = price;
		this.amount = amount;
	}


	public String getId_out() {
		return id_out;
	}


	public void setId_out(String id_out) {
		this.id_out = id_out;
	}


	public String getIdBook_out() {
		return idBook_out;
	}


	public void setIdBook_out(String idBook_out) {
		this.idBook_out = idBook_out;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "bill_detail [id_out=" + id_out + ", idBook_out=" + idBook_out + ", price=" + price + ", amount="
				+ amount + "]" + "\n";
	}
	
	
	
	
	
}
