package cecs277.classes;

//TODO: Javadocs and comment.

//This class uses encapsulation because you can't use logic to decide a this/super constructor call
//(It errors out if you don't put it on the call on first line.)
public class Money implements Comparable<ValuedItem>
{
	public static enum coinType
	{
		PENNY,
		NICKEL,
		DIME,
		QUARTER,
		DOLLAR,
		TWODOLLAR,
		FIVEDOLLAR,
		TENDOLLAR,
		TWENTYDOLLAR
	}
	
	Money()
	{
		mMoneyItem = new ValuedItem();
	}
	
	Money(coinType coin)
	{
		this(coin,0);
	}
	
	Money(coinType coin, int amount)
	{
		switch(coin)
		{
			case PENNY:
				mMoneyItem = new ValuedItem("Penny",.01,amount);
				break;
				
			case NICKEL:
				mMoneyItem = new ValuedItem("Nickel",.05,amount);
				break;
				
			case DIME:
				mMoneyItem = new ValuedItem("Dime", .1,amount);
				break;
				
			case QUARTER:
				mMoneyItem = new ValuedItem("Quarter",.25,amount);
				break;
				
			case DOLLAR:
				mMoneyItem = new ValuedItem("One Dollar Bill",1,amount);
				break;
				
			case TWODOLLAR:
				mMoneyItem = new ValuedItem("Two Dollar Bill",2,amount);
				break;
				
			case FIVEDOLLAR:
				mMoneyItem = new ValuedItem("Five Dollar Bill",5,amount);
				break;
				
			case TENDOLLAR:
				mMoneyItem = new ValuedItem("Ten Dollar Bill",10,amount);
				break;
				
			case TWENTYDOLLAR:
				mMoneyItem = new ValuedItem("Twenty Dollar Bill",20,amount);
				break;
		}
	}
	
	public double getValue()
	{
		return mMoneyItem.getValue();
	}
	
	public void add(int amount)
	{
		mMoneyItem.add(amount);
	}
	
	public void remove(int amount)
	{
		mMoneyItem.remove(amount);
	}
	
	@Override
	public String toString()
	{
		return mMoneyItem.toString();
	}
	
	@Override
	public int compareTo(ValuedItem item)
	{
		return mMoneyItem.compareTo(item);
	}
	
	/*--------------Private Section--------------*/
	private ValuedItem mMoneyItem;
}
