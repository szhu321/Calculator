import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{
	public Stage window;
	public Scene scene;
	public Group root;
	
	public static void main(String[] args)
	{
		int[][] array =
		{ 
			{1, 2, 4},
			{-3, 0, 3},
			{-4, -2, -1},
		};
		
//		System.out.println(Determinants.calculateDeterminant(array));
//		int[][] array2 = Determinants.getArrayAfterDelete(array, 0, 2);
		
		
		int[][] a1 = 
		{
			{0, 1, 3},
			{1, 1, 4},
			{2, 2, 2}
		};
		int[][] a2 = 
		{
			{1, 1, 3},
			{1, 2, 4},
			{4, 8, 1}
		};
		
		int[][] a3 =
		{
			{-2, -4, 9},
			{-4, -8, 17},
			{1, 2, -4}
		};
		
		int x = 14 * 3;
		System.out.println(x);
		Matrix m3 = new Matrix(a3);
		System.out.println(m3.getRREF());
		//m3.reducedRowEchelonForm();
		//System.out.println(m3.getInverseMatrix().getInverseMatrix());
		//System.out.println(Matrix.combineMatrix(new Matrix(a1), new Matrix(a2)));
		//System.out.println(Matrix.getIdentityMatrix(100));
		
		
//		for(double[] row: a3)
//		{
//			for(double col: row)
//			{
//				System.out.print(col + " ");
//			}
//			System.out.println();
//		}
		
//		double[][] d = new double[3][3];
//		Arrays.fill();
//		System.out.println("What is the default" + d[0][0]);
		
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception
	{
		window = arg0;
		root = new Group();
		scene = new Scene(root, 1000, 500);
		
		Button btn1 = new Button("Hello Boys");
		root.getChildren().add(btn1);
		BorderPane fxmlBP = FXMLLoader.load(getClass().getResource("/CalcDisplay.fxml"));
		scene.setRoot(fxmlBP);
		
		window.setScene(scene);
		window.show();
		window.close();
	}
}
