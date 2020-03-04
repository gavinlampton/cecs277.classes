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
		boolean haveProduct = false;
		for(Product p: productTypes){
			if(p.getName().equals(item)) {
				haveProduct = true;
				if (mPaid > p.getBaseValue()) {
					p.remove(1);
					mPaid -= p.getBaseValue();
					//TODO: delete later
					System.out.println("You just bought " + item);
					System.out.printf("          Cost: $%3.2f\n", p.getBaseValue());
					System.out.printf("      Balance:: $%3.2f\n\n", mPaid);
				}else {
					System.out.println("You do not have enough money\n");
				}
			}
		}
		if (!haveProduct){
			System.out.println("Their are no " + item + ". Please try again.\n");
		}
	}

	public double getPaidAmount(){ return mPaid;}
	
	public void newProduct(String item, double baseValue, int amount)
	{
		Product product = new Product(item,baseValue,amount);
		productTypes.add(product);
	}	
	
	public void addProduct(String item, int amount)
	{
		boolean addedItem = false;
		for(Product p: productTypes){
			if (p.getName().equals(item)){
				p.add(amount);
				addedItem = true;
			}
		}
		if(!addedItem){
			System.out.println("Sorry there is not" + item + " in the vending machine");
		}
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
