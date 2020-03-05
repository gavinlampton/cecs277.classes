/*Gavin Lampton, Alfonso Villalobos
 * March 5, 2020
 * Purpose: This program is used to take input.
 * Inputs: The user's input.
 * Outputs: The user's input.
 */

//We can change between either of these implementations at any time without changing anything else.
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

public class InputHandler {
	
	private Scanner sc;
	private BufferedReader br;
	private File f;
	private boolean isFile;
	
	InputHandler()
	{
		sc = new Scanner(System.in);
	}
	
	InputHandler(String source)
	{
		f = new File(source);
		
		try
		{
			sc = new Scanner(f);
			isFile = true;
		}
		catch(java.io.FileNotFoundException e)
		{
			isFile = false;
			sc = new Scanner(System.in);
		}
	}
	
	/**
	 * Takes input.
	 * @return input.
	 */
	public String takeInput()
	{
		if(hasInput())
		{
			return sanitizeInput(sc.nextLine());
		}
		else
		{
			return "";
		}
	}
	
	public boolean isFile()
	{
		return isFile;
	}
	
	public void close()
	{
		if(isFile)
		{
			sc.close();
		}
	}
	
	public boolean hasInput()
	{
		if(isFile)
		{
			return sc.hasNext();
		}
		else
		{
			return true;
		}
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