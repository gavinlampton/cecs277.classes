class lab3_5_2020
{
	public static void main(String[] args)
	{
		InputHandler in;
		if(args.length==1)
		{
			in = new InputHandler(args[0]);
			
			System.out.printf("File: %s\n",args[0]);
			
			if(in.isFile())
			{
				while(in.hasInput())
				{
					System.out.println(in.takeInput());
				}
				
				in.close();
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