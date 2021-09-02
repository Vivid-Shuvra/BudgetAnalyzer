package DestinationPack;

public class tax {

private String type,date, name, father_husband, father_name, age, occupation, gender, reg_no, zone, contact_no, amount, address ;
	
	public tax(String type, String name, String father_husband, String father_name, String age,String occupation, String gender, String reg_no, String zone, String contact_no, String amount, String address, String date) {
		
		this.name = name;
		this.father_husband = father_husband;
		this.father_name = father_name;
		this.age = age;
		this.occupation = occupation;
		this.gender = gender;
		this.reg_no = reg_no;
		this.zone = zone;
		this.contact_no = contact_no;
		this.amount = amount;
		this.address = address;
		this.type = type;
		this.date = date;
	}
	
	public String getname() {
		return name;
	}
	
	public String getfather_husband() {
		return father_husband;
	}
	
	public String getfather_name() {
		return father_name;
	}
	
	public String getage() {
		return age;
	}
	
	public String getoccupation() {
		return occupation;
	}
	
	public String getgender() {
		return gender;
	}
	
	public String getreg_no() {
		return reg_no;
	}
	
	public String getzone() {
		return zone;
	}
	
	public String getcontact_no() {
		return contact_no;
	}
	
	public String getamount() {
		return amount;
	}
	
	public String getaddress() {
		return address;
	}
	
	public String gettype() {
		return type;
	}
	
	public String getdate() {
		return date;
	}
}

