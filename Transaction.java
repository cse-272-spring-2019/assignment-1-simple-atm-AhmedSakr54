package assignment;

public class Transaction {
	private String value;
	private String type;
	
	public Transaction() {
	};
	
	public Transaction(String value , String type) {
		this.value = value;
		this.type = type;
	}
	
	//Transaction getters
	
	public String getValue() {
		return this.value;
	}
	public String getType() {
		return this.type;
	}
	
	//Transaction setters
	
	public void setValue(String value) {
		this.value = value;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
