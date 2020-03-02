package cecs277.classes;

//TODO: javadocs and comment

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
	
	public String takeInput()
	{
		return sc.nextLine();
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
	
}
