package datatypes;
import java.util.Arrays;

import brain.Determinants;
import utilities.Util;

public class Matrix
{
	//private double[][] originalMatrix;
	private double[][] matrix;
	
	public Matrix(int row, int col)
	{
		matrix = new double[row][col];
	}
	
	public Matrix(int[][] m)
	{
		this(m.length, m[0].length);
		for(int row = 0; row < matrix.length; row++)
			for(int col = 0; col < matrix[0].length; col++)
				matrix[row][col] = m[row][col];
	}
	
	public Matrix(double[][] m)
	{
		this(m.length, m[0].length);
		for(int row = 0; row < matrix.length; row++)
			for(int col = 0; col < matrix[0].length; col++)
				matrix[row][col] = m[row][col];
				
	}
	
	public Matrix getInverseMatrix()
	{
		//if the determinant is not zero invert the matrix.
		//else don't
		if(getDeterminant() != 0)
		{
			//invert the matrix.
			Matrix bigMatrix = combineMatrix(this, getIdentityMatrix(matrix.length));
			bigMatrix = bigMatrix.getRREF();
			double[][] newMatrix = new double[matrix.length][matrix[0].length];
			for(int row = 0; row < matrix.length; row++)
			{
				for(int col = 0; col < matrix[0].length; col++)
				{
					newMatrix[row][col] = bigMatrix.getValue(row, col + matrix.length);
				}
			}
			return new Matrix(newMatrix);
		}
		return null;
	}
	
	public static Matrix combineMatrix(Matrix leftMatrix, Matrix rightMatrix)
	{
		if(leftMatrix.getRowSize() != rightMatrix.getRowSize())
			return null;
		int totalCols = leftMatrix.getColSize() + rightMatrix.getColSize();
		double[][] newMatrix = new double[leftMatrix.getRowSize()][totalCols];
		for(int row = 0; row < leftMatrix.getRowSize(); row++)
		{
			int currentColIdx = 0;
			for(int col = 0; col < leftMatrix.getColSize(); col++)
			{
				newMatrix[row][currentColIdx] = leftMatrix.getValue(row, col);
				currentColIdx++;
			}
			for(int col = 0; col < rightMatrix.getColSize(); col++)
			{
				newMatrix[row][currentColIdx] = rightMatrix.getValue(row, col);
				currentColIdx++;
			}
		}
		return new Matrix(newMatrix);
	}
	
	public static Matrix getIdentityMatrix(int size)
	{
		if(size < 1)
			return null;
		double[][] newMatrix = new double[size][size];
		for(int i = 0; i < size; i++)
		{
			newMatrix[i][i] = 1;
		}
		return new Matrix(newMatrix);
	}
	
	public double getDeterminant()
	{
		return Determinants.calculateDeterminant(matrix);
	}
	
	public void matrixMultiplication(Matrix m)
	{
		Util.matrixMultiplication(m.matrix, matrix);
	}
	
	public double[][] getMatrix()
	{
		return matrix;
	}
	
	public int getRowSize()
	{
		return matrix.length;
	}
	
	public int getColSize()
	{
		return matrix[0].length;
	}
	
	public double getValue(int row, int col)
	{
		return matrix[row][col];
	}
	
	public String toString()
	{
		String result = "";
		for(double[] row: matrix)
		{
			for(double num: row)
			{
				result += String.format("%7.3f ", num);
			}
			result += "\n";
		}
		return result;
	}
	
	public Matrix getRREF()
	{
		Matrix newM = clone();
		Util.RREF(newM.matrix);
		return newM;
	}
	
	public Matrix clone()
	{
		double[][] newMatrix = new double[matrix.length][matrix[0].length];
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				newMatrix[row][col] = matrix[row][col];
			}
		}
		return new Matrix(newMatrix);
	}
}
