package main;

import brain.Equation;
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
	
	private Equation equation;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage arg0) throws Exception 
	{
		window = arg0;
		window.setTitle("Calculator");
		window.setResizable(false);
		
		equation = new Equation();
		
		VBox vbox = new VBox();
		vbox.getStyleClass().add("container");
		
		gridPane = new GridPane();
		root = new Group();
		root.getChildren().add(vbox);
		
		scene = new Scene(root, 410, 740);
		
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
		charBtn("7", 0, 0); charBtn("8", 1, 0); charBtn("9", 2, 0);		// row1
		charBtn("4", 0, 1); charBtn("5", 1, 1); charBtn("6", 2, 1);		// row2
		charBtn("1", 0, 2); charBtn("2", 1, 2); charBtn("3", 2, 2);		// row3
		charBtn("0", 0, 3); 												// row4
		
		charBtn(".", 1, 3);
		
		charBtn("÷", 3, 0); charBtn("×", 3, 1); charBtn("-", 3, 2); charBtn("+", 3, 3); // operators
		
		//others
		Button equ = new Button("="); gridPane.add(equ, 2, 3);
		Button bak = new Button("BAK"); gridPane.add(bak, 0, 4);
		bak.setOnAction(event ->
		{
			equation.removeCharacter(equation.getExpression().length() - 1);
			display();
		});
		Button clr = new Button("CLR"); gridPane.add(clr, 1, 4);
		clr.setOnAction(event -> 
		{
			equation.clear();
			display();
		});
	}
	
	public void charBtn(String s, int xpos, int ypos)
	{
		Button btn = new Button(s);
		gridPane.add(btn, xpos, ypos);
		btn.setOnAction(event -> 
		{
			String ch = ((Button)event.getSource()).getText();
			if(equation.addCharacter(ch))
				display();
			//textField.setText(textField.getText() + s));
		});
	}
	
	/**
	 * Displays the equation on the textField.
	 */
	public void display()
	{
		textField.setText(equation.getExpression());
	}
}