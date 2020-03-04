package cecs277.classes;

//TODO: Javadocs and comment.

public class Money extends ValuedItem
{
	private MoneyType mMoneyType;
	
	public static enum MoneyType
	{
		PENNY("penny", .01),
		NICKEL("nickel", .05),
		DIME("dime",.10),
		QUARTER("quarter",.25),
		HALFDOLLAR("half dollar coin",.50),
		DOLLAR("dollar bill",1),
		TWODOLLAR("two dollar bill",2),
		FIVEDOLLAR("five dollar bill",5),
		TENDOLLAR("ten dollar bill",10),
		TWENTYDOLLAR("twenty dollar bill",20);

		private String mName;
		private double mValue;
		
		private MoneyType(String name, double value)
		{
			mName = name;
			mValue = value;
		}
		
		public double getValue()
		{
			return mValue;
		}
		
		@Override
		public String toString()
		{
			return mName;
		}
	}
	
	Money()
	{
		super();
	}
	
	Money(MoneyType coin)
	{
		this(coin,0);
	}
	
	Money(MoneyType coin, int amount)
	{
		super(coin.toString(),coin.getValue(),amount);
		mMoneyType = coin;
	}
	
	public MoneyType getType(){return mMoneyType;}	
	
	@Override
	public String toString()
	{
		return super.toString();
	}
}

