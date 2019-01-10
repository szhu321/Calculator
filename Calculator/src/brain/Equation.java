package brain;

/**
 * Manages expression as well as evaluating them.
 * @author Endsider
 *
 */
public class Equation
{
	private String expression;
	
	/**
	 * Creates a empty expression.
	 */
	public Equation()
	{
		expression = "";
	}
	
	/**
	 * Adds a single character to the expression.
	 * @param character a single character.
	 * @return true if the character was successfully added. 
	 * false if the character wasn't successfully added.
	 */
	public boolean addCharacter(String character)
	{
		expression += character;
		return false;
	}
	
	/**
	 * checks to see if the next character can be a dot.
	 * @return True if dot is allowed.
	 * </br>
	 * False otherwise.
	 */
	private boolean isDotAllowed()
	{
		return false;
	}
	
	/**
	 * Checks to see if the last character is a evaluation symbol.
	 * @return True if the last character is a evaluation symbol.
	 * </br>
	 * False otherwise.
	 */
	private boolean isPreEvalSymobl()
	{
		String[] evalSymbol = {"+", "-", "÷", "×"};
		//if the expression is empty return false
		if(expression.length() == 0)
			return false;
		String lastChar = expression.substring(expression.length() - 1, expression.length());
		for(String str : evalSymbol)
			if(str.equals(lastChar))
				return true;
		return false;
	}
	
	/**
	 * @return True if the last character is a dot.
	 * </br>
	 * False otherwise.
	 */
	private boolean isPreCharDot()
	{
		if(expression.length() == 0)
			return false;
		if(expression.substring(expression.length() - 1, expression.length()).equals("."))
			return true;
		return false;
	}
	
	/**
	 * Gets the last number that appeared in the expression.
	 * @return The last real number.
	 * </br>
	 * Ex. expression = "2 + 2.3 - 2.132" returns "2.132"
	 * </br> 
	 * expression = "4.4 + 2." returns "2"
	 * </br>
	 * expression = "2 + 3.2 -" returns "3.2"
	 */
	public String getLastNumber()
	{
		if(expression.length() == 0)
			return "";
		int beginningIdx = 0;
		int endingIdx = 0;
		//finds the ending idx.
		for(int i = expression.length() - 1; i >= 0; i--)
		{
			String str = expression.substring(i, i + 1);
			try
			{
				Integer.parseInt(str);
				endingIdx = i;
				break;
			}
			catch(NumberFormatException ex)
			{
				continue;
			}
		}
		
		//todo:finsh this function.
		return "";
	}
	
	/**
	 * @return The expression of this class.
	 */
	public String getExpression()
	{
		return expression;
	}
	
	public String toString()
	{
		return expression;
	}
}
