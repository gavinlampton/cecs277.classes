/*Gavin Lampton, Alfonso Villalobos
 * March 5, 2020
 * Purpose: This program is used to take input.
 * Inputs: The user's input.
 * Outputs: The user's input.
 */

package cecs277.classes;

//We can change between either of these implementations at any time without changing anything else.
import java.util.Scanner;
import java.io.BufferedReader;

public class InputHandler {
	
	private Scanner sc;
	private BufferedReader br;
	
	InputHandler()
	{
		sc = new Scanner(System.in);
	}
	
	/**
	 * Takes input.
	 * @return input.
	 */
	public String takeInput()
	{
		return sanitizeInput(sc.nextLine());
	}
	
	/**
	 * Gives object name
	 * @return object name.
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	/*-----private--------*/
	
	private String sanitizeInput(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		
		for(int x = 0; x < sb.length(); x++)
		{
			if(sb.charAt(x)=='"')
			{
				if(sb.charAt(x-1)!='\\')
				{
					sb.insert(x-1, '\\');
				}
			}
			
		}
		
		return sb.toString();
	}
	
}