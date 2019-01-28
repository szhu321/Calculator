package brain;

import java.util.ArrayList;
import java.util.Arrays;

public class EquationProcessor {
	String equation;
	
	public EquationProcessor() {
		equation = "";
	}
	
	public String process(String equation) {
		this.equation = equation;
		ArrayList<String> eq = 
				new ArrayList<String>(Arrays.asList(equation.split(" ")));
		
		System.out.println(eq.toString());
		
		// MD pemdas
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
		
		// AS pemdas
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
				i--;
			}
		}
		
		System.out.println(eq.toString());
		if(Double.parseDouble(eq.get(0)) % 1 == 0) 
			return eq.get(0).substring(0, eq.get(0).indexOf('.'));
		return eq.get(0);
	}
}
