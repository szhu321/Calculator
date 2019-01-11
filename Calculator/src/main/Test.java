package main;

import java.util.Scanner;

import brain.Equation;

public class Test
{
	
	public static void main(String[] args)
	{
		Equation eq = new Equation();
		//System.out.println(" 3.He6lo".contains("."));
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Was added : " + eq.addCharacter(sc.next()));
			System.out.println("New Expression: " + eq);
		}
	}

}
