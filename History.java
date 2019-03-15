package assignment;
import java.util.ArrayList;
public class History {
	
	private ArrayList<Transaction> history = new ArrayList<>();
	private int historyIndex = 0; // acts as a pointer to the transactions for history navigation
	
	
	public ArrayList<Transaction> getHistory(){
		return this.history;
	}
	
	public void addHistory(Transaction transaction) {
		this.history.add(transaction);
		this.historyIndex++;
	}
	
	public void sethistoryIndex(int index) {
		this.historyIndex = index;
	}
	public int getHistoryIndex() {
		return this.historyIndex;
	}
	
	//History navigation....
	public String prev(int historyIndex) {
		if(history.size() > 0) {
			if(historyIndex >= 0 && historyIndex < history.size()) {
				String message;
				message = this.history.get(this.historyIndex).getType() + " : " + this.history.get(this.historyIndex).getValue() ;
				return message;
			}
			else {
				this.historyIndex++;
				AlertMessage.display("Alert", "No more saved history");
				return this.history.get(this.historyIndex).getType() + " : " + this.history.get(this.historyIndex).getValue() ;
			}
			}
			else {
				this.historyIndex++;
				AlertMessage.display("Alert", "No more saved history");
				return null;
				}
	}
	
	public String next(int historyIndex) {
		if(history.size() > 0 && historyIndex-1 < history.size()) {
			if(historyIndex < history.size() && historyIndex >= 0) {
				String message;
				message = this.history.get(this.historyIndex).getType() + " : " + this.history.get(this.historyIndex).getValue() ;
				return message;
			}
			else {
				this.historyIndex--;
				AlertMessage.display("Alert", "No further history");
				return this.history.get(this.historyIndex).getType() + " : " + this.history.get(this.historyIndex).getValue() ;
			}
		}
		else {
			this.historyIndex--;
			AlertMessage.display("Alert", "No further history");
			return null;
		}
	}
	
	
	//Handling history....
	public void handleHistory(Client client , String amount , String type) {

		if(!amount.equals("") && amount.charAt(0) != '0' || type.equals("Balance Inquery")) {
			//to make the history navigate only the last 5 transactions 
			if(history.size() >= 5) {
				history.remove(0);
				historyIndex = 4;
			}
			if(type.equals("Balance Inquery"))
				historyIndex--;
			if(type.equals("Withdraw")) {
				client.withdraw(amount);
			}
			else if(type.equals("Deposit"))
				client.deposit(amount);
		
			if(client.getInsufficientFunds()) {
				Transaction transaction = new Transaction();
				transaction.setType(type);
				transaction.setValue(amount);
				addHistory(transaction);
			}
			else 
				client.setInsuffienetFunds(true);
			}
		else 
			AlertMessage.display("Alert", "Invalid transaction amount");
		
	}
	
}
