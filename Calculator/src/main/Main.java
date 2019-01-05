package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
	private Stage window;
	private Scene scene;
	private Group root;
	private GridPane gridPane;
	private TextField textField;
	private TextArea textArea;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage arg0) throws Exception 
	{
		window = arg0;
		window.setTitle("Calculator");
		window.setResizable(false);
		
		VBox vbox = new VBox();
		vbox.getStyleClass().add("container");
		
		gridPane = new GridPane();
		root = new Group();
		root.getChildren().add(vbox);
		
		scene = new Scene(root, 410, 640);
		
		//adding CSS
		scene.getStylesheets().add("file:stylesheets/calculator.css");
		
		textField = new TextField();
		//adding a styleClass to the textField.
		textField.getStyleClass().add("inputBox");
		
		textField.setEditable(false);
		
		textArea = new TextArea();
		textArea.getStyleClass().add("displayBox");
		textArea.setEditable(false);
		
		vbox.getChildren().add(textArea);
		vbox.getChildren().add(textField);
		vbox.getChildren().add(gridPane);
		
		calcButtons();
		
		window.setScene(scene);
		window.show();
	}
	
	public void calcButtons()
	{
		numBtn("7", 0, 0); numBtn("8", 1, 0); numBtn("9", 2, 0);		// row1
		numBtn("4", 0, 1); numBtn("5", 1, 1); numBtn("6", 2, 1);		// row2
		numBtn("1", 0, 2); numBtn("2", 1, 2); numBtn("3", 2, 2);		// row3
		numBtn("0", 0, 3); 												// row4
		
		opBtn(".", 1, 3);
		Button equ = new Button("="); gridPane.add(equ, 2, 3);
		
		opBtn("÷", 3, 0); opBtn("×", 3, 1); opBtn("-", 3, 2); opBtn("+", 3, 3); // operators
	}
	
	public void numBtn(String s, int xpos, int ypos)
	{
		Button btn = new Button(s);
		gridPane.add(btn, xpos, ypos);
		btn.setOnAction(event -> textField.setText(textField.getText() + s));
	}
	
	public void opBtn(String s, int xpos, int ypos)
	{
		Button btn = new Button(s);
		gridPane.add(btn, xpos, ypos);
		btn.setOnAction(event -> {
			String ch = textField.getText().substring(textField.getText().length() - 1);
			try 
			{
				if(ch.equals("."))
				{
					//prevents multiple dots.
					if(!s.equals("."))
						textField.setText(textField.getText() + s);
				}
				else
				{
					Integer.parseInt(ch);
					textField.setText(textField.getText() + s);
				}
			} catch(NumberFormatException e) {
				textField.setText(textField.getText().substring(0, textField.getText().length() - 1) + s);
			}
		});
	}
}