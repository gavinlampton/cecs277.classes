package cecs277.classes;

//TODO: Javadocs and comment.

public class Money extends ValuedItem
{
	public static enum MoneyType
	{
		PENNY("penny", .01,'A'),
		NICKEL("nickel", .05,'B'),
		DIME("dime",.10,'C'),
		QUARTER("quarter",.25,'D'),
		HALFDOLLAR("half dollar coin",.50,'E'),
		DOLLAR("dollar bill",1,'F'),
		TWODOLLAR("two dollar bill",2,'G'),
		FIVEDOLLAR("five dollar bill",5,'H'),
		TENDOLLAR("ten dollar bill",10,'I'),
		TWENTYDOLLAR("twenty dollar bill",20,'J');

		private String mName;
		private double mValue;
		private char mID;
		
		private MoneyType(String name, double value, char id)
		{
			mName = name;
			mValue = value;
			mID = id;
		}
		
		/**
		 * Gets the value of the Money type
		 * @return value
		 */
		public double getValue()
		{
			return mValue;
		}
		
		/**
		 * Each Money type has an id associated with it.
		 * @return this money type's id.
		 */
		public char getID()
		{
			return mID;
		}
		
		/**
		 * Gives name in a user-friendly string
		 * @return name.
		 */
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

	
	/*--------------Private Section--------------*/
	private MoneyType mMoneyType;
}
