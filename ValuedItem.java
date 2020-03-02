package cecs277.classes;

//TODO: Javadocs and comment.

//This class has all the functionality for Coin and Product at the moment
public class ValuedItem implements Comparable<ValuedItem>
{

	ValuedItem()
	{
		this("UNNAMED ITEM",0,0);
	}
	
	ValuedItem(String name)
	{
		this(name,0,0);
	}
	
	ValuedItem(String name, double baseValue)
	{
		this(name,baseValue,0);
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
			mAmount = amount;
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
		if(amount>0)
		{
			if(!(mAmount > amount))
			{
				mAmount=0;
			}
			else
			{
				mAmount-=amount;
			}
		}
	}
	
	@Override
	public String toString()
	{
		return String.format("%d %s @ %.2f", mAmount, getNamePlural(), getValue());
	}
	
	@Override
	public int compareTo(ValuedItem item)
	{
		
		if(getValue()==item.getValue())
		{
			return 0;
		}
		else
		{
			return getValue()>item.getValue() ? 1 : -1;
		}
	}
	
	/*----------------Private Section------------*/
	
	private String mName;
	private double mBaseValue;
	private int mAmount;
	
	
	//This method isn't really necessary but I made it anyways; it takes the name and makes it plural.
	private String getNamePlural()
	{
		StringBuilder output = new StringBuilder();
		output.append(mName);
		
		if(mAmount != 1)
		{
			
			switch(output.charAt(output.length()-1))
			{
				case 'y':
					output.deleteCharAt(output.length()-1);
					output.append("ie");
					break;
					
				case 'o':
				case 's':
				case 'x':
					output.append("e");
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
					output.append("ve");
					break;
			}
			
			output.append("s");
		}

		
		return output.toString();
		
	}
}
