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
		
		System.out.println(eq.toString());
		
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
		
		System.out.println(eq.toString());
		if(Double.parseDouble(eq.get(0)) % 1 == 0) 
			return eq.get(0).substring(0, eq.get(0).indexOf('.'));
		return eq.get(0);
	}
	
	public void invert() {
		if(eq.length() == 0) return;
		if(Character.toString(lastNum().charAt(0)).matches("[0-9]|-")) {
			Double invD = Double.parseDouble(lastNum()) * -1;
			Integer invI = invD.intValue();
			String inverted = (invD == Math.floor(invD)) ? Integer.toString(invI) : Double.toString(invD);
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
