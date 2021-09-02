package DestinationPack;

public class Expenditure {

private String type, item, amount, percentage ;
	
	public Expenditure(String type, String item, String amount, String percentage) {
		
		this.type = type;
		this.item = item;
		this.amount = amount;
		this.percentage = percentage;
	}
	
	public String gettype() {
		return type;
	}
	
	public String getitem() {
		return item;
	}
	
	public String getamount() {
		return amount;
	}
	
	public String getpercentage() {
		return percentage;
	}
	
}
	

