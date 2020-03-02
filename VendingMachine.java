package cecs277.classes;

import java.util.ArrayList;

//TODO: Fill in the functions
public class VendingMachine {
	
	//Each coin/product objects keeps track of how the type is handled as has the amount as a number.
	ArrayList<Money> coinTypes;
	ArrayList<Product> productTypes;
	
	VendingMachine()
	{
		coinTypes = new ArrayList<Money>();
		productTypes = new ArrayList<Product>();
	}
	
	public void insertCoin(String coin)
	{
		
	}
	
	public void buyItem(String item)
	{
		
	}
	
	public void newProduct(String item, double baseValue, int amount)
	{
		
	}	
	
	public void addProduct(String item, int amount)
	{
		
	}
	
	public void removeCoins()
	{
		
	}
	
	@Override
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		
		for(Product p : productTypes)
		{
			output.append(p.toString());
			output.append('\n');
		}
		
		return output.toString();
	}
	
	/*-------Private Section---------*/
	//These are just suggestions
	private double storedMoney()
	{
		return 0;
	}
}
