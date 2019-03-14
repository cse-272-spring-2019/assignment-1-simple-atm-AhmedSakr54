package assignment;
import javafx.application.*;

public class Client {
	private String balance;
	private String code;
	
	// is false when the user enters a value bigger than what was in their balance
	private boolean insufficientFunds = true;
	
	
	//Constructor of Client class
	public Client(String balance , String code){
		this.balance = balance;
		this.code = code;
	}
	
	// Client class getters
	public boolean getInsufficientFunds() {
		return this.insufficientFunds;
	}
	public String getBalance() {
		return this.balance;
	}

	public String getCode() {
		return this.code;
	}
	
	//Client class setters
	public void setInsuffienetFunds(boolean answer) {
		this.insufficientFunds = answer;
	}
	public void setBalance(String initialBalance) {
		this.balance = initialBalance;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	//Client behaviours
	
	public void withdraw(String amount) {
		
		if(Integer.parseInt(this.balance) < Integer.parseInt(amount)){
			insufficientFunds = false;
			AlertMessage.display("Alert", "Insufficient funds");
			}
		else {
			int newBalance = Integer.parseInt(this.balance) - Integer.parseInt(amount);
			this.balance = Integer.toString(newBalance);
		}		
	}
	public void deposit(String amount) {
		
		int newBalance = Integer.parseInt(this.balance) + Integer.parseInt(amount); 
		this.balance = Integer.toString(newBalance);
	}
	
}
