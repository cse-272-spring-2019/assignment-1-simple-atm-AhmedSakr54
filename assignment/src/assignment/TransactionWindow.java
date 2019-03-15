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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.*;

public class TransactionWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void display(Client client , String transactionMethod , History history) {
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(transactionMethod + " window");
		window.setMinWidth(350);
		
		
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button zero = new Button("0");
		Button clear = new Button("Clear");
		Button continueBtn = new Button("Continue");
		
		Label transactionAmount = new Label();
		
		StackPane root = new StackPane();
		root.getChildren().addAll(one,two,three,four,five,six,seven,eight,nine,zero,clear,continueBtn,transactionAmount);
		root.setAlignment(Pos.BOTTOM_LEFT);
		
		//Drawing the ATM numPad.........
		one.setMaxSize(60, 60);
		two.setMaxSize(60, 60);
		three.setMaxSize(60, 60);
		four.setMaxSize(60, 60);
		five.setMaxSize(60, 60);
		six.setMaxSize(60, 60);
		seven.setMaxSize(60, 60);
		eight.setMaxSize(60, 60);
		nine.setMaxSize(60, 60);
		zero.setMaxSize(60, 60);
		clear.setMaxSize(120, 75);
		transactionAmount.setMaxSize(180, 60);
		continueBtn.setMaxSize(120, 75);
		
		one.setStyle("-fx-font: 24 arial;");
		two.setStyle("-fx-font: 24 arial;");
		three.setStyle("-fx-font: 24 arial;");
		four.setStyle("-fx-font: 24 arial;");
		five.setStyle("-fx-font: 24 arial;");
		six.setStyle("-fx-font: 24 arial;");
		seven.setStyle("-fx-font: 24 arial;");
		eight.setStyle("-fx-font: 24 arial;");
		nine.setStyle("-fx-font: 24 arial;");
		clear.setStyle("-fx-font: 15 arial;");
		zero.setStyle("-fx-font: 24 arial;");
		transactionAmount.setStyle("-fx-font: 24 sans;");
		continueBtn.setStyle("-fx-font: 15 arial;");
		
		StackPane.setMargin(one,new Insets(0,0, 180, 0));
		StackPane.setMargin(two,new Insets(0, 0, 180, 60));
		StackPane.setMargin(three,new Insets(0,0, 180, 120));
		StackPane.setMargin(four,new Insets(0, 0, 120, 0));
		StackPane.setMargin(five,new Insets(0, 0, 120, 60));
		StackPane.setMargin(six,new Insets(0, 0, 120, 120));
		StackPane.setMargin(seven,new Insets(0, 0, 60, 120));
		StackPane.setMargin(eight,new Insets(0, 0, 60, 60));
		StackPane.setMargin(nine,new Insets(0, 0, 60, 0));
		StackPane.setMargin(zero,new Insets(0, 0, 0, 60));
		StackPane.setMargin(clear, new Insets(0,0,80,200));
		StackPane.setMargin(transactionAmount, new Insets(0,0,240,0));
		StackPane.setMargin(continueBtn, new Insets(0,0,0,200));
		//End Drawing....
		
		//Actions on the Buttons....
		one.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"1");
		});
		two.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"2");
		});
		three.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"3");
		});
		four.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"4");
		});
		five.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"5");
		});
		six.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"6");
		});
		seven.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"7");
		});
		eight.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"8");
		});
		nine.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"9");
		});
		zero.setOnAction(e ->{
			transactionAmount.setText(transactionAmount.getText() +"0");
		});
		
		clear.setOnAction(e ->{
			transactionAmount.setText("");
		});
		
		continueBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(transactionMethod.equals("Withdraw")) {
					history.handleHistory(client , transactionAmount.getText() , "Withdraw");
					window.close();
				}
				else {
					history.handleHistory(client , transactionAmount.getText() , "Deposit");
					window.close();
				}
				
			}
		});
		
		//Building the new Scene
		Scene scene = new Scene(root,300,300);
		window.setScene(scene);
		window.showAndWait();
	}

}
