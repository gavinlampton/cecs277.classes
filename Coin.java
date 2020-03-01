package cecs277.classes;


//TODO implement the Coin constructor, I think it's just a switch statement though, tbh.
public class Coin
{
	public enum coinType
	{
	PENNY,
	NICKEL,
	DIME,
	QUARTER
	}

	private ValuedItem mCoin;
	
	Coin()
	{
		mCoin = new ValuedItem();
	}
	
	Coin(coinType coin, int amount)
	{
		//Translate the coin type into the proper ValuedItem. I.E. Pennys have a name of "Penny" and a base value of ".01"
	}
	
	public double getValue()
	{
		return mCoin.getValue();
	}
	
	public void add(int amount)
	{
		mCoin.add(amount);
	}
	
	public void remove(int amount)
	{
		mCoin.remove(amount);
	}
	
	@Override
	public String toString()
	{
		return mCoin.toString();
	}
	
	
	
}
