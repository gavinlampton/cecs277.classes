package cecs277.classes;

//TODO: Javadocs and comment.

//This class has all the functionality for the and Product classes
public class ValuedItem
{
	
	private String mName;
	private double mBaseValue;
	private int mAmount;
	private char mID;
	
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
	
	/**
	 * Gives the name of the item
	 * @return name.
	 */
	public String getName()
	{
		return new String(mName);
	}
	
	/**
	 * Gives the value of all items of this types.
	 * @return Value of all items.
	 */
	public double getFullValue()
	{
		return mBaseValue*mAmount;
	}
	
	/**
	 * Give the value of a single item of this type.
	 * @return Value of one item.
	 */
	public double getBaseValue() 
	{
		return mBaseValue;
	}
	
	/**
	 * Gives the amount of items of this type.
	 * @return Amount of items.
	 */
	public int getAmount()
	{
		return mAmount;
	}
	
	/**
	 * Adds a set amount of items.
	 * @param amount - how many items to add.
	 */
	public void add(int amount)
	{
		if(amount>0)
		{
			mAmount += amount;
		}
	}
	
	/**
	 * Removes a set amount of items.
	 * @param amount - how many items to remove.
	 */
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
	
	/**
	 * Returns values as a formatted string.
	 */
	@Override
	public String toString()
	{
		return String.format("%d %s @ %.2f", mAmount, getNamePlural(), getFullValue());
	}
	
	/**
	 * Returns true if the name of this item is the same as given a string or the name of another item.
	 * @param obj the object which will be tested for equality
	 * @return true if obj is the same class or subclass with the same name or a string equivalent to name, otherwise false
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj.getClass().isAssignableFrom(this.getClass()))
		{
			return mName.equals( ((ValuedItem)obj).mName );
		}
		else if(obj.getClass().equals(String.class))
		{
			return mName.equals( (String)obj );
		}
		else
		{
			return false;
		}
	}
	/**
	 * Returns the has code for this item, updated for the new equals function.
	 * @return hash code
	 */
	@Override
	public int hashCode()
	{
		return mName.hashCode();
	}
	
	/*----------------Private Methods------------*/
	
	//This method isn't really necessary but I made it anyways; it takes the name and makes it plural.
	protected String getNamePlural()
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