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
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage arg0) throws Exception 
	{
		window = arg0;
		window.setTitle("Calculator");
		
		VBox vbox = new VBox();
		
		gridPane = new GridPane();
		root = new Group();
		root.getChildren().add(vbox);
		
		scene = new Scene(root, 640, 480);
		
		TextArea textArea = new TextArea();
		vbox.getChildren().add(textArea);
		vbox.getChildren().add(gridPane);
		
		createButtons();
		
		window.setScene(scene);
		window.show();
	}
	
	public void createButtons()
	{
		// numbers, row0
		Button sev = new Button("7"); gridPane.add(sev, 0, 0);
		Button eig = new Button("8"); gridPane.add(eig, 1, 0);
		Button nin = new Button("9"); gridPane.add(nin, 2, 0);
		// numbers, row1
		Button fou = new Button("4"); gridPane.add(fou, 0, 1);
		Button fiv = new Button("5"); gridPane.add(fiv, 1, 1);
		Button six = new Button("6"); gridPane.add(six, 2, 1);
		// numbers, row2
		Button one = new Button("1"); gridPane.add(one, 0, 2);
		Button two = new Button("2"); gridPane.add(two, 1, 2); 
		Button thr = new Button("3"); gridPane.add(thr, 2, 2);
		// row3
		Button zer = new Button("0"); gridPane.add(zer, 0, 3);
		Button dot = new Button("."); gridPane.add(dot, 1, 3);
		Button equ = new Button("="); gridPane.add(equ, 2, 3);
		
		// operators
		Button div = new Button("÷"); gridPane.add(div, 3, 0);
		Button mul = new Button("x"); gridPane.add(mul, 3, 1);
		Button sub = new Button("-"); gridPane.add(sub, 3, 2);
		Button add = new Button("+"); gridPane.add(add, 3, 3);
	}
}