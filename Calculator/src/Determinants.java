
public class Determinants
{
	
	public static double calculateDeterminant(double[][] array)
	{
		//the matrix has to be a square matrix.
		if(array.length != array[0].length)
			return 0;
		if(array.length == 0)
			return 0;
		if(array.length == 1)
			return array[0][0];
		if(array.length == 2)
			return array[0][0] * array[1][1] - array[0][1] * array[1][0];
		double result = 0;
		for(int i = 0; i < array.length; i++)
		{
			double oneRow = Math.pow(-1, i) * array[0][i] * calculateDeterminant(getArrayAfterDelete(array, 0, i));
			result += oneRow;
			//System.out.println(i);
			//System.out.println(i + "th row: " + oneRow);
		}
		return result;
	}
	
	public static double[][] getArrayAfterDelete(double[][] array, int row, int col)
	{
		double[][] result = new double[array.length - 1][array.length - 1];
		for(int i = 0; i < array.length; i++)
			if(i != row)
				for(int j = 0; j < array[0].length; j++)
					if(j != col)
						if(i < row && j < col)
							result[i][j] = array[i][j];
						else if(i < row && j > col)
							result[i][j - 1] = array[i][j];
						else if(i > row && j < col)
							result[i - 1][j] = array[i][j];
						else 
							result[i - 1][j - 1] = array[i][j];
		return result;
	}
}
