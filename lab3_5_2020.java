import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

class lab3_5_2020
{
	public static void main(String[] args)
	{
		InputHandler mIn;
		PrintWriter mOut;
		
		if(args.length==2)
		{
			mIn = new InputHandler(args[0]);
			
			System.out.printf("File: %s\nOut: %s",args[0],args[1]);
			
			if(mIn.isFile())
			{
				try
				{
					mOut = new PrintWriter(args[1]);
				}
				catch(java.io.FileNotFoundException e)
				{
					mOut = new PrintWriter(System.out);
				}
				
				while(mIn.hasInput())
				{
						mOut.println(mIn.getInput());
				}
				
				mIn.close();
				mOut.close();
			}
			else
			{
				System.out.println("Invalid File");
			}
		}
		else
		{
			System.out.printf("Usage: %s file\n",lab3_5_2020.class);
		}
	}
}