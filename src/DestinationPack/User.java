package DestinationPack;

public class User {
	private String year, amount , revenue, expenditure, access, comment;
	
	public User(String year, String amount, String revenue, String expenditure, String access, String comment ) {
		
		this.year = year;
		this.amount = amount;
		this.revenue = revenue;
		this.expenditure = expenditure;
		this.access = access;
		this.comment = comment;
	}
	
	public String getyear() {
		return year;
	}
	
	public String getamount() {
		return amount;
	}
	
	public String getrevenue() {
		return revenue;
	}
	
	public String getexpenditure() {
		return expenditure;
	}
	
	public String getaccess() {
		return access;
	}
	
	public String getcomment() {
		return comment;
	}
	

}

