package Model;

public class nhanvien {
	private String manv;
	private String name_nv;
	private String address_nv;
	private String phone_number_nv;
	private int age_nv;
	
	public nhanvien() {
		super();
	}
	
	public nhanvien(String manv, String name_nv, String address_nv, String phone_number_nv, int age_nv) {
		super();
		this.manv = manv;
		this.name_nv = name_nv;
		this.address_nv = address_nv;
		this.phone_number_nv = phone_number_nv;
		this.age_nv = age_nv;
	}




	public String getManv() {
		return manv;
	}
	
	public void setManv(String manv) {
		this.manv = manv;
	}
	
	public String getName_nv() {
		return name_nv;
	}
	
	public void setName_nv(String name_nv) {
		this.name_nv = name_nv;
	}
	
	public String getAddress_nv() {
		return address_nv;
	}
	
	public void setAddress_nv(String address_nv) {
		this.address_nv = address_nv;
	}
	
	public String getPhone_number_nv() {
		return phone_number_nv;
	}
	
	public void setPhone_number_nv(String phone_number_nv) {
		this.phone_number_nv = phone_number_nv;
	}
	
	public int getAge_nv() {
		return age_nv;
	}
	
	public void setAge_nv(int age_nv) {
		this.age_nv = age_nv;
	}
	
	
	
	@Override
	public String toString() {
		return "nhanvien [manv=" + manv + ", name_nv=" + name_nv + ", address_nv=" + address_nv + ", phone_number_nv="
				+ phone_number_nv + ", age_nv=" + age_nv + "]";
	}
	
	
	
	
	
}
