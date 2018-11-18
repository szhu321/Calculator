package datatypes;

public class Vector2
{
	private double x;
	private double y;
	
	public Vector2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
}
