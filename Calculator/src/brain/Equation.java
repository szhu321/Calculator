package brain;

/**
 * Manages expression as well as evaluating them.
 * @author Endsider
 *
 */
public class Equation
{
	public static final String[] evalSymbol = {"×", "÷", "−", "+"};
	
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
		if(character.length() != 1)
			return false;
		if(character.equals("."))
		{
			if(isDotAllowed())
			{
				expression += character;
				return true;
			}
			else
			{
				return false;
			}
		}
		//if the previous character and the current character is a evaluation symbol, change the previous symbol to the new one.
		if(isPreEvalSymobl() && isEvalSymbol(character))
			expression = expression.substring(0, expression.length() - 1) + character;
		else
			expression += character;
		return true;
	}
	
	/**
	 * Removes a character from the expression
	 * @param Index The position of the character to be removed.
	 * @return The character that was removed.
	 */
	public String removeCharacter(int idx)
	{
		if(expression.length() == 0)
			return "";
		String result = expression.substring(idx, idx + 1);
		if(idx == expression.length() - 1)
			expression = expression.substring(0, idx);
		else
			expression = expression.substring(0, idx) + expression.substring(idx + 1);
		return result;
	}
	
	/**
	 * Clears the expression
	 */
	public void clear()
	{
		expression = "";
	}
	
	/**
	 * checks to see if the next character can be a dot.
	 * @return True if dot is allowed.
	 * </br>
	 * False otherwise.
	 */
	private boolean isDotAllowed()
	{
		//if the previous character is a dot then the dot is not allowed.
		if(isPreCharDot())
			return false;
		//if the previous character is a evaluation symbol then the dot is allowed.
		if(isPreEvalSymobl())
			return true;
		//if the last number has a dot then another dot is not allowed.
		String lastNum = getLastNumber(expression);
		if(lastNum.contains("."))
			return false;
		return true;
	}
	
	/**
	 * Checks to see if the last character is a evaluation symbol.
	 * @return True if the last character is a evaluation symbol.
	 * </br>
	 * False otherwise.
	 */
	private boolean isPreEvalSymobl()
	{
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
	 * Checks to see if the character is a evaluation symbol.
	 * </br>
	 * Evaluation symbols: +, -, ÷, ×
	 * @param str
	 * @return
	 */
	public static boolean isEvalSymbol(String str)
	{
		if(str.length() != 1)
			return false;
		for(String symbol : evalSymbol)
		{
			if(str.equals(symbol))
				return true;
		}
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
	 * @return The last number.
	 * </br>
	 * Ex. expression = "2 + 2.3 - 2.132" returns "2.132"
	 * </br> 
	 * expression = "4.4 + 2." returns "2"
	 * </br>
	 * expression = "2 + .2 -" returns ".2"
	 */
	public static String getLastNumber(String str)
	{
		//If there is no string there is no number.
		if(str.length() == 0)
			return "";
		int beginningIdx = 0;
		int endingIdx = getIndexOfLastDigit(str);
		//If there is no last digit there is no number.
		if(endingIdx == -1)
			return "";
		for(int i = endingIdx - 1; i >= 0; i--)
		{
			String tempStr = str.substring(i, endingIdx + 1);
			try
			{
				//System.out.println("Expi: " + tempStr);
				Double.parseDouble(tempStr);
			}
			catch(NumberFormatException ex)
			{
				
				beginningIdx = i + 1;
				break;
			}
		}
		//System.out.println("begin: " + beginningIdx);
		//System.out.println("end: " + endingIdx);
		return str.substring(beginningIdx, endingIdx + 1);
	}
	
	/**
	 * Finds the index of the last occurrence of a digit.
	 * </br>
	 * Example: str = "January 10, 2019" returns 16
	 * @param str The string that will be searched.
	 * @return Index of last digit. If there is no digit return -1.
	 */
	public static int getIndexOfLastDigit(String str)
	{
		for(int i = str.length() - 1; i >= 0; i--)
		{
			String character = str.substring(i, i + 1);
			try
			{
				Integer.parseInt(character);
				return i;
			}
			catch(NumberFormatException ex)
			{
				continue;
			}
		}
		return -1;
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
