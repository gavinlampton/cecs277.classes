package cecs277.classes;

import java.util.ArrayList;

//TODO: Fill in the functions
public class VendingMachine {
	
	//Each coin/product objects keeps track of how the type is handled as has the amount as a number.
	private ArrayList<Money> coinTypes;
	private ArrayList<Product> productTypes;
	private double mPaid;
	private final int MAX_PPRODUCTS_IN_SLOT = 15;


	/**
	 * Constructor to build a vending machine object
	 */
	VendingMachine()
	{
		coinTypes = new ArrayList<Money>();
		productTypes = new ArrayList<Product>();
	}

	/**
	 * Money to be inserted to buy a product from the vending machine
	 * @param money the ytpe of money inserted
	 */
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

	/**
	 * Method that performs the buying of a product from the vending machine
	 * @param item the item to be bought
	 */
	public void buyItem(String item)
	{
		boolean haveProduct = false;
		for(Product p: productTypes){
			if(p.getName().equals(item)) {
				haveProduct = true;
				if (mPaid >= p.getBaseValue()) {
					p.remove(1);
					mPaid -= p.getBaseValue();
					//TODO: delete later
					System.out.println("Item bought " + item);
					System.out.printf("          Cost: $%3.2f\n", p.getBaseValue());
					System.out.printf("      Balance:: $%3.2f\n\n", mPaid);
				}else {
					System.out.println("Insufficient funds\n");
				}
			}
		}
		if (!haveProduct){
			System.out.println("Their are no " + item + ". Please try again.\n");
		}
	}

	public double getPaidAmount(){
		return mPaid;
	}

	/**
	 * Adds a new product to the vending machine with a given amount of products
	 * @param item Product name
	 * @param baseValue Cost of product
	 * @param amount quantity of products to be added
	 */
	public void newProduct(String item, double baseValue, int amount)
	{
		Product product = new Product(item,baseValue,amount);
		productTypes.add(product);
	}

	/**
	 * Adds a product that the vending machine has
	 * @param item the name of the product to be restocked
	 * @param amount the amount of products you are restocking.
	 */
	public void addProduct(String item, int amount)
	{
		int counter = 0;
		if(amount > 0) {
			boolean addedItem = false;
			for (Product p : productTypes) {
				if (p.getName().equals(item)) {
					while (counter < amount && p.getAmount() < MAX_PPRODUCTS_IN_SLOT) {
						p.add(amount);
						addedItem = true;
					}
				}
			}
			if (!addedItem) {
				System.out.println("Sorry, " +item + " does not exist\n");
			}
		}
	}

	/**
	 * Takes all the coins out of the vending machine. This simulated a technician coming to collect the
	 * money.
	 * @return the amound of money that was collected.
	 */
	public double emptyMoney()
	{
		double totalCoinAmount = 0;
		for(Money m: coinTypes){
			totalCoinAmount += m.getType().getValue();
		}
		return totalCoinAmount;
	}

	/**
	 * Creates a respresenation of an actual vending machine with snack prices, cost, and quantity.
	 */
	public void fullyStockVendingMachine() {
		productTypes.add(new Product("Doritos", 1.25, 15));
		productTypes.add(new Product("Cheetos", 1.25, 15));
		productTypes.add(new Product("Fritos", 1.25, 15));
		productTypes.add(new Product("Cheez-It", 1.25, 15));
		productTypes.add(new Product("Gardetto", 1.25, 15));
		productTypes.add(new Product("Funyuns", 1.25, 15));
		productTypes.add(new Product("Boulder Canyon", 1.25, 15));
		productTypes.add(new Product("Lays", 1.25, 15));
		productTypes.add(new Product("Pretzel", 1.25, 15));
		productTypes.add(new Product("Cookie", 1.25, 15));
		productTypes.add(new Product("Twix", 1.25, 15));
		productTypes.add(new Product("Sneakers", 1.25, 15));
		productTypes.add(new Product("Sour Patch Kids", 1.25, 15));
		productTypes.add(new Product("M&M's", 1.25, 15));
		productTypes.add(new Product("Hershey's", 1.25, 15));
		productTypes.add(new Product("3 Musketeers", 1.25, 15));
		productTypes.add(new Product("Milky Way", 1.25, 15));
		productTypes.add(new Product("Payday", 1.25, 15));
		productTypes.add(new Product("Starburst", 1.25, 15));
		productTypes.add(new Product("Planters", 1.25, 15));
		productTypes.add(new Product("Grandma's", 1.35, 15));
		productTypes.add(new Product("Knott's", 1.35, 15));
		productTypes.add(new Product("Nature", 1.35, 15));
		productTypes.add(new Product("Welch's", 1.35, 15));
	}

	public void endTransactions(){
		mPaid = 0;
	}

	/**
	 * Method to restock all products in a vending machine. All idem can only have a maximum amount of 15 items.
	 */
	public void restockAll(){
		for (Product p: productTypes){
			while (p.getAmount() > 0 & p.getAmount() < MAX_PPRODUCTS_IN_SLOT){
				p.add(1);
			}
		}
	}

	/**
	 * Creates a string of a single product
	 * @param name Name of the product you want information on
	 * @return product information.
	 */
	public String productDetails(String name){
		String productInfo = "";
		boolean haveProduct = false;
		for(Product p: productTypes){
			if (p.getName().equals(name)){
				haveProduct = true;
				productInfo = p.toString();
			}
		}
		if (!haveProduct){
			productInfo = "This product is not in our vending machine";
		}
		return productInfo;
	}

	/**
	 * Creates a String of al the products name, cost, and amount of items in the vending machine
	 * @return information of all products
	 */
	@Override
	public String toString()
	{
		StringBuilder output = new StringBuilder();

		for(Product p : productTypes)
		{
			output.append(p.toString());

			if(p.getAmount() <= 0) {
				output.append(" (Out of stock)");
			}
			output.append('\n');
		}

		return output.toString();
	}
}
