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

public class AlertMessage extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/*
	 * This window is displayed when an error occurs by the user
	 * whether it was a wrong login code, withdrawing with insufficient funds
	 * or when there is no next or previous transaction history to navigate 
	 * the method takes two strings a title and a message suitable for each occasion
	 * 
	 */
	public static void display(String title , String message) {
		Stage window = new Stage();
		
		/*
		 * to make the user deal with the error window first by pressing OK or the X button
		 * and not be able to click on any button in the window they made the error in.
		 */
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(400);
		
		Label label = new Label();
		label.setText(message);
		Button returnButton = new Button("OK");
		returnButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label , returnButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
}
