package brain;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.binding.DoubleExpression;

public class AlgEx {
	String eq;
	
	public AlgEx() {
		eq = "";
	}
	
	public void addChar(String ch) {
		// 0-9 after 0-9 or .
		if(ch.matches("[0-9]") && lastChar().matches("[0-9.]")) 
			eq = eq.concat(ch);
		// 0-9 after operator, or operator after 0-9
		else if(ch.matches("[×|÷|+|−]") && lastChar().matches("[0-9]") 
				|| ch.matches("[0-9]") && lastChar().matches("[×|÷|+|−]") ) 
			eq = eq.concat(" " + ch);
		// decimal, after 0-9 and only once per string
		else if(ch.equals(".")
				&& lastChar().matches("[0-9]") 
				&& !lastNum().contains("."))
			eq = eq.concat(".");
		// empty eq
		else if(eq.length() == 0 && ch.matches("[0-9.]")) 
			eq = ch;
	}
	
	public void removeChar() {
		if(eq.length() > 0) eq = eq.substring(0, eq.length() - 1).trim();
	}
	
	public String parse() {
		String equation = eq;
		ArrayList<String> eq = 
				new ArrayList<String>(Arrays.asList(equation.split(" ")));
		
		for(int i = 1; i < eq.size(); i++) {
			if(eq.get(i).matches("\\W")) {
				switch(eq.get(i)) {
					case("×"):
						eq.set(i - 1, Double.toString(Double.parseDouble(eq.get(i - 1)) 
								* Double.parseDouble(eq.get(i + 1))));
						eq.remove(i); eq.remove(i); i--;
						break;
					case("÷"):
						eq.set(i - 1, Double.toString(Double.parseDouble(eq.get(i - 1)) 
								/ Double.parseDouble(eq.get(i + 1))));
						eq.remove(i); eq.remove(i); i--;
						break;
				}
			}
		}
		
		for(int i = 1; i < eq.size(); i++) {
			if(eq.get(i).matches("\\W")) {
				switch(eq.get(i)) {
					case("+"):
						eq.set(i - 1, Double.toString(Double.parseDouble(eq.get(i - 1)) 
								+ Double.parseDouble(eq.get(i + 1))));
						eq.remove(i); eq.remove(i); i--;
						break;
					case("−"):
						eq.set(i - 1, Double.toString(Double.parseDouble(eq.get(i - 1)) 
								- Double.parseDouble(eq.get(i + 1))));
						eq.remove(i); eq.remove(i); i--;
						break;
				}
			}
		}
		
		this.eq = (Double.parseDouble(eq.get(0)) % 1 == 0) ? 
				Integer.toString(((Double) Double.parseDouble(eq.get(0))).intValue()) :
					Double.toString(Double.parseDouble(eq.get(0)));
		return this.eq;
	}
	
	public void invert() {
		if(eq.length() == 0) return;
		else if(Character.toString(lastNum().trim().charAt(0)).matches("[0-9]|-")
				&& lastChar().matches("[0-9]")) {
			String inverted = (Double.parseDouble(lastNum()) % 1 == 0) ? 
					Integer.toString(Integer.parseInt(lastNum()) * -1) :
						Double.toString(Double.parseDouble(lastNum()) * -1);
			eq = eq.substring(0, eq.length() - lastNum().length()) + inverted;
		}
	}
	
	public String lastChar() {
		if(eq.length() == 0) return "";
		return Character.toString(eq.charAt(eq.length() - 1));
	}
	
	public String lastNum() {
		String[] oprds = eq.split("[×|÷|+|−]");
		if(oprds.length == 0) return "";
		return oprds[oprds.length - 1].trim();
	}
	
	public void clear() {
		eq = "";
	}
	
	public String toString() {
		return eq;
	}
}
