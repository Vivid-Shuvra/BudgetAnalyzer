package DestinationPack;

public class Loan {
private String type, date, company_name, company_des, country_name, purpose, deadline, contact_no, amount, comment ;
	
	public Loan(String type, String company_name, String company_des, String country_name,String purpose, String deadline,  String contact_no, String amount, String comment, String date) {
		
		this.type = type;
		this.company_name = company_name;
		this.company_des = company_des;
		this.country_name = country_name;
		this.purpose = purpose;
		this.deadline = deadline;
		this.contact_no = contact_no;
		this.amount = amount;
		this.comment = comment;
		this.date = date;
	}
	
	public String gettype() {
		return type;
	}
	
	public String getcompany_name() {
		return company_name;
	}
	
	public String getcompany_des() {
		return company_des;
	}
	
	public String getcountry_name() {
		return country_name;
	}
	
	public String getpurpose() {
		return purpose;
	}
	
	public String getdeadline() {
		return deadline;
	}
	
	public String getamount() {
		return amount;
	}
	
	public String getcomment() {
		return comment;
	}
	
	public String getcontact_no() {
		return contact_no;
	}
	
	public String getdate() {
		return date;
	}
}
