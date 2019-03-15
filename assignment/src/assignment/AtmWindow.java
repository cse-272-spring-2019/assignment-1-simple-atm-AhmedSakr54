package assignment;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.scene.control.Label;

public class AtmWindow extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void display(Stage primaryStage , Client client , History history) {
		
		TransactionWindow transactionWindow = new TransactionWindow();
		
		
		//Start drawing...
		primaryStage.setTitle("Atm Window");
		primaryStage.setMaxHeight(300);
		primaryStage.setMaxWidth(450);
		Button withdrawBtn = new Button("Withdraw");
		Button depositBtn = new Button("Deposit");
		Button currentBalanceBtn = new Button("Balance inquery");
		Button prevBtn = new Button("Prev");
		Button nextBtn = new Button("Next");
		
		Label messageLabel = new Label();
		
		StackPane root = new StackPane();
		root.getChildren().addAll(withdrawBtn,depositBtn,currentBalanceBtn,prevBtn,nextBtn,messageLabel);
		root.setAlignment(Pos.CENTER_LEFT);
		
		StackPane.setMargin(withdrawBtn, new Insets(0,0,150,0));
		StackPane.setMargin(depositBtn, new Insets(0,0,75,0));
		StackPane.setMargin(currentBalanceBtn, new Insets(0,0,0,0));
		StackPane.setMargin(prevBtn, new Insets(75,0,0,0));
		StackPane.setMargin(nextBtn, new Insets(150,0,0,0));
		StackPane.setMargin(messageLabel, new Insets(0,0,0,175));
		
		withdrawBtn.setMaxWidth(150);
		depositBtn.setMaxWidth(150);
		currentBalanceBtn.setMaxWidth(150);
		prevBtn.setMaxWidth(150);
		nextBtn.setMaxWidth(150);
		messageLabel.setMaxSize(320, 320);
		
		
		messageLabel.setStyle("-fx-font: 18 arial;");
		
		//End drawing...
		
		//Implementation of button actions...
		currentBalanceBtn.setOnAction(e ->{
			messageLabel.setText("Current Balance: "+client.getBalance());
			history.sethistoryIndex(history.getHistory().size());
			String balance = client.getBalance();
			history.handleHistory(client, balance, "Balance Inquery");//to put the balance inquiry in the history
		});
		withdrawBtn.setOnAction(e ->{
			history.sethistoryIndex(history.getHistory().size());
			messageLabel.setText("");
			transactionWindow.display(client , "Withdraw" , history);
		});
		depositBtn.setOnAction(e ->{
			history.sethistoryIndex(history.getHistory().size());
			messageLabel.setText("");
			transactionWindow.display(client , "Deposit" , history);
		});
		prevBtn.setOnAction(e -> {
			
			history.sethistoryIndex(history.getHistoryIndex()-1);
			messageLabel.setText(history.prev(history.getHistoryIndex()));
		});
		nextBtn.setOnAction(e -> {
			history.sethistoryIndex(history.getHistoryIndex()+1);
			messageLabel.setText(history.next(history.getHistoryIndex()));
		});
		
		//Show scene
		Scene scene = new Scene(root , 600 , 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
}
