package Model;

public class books {
	private String idBook;
	private String nameBook;
	private Double cost;
	private String typeBook;
	private String authorBook;
	private int number;
	private String publisher;
	private int yearPublisher;
	
	
	
	public books() {
		super();
	}


	public books(String idBook, String nameBook, Double cost, String typeBook, String authorBook, int number,
			String publisher, int yearPublisher) {
		super();
		this.idBook = idBook;
		this.nameBook = nameBook;
		this.cost = cost;
		this.typeBook = typeBook;
		this.authorBook = authorBook;
		this.number = number;
		this.publisher = publisher;
		this.yearPublisher = yearPublisher;
	}


	public String getIdBook() {
		return idBook;
	}


	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}


	public String getNameBook() {
		return nameBook;
	}


	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public String getTypeBook() {
		return typeBook;
	}


	public void setTypeBook(String typeBook) {
		this.typeBook = typeBook;
	}


	public String getAuthorBook() {
		return authorBook;
	}


	public void setAuthorBook(String authorBook) {
		this.authorBook = authorBook;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getYearPublisher() {
		return yearPublisher;
	}


	public void setYearPublisher(int yearPublisher) {
		this.yearPublisher = yearPublisher;
	}


	@Override
	public String toString() {
		return "books [idBook=" + idBook + ", nameBook=" + nameBook + ", cost=" + cost + ", typeBook=" + typeBook
				+ ", authorBook=" + authorBook + ", number=" + number + ", publisher=" + publisher + ", yearPublisher="
				+ yearPublisher + "]" + "\n";
		
	}
	
	
	
	
}
