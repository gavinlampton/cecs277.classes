package cecs277.classes;

import java.util.ArrayList;

//TODO: Fill in the functions
public class VendingMachine {
	
	//Each coin/product objects keeps track of how the type is handled as has the amount as a number.
	private ArrayList<Money> coinTypes;
	private ArrayList<Product> productTypes;
	private double mPaid;


	VendingMachine()
	{
		coinTypes = new ArrayList<Money>();
		productTypes = new ArrayList<Product>();
	}

	public void insertMoney(Money.MoneyType money) {
		boolean hasType = false;
		for (int i = 0; i < coinTypes.size(); i++) {
			if (coinTypes.get(i).getType().equals(money)) {
				coinTypes.get(i).add(1);
				hasType = true;
			}
		}
		if (!hasType) {
			coinTypes.add(new Money(money, 1));
		}
		mPaid += money.getValue();
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
	
	public double emptyMoney()
	{
		return -100;
	}
	
	@Override
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		
		for(Product p : productTypes)
		{
			output.append(p.toString());
			
			if(p.getAmount()>0)
			{
				output.append(" (Out of stock)");
			}
			
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
