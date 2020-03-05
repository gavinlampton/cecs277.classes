/*Gavin Lampton, Alfonso Villalobos
 * March 5, 2020
 * Purpose: This program is used to simulate a type of product.
 * Inputs: The specifications of the product.
 * Outputs: Information about the product.
 */

package cecs277.classes;

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
	
	/**
	 * Returns the values as a formatted String.
	 */
	@Override
	public String toString()
	{
		return String.format("%s @ $%.2f  (%d left)", getName(), getBaseValue(),getAmount());
	}
}
