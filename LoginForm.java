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
import javafx.scene.*;
/**
 * This application is a Simple ATM that works on a single user with initial balance = 0 
 * The user's login code is 5463
 * the ATM is used to display the current balance, deposit, withdraw and traverse history of the 
 * last 5 transactions
 */
public class LoginForm extends Application {
	
	/**
	 *	This class acts as the builder class (main class) as it contains the main method.
	 * 	from it the whole program starts 
	 */
	public static void main(String[] args) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AtmWindow atmWindow = new AtmWindow() ;
		History history = new History();
		Client client = new Client("0" , "5463");
		Button submit  = new Button ("Login");
		Label messageLabel  = new Label ("Enter your code");
		PasswordField passwordField = new PasswordField();
		
		passwordField.setMaxWidth(250);
		
		//Actions of the button
		submit.setOnAction(e -> {
			if(!passwordField.getText().equals(client.getCode())) {
				AlertMessage.display("Alert", "Wrong Code");
			} else
				try {
					atmWindow.display(primaryStage,client,history);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		});
		
		//Drawing of the Scene...
		primaryStage.setTitle("Login Window");
		StackPane root = new StackPane();
		root.getChildren().addAll(submit,messageLabel,passwordField);
		root.setAlignment(Pos.CENTER);
		
		StackPane.setMargin(passwordField, new Insets(0, 0, 100, 0));
		StackPane.setMargin(messageLabel, new Insets(100, 0, 0, 0));
		StackPane.setMargin(submit, new Insets(0, 0, 0, 0));
		
		Scene scene = new Scene(root,400,300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
