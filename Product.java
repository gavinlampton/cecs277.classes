package cecs277.classes;

//TODO: javadocs and comment

public class Product extends ValuedItem
{
	Product()
	{
		super();
	}
	
	Product(String name, double baseValue)
	{
		super(name,baseValue,0);
	}
	
	Product(String name, double baseValue, int amount)
	{
		super(name,baseValue,amount);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s @ %.2f", getNamePlural(), getBaseValue());
	}
}
