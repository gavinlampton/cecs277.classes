package cecs277.classes;

import java.util.ArrayList;

//TODO: Fill in the functions
public class VendingMachine {
	
	//Each coin/product objects keeps track of how the type is handled as has the amount as a number.
	private ArrayList<Money> moneyTypes;
	private ArrayList<Product> productTypes;
	private double mPaid;


	VendingMachine()
	{
		moneyTypes = new ArrayList<Money>();
		productTypes = new ArrayList<Product>();
	}

	public void insertMoney(Money.MoneyType money) 
	{
		boolean hasType = false;
		
		for (Money m : moneyTypes)
		{
			
			if ( m.getType().equals(money) ) 
			{
				m.add(1);
				hasType = true;
				break;
			}
			
		}
		
		if (!hasType)
		{
			moneyTypes.add(new Money(money, 1));
		}
		
		mPaid += money.getValue();
	}
	
	public void buyItem(String item)
	{
		//if(findItem(item, productTypes).getBaseValue > mPaid)
		{
			
		}
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
	
	private ValuedItem find(String itemName, ArrayList<ValuedItem> array)
	{
		for(ValuedItem i : array)
		{
			if(itemName==i.getName())
			{
				return i;
			}
		}
		
		return null;
		
	}
}
