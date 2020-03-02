package cecs277.classes;

//This class hides the details of the implementation so that Vending Machine won't break if we do something like use a java library class instead of ValuedItem.
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
		
}
