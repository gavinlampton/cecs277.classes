package cecs277.classes;


//This class has all the functionality for Coin and Product
public class ValuedItem {

	protected String mName;
	protected double mBaseValue;
	protected int mAmount;
	
	ValuedItem()
	{
		mName = "";
		mBaseValue = 0;
		mAmount = 0;
	}
	
	ValuedItem(String name, double baseValue, int amount)
	{
		mName=name;
		
		if(baseValue>0)
		{
			mBaseValue = baseValue;
		}
		else
		{
			mBaseValue = 0;
		}
		
		if(amount>0)
		{
			mBaseValue = amount;
		}
		else
		{
			amount = 0;
		}
		
	}
	
	public double getValue()
	{
		return mBaseValue*mAmount;
	}
	
	public void add(int amount)
	{
		if(amount>0)
		{
			mAmount += amount;
		}
	}
	
	public void remove(int amount)
	{
		if(mAmount>=amount&&amount>0)
		{
			mAmount-=amount;
		}
	}
	
	@Override
	public String toString()
	{
		return String.format("%d %s @ %0.f", mAmount, getNamePlural(), getValue());
	}
	
	//This method isn't really necessary but I made it anyways; it takes the name and makes it plural.
	private String getNamePlural()
	{
		StringBuilder output = new StringBuilder();
		output.append(mName);
		
		if(mAmount > 0)
		{
			switch(output.charAt(output.length()-1))
			{
				case 'y':
					output.deleteCharAt(output.length()-1);
					output.append("ies");
					break;
					
				case 'o':
				case 's':
				case 'x':
					output.append("es");
					break;
					
				case 'e':
					if(output.charAt(output.length()-2)!='f')
					{
						break;
					}
					else
					{
						output.deleteCharAt(output.length()-2);
					}
				case 'f':
					output.deleteCharAt(output.length()-1);
					output.append("ves");
					break;	
			}
		}
		
		return output.toString();
		
	}
}
