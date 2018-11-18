
public class Util
{
	public static int[][] matrixMultiplication(int[][] m1, int[][] m2)
	{
		int[][] result = new int[m1.length][m2[0].length];
		for(int row = 0; row < m1.length; row++)
		{
			for(int col = 0; col < m2[0].length; col++)
			{
				int sum = 0;
				for(int i = 0; i < m2.length; i++)
				{
					sum += m1[row][i] * m2[i][col];
				}
				result[row][col] = sum;
			}
		}
		return result;
	}
	
	public static double[][] matrixMultiplication(double[][] m1, double[][] m2)
	{
		double[][] result = new double[m1.length][m2[0].length];
		for(int row = 0; row < m1.length; row++)
		{
			for(int col = 0; col < m2[0].length; col++)
			{
				int sum = 0;
				for(int i = 0; i < m2.length; i++)
				{
					sum += m1[row][i] * m2[i][col];
				}
				result[row][col] = sum;
			}
		}
		return result;
	}
	
	public static double[][] inverseMatrix(double[][] m)
	{
		if(m.length != m[0].length)
			return null;
		
		
		return null;
	}
	
	public static void RREF(double[][] m)
	{
		int currentRow = 0;
		for(int col = 0; col < m[0].length; col++)
		{
			double currentPivot = m[currentRow][col];
			if(currentPivot == 0)
			{
				//its time to swapRows boys!
				for(int r = currentRow + 1; r < m.length; r++)
				{
					//if this row has a non zero pivot swap.
					if(m[r][col] != 0)
					{
						swapRows(m, currentRow, r);
						break;
					}
				}
				//its time to check if the new pivot is also 0.
				currentPivot = m[currentRow][col];
				if(currentPivot == 0)
				{
					//if its still 0 then this col is done :D
					continue;
				}
			}
			//now that we done checking for 0. Is the pivot a one???
			if(currentPivot != 1)
			{
				//if its not a one we got to make it yeah!
				//thank god we got the perfect function for that :D
				reduceRow(m, currentRow);
			}
			//one the row is nicely reduced we make the top and bottom zeros.
			//oh look we have another amazing function. XD
			makeTopDownOfColZeroWithGivenRow(m, col, currentRow);
			//once this row is totally done we increase the rowCounter.
			//but wait if there is no more rows we have to stop!
			if(++currentRow >= m.length)
				break;
		}
	}
	
	public static boolean isDiagonalAllOnes(double[][] m)
	{
		int dag = 0;
		int shortSide = m.length >= m[0].length ? m[0].length : m.length;
		while(shortSide > dag)
		{
			if(m[dag][dag] != 1 && m[dag][dag] != 0)
				return false;
			dag++;
		}
		return true;
	}
	
	public static boolean isREF(double[][] m)
	{
		for(int row = 0; row < m.length; row++)
		{
			if(doesRowHavePivot(m, row)) // incomplete)
			{
				
			}
		}
		return false;
	}
	
	public static boolean doesRowHavePivot(double[][] m, int row)
	{
		for(double num: m[row])
		{
			if(num == 0)
				continue;
			if(num == 1)
				return true;
			return false;
		}
		return false;
	}
	
	public static boolean doesColumnHavePivot(double[][] m, int col)
	{
		for(int i = 0; i < m.length; i++)
		{
			double num = m[col][i];
			if(num == 0)
				continue;
			if(num == 1)
				return true;
			return false;
		}
		return false;
	}
	
	//Swap two rows in a 2D array.
	public static void swapRows(double[][] obj, int row1, int row2)
	{
		double[] temp = obj[row1];
		obj[row1] = obj[row2];
		obj[row2] = temp;
	}
	
	//reduces the row indicated by dividing the row by a number to get a pivot.
	public static void reduceRow(double[][] m, int rowNum)
	{
		double divisor = 1;
		double[] row = m[rowNum];
		boolean pivotFound = false;
		for(int i = 0; i < row.length; i++)
		{
			if(!pivotFound && row[i] != 0)
			{
				divisor = row[i];
				pivotFound = true;
			}
			row[i] = row[i] / divisor;
		}
	}
	
	public static void addRowMultiple(double[][] m, int addTo, int addFrom, double multiple)
	{
		for(int i = 0; i < m[0].length; i++)
		{
			m[addTo][i] += m[addFrom][i] * multiple;
		}
	}
	
	public static void makeTopDownOfColZeroWithGivenRow(double[][] m, int col, int row)
	{
		double pivot = m[row][col];
		if(pivot == 0)
			return;
		for(int r = 0; r < m.length; r++)
		{
			if(r == row)
			{
				continue;
			}
			double multiple = -1 * m[r][col] / pivot;
			addRowMultiple(m, r, row, multiple);
		}
	}
}
