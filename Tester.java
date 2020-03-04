package cecs277.classes;

import java.util.ArrayList;
import java.util.Collections;

//TODO: Finish vending machine test; write complete test.
public class Tester
{
	
	public static void main(String[] args)
	{
		//Make this match a case listed below.
		String TESTMODE = "BUY";
		
		switch(TESTMODE)
		{
			case("COIN"):
				coinUTest();
			break;
			
			case("PRODUCT"):
				productUTest();
			break;
			
			case("ITEM"):
				valuedItemUTest();
			break;
			
			case("MACHINE"):
				vendingMachineUTest();
			break;
			
			case("INPUT"):
				inputHandlerUTest();
			break;

			case("COIN_INSERT"):
				coinInsertTest();
				break;

			case("BUY"):
				buyProduct();
				break;
			
			case("ALL"):
				completeTest();
			break;
		}
	}
	
	/*-----------Methods---------------*/

	private static void printlist(ArrayList al)
	{
		for(Object o : al)
		{
			sop(o.toString());
		}
		sop();
	}
	
	private static void sop()
	{
		sop("");
	}
	
	private static void sop(String s)
	{
		System.out.println(s);
	}
	
	/*---------------Debug Functions-----------*/
	
	private static void coinUTest()
	{
		ArrayList<Money> coins = new ArrayList<Money>();
		
		coins.add(new Money());
		coins.add(new Money(Money.MoneyType.PENNY, 1));
		coins.add(new Money(Money.MoneyType.DIME, 14));
		
		printlist(coins);
	}
	
	private static void productUTest()
	{
		ArrayList<Product> produce = new ArrayList<Product>();
		
		produce.add(new Product());
		produce.add(new Product("Apple",3,10));
		produce.add(new Product("Mango",2,2));
		
		sop("Basic:");
		printlist(produce);

		sop("\nSorted:");
		Collections.sort(produce);
		printlist(produce);
		
		sop("\nRe-sorted");
		produce.get(1).add(20);
		Collections.sort(produce);
		printlist(produce);
		
		sop("Add/Remove:");
		for(Product p : produce)
		{
			p.add(2);
			p.add(-1);
			p.remove(-1);
			sop(p.toString());
			
			p.remove(9);
			sop(p.toString());
			sop();
		}	
	}
	
	private static void valuedItemUTest() 
	{
		productUTest();
	}
	
	private static void vendingMachineUTest()
	{
		VendingMachine foo = new VendingMachine();
		
		sop(foo.toString());//Should be empty
		
		foo.newProduct("candy", .25, 3);
		sop(foo.toString());
		
		foo.newProduct("cookie", .65, 10);
		foo.buyItem("cookie");
		
		foo.addProduct("candiie",10);	//Should ignore
		
		foo.insertMoney(Money.MoneyType.QUARTER);
		foo.buyItem("cookie");//Should error
		foo.buyItem("candy");
		
		foo.buyItem("candy");//Should error
		sop("Removed: "+foo.emptyMoney());//Should remove $0.00
		
		foo.insertMoney(Money.MoneyType.TENDOLLAR);
		for(int x=0;x<2;x++)
		{
			foo.buyItem("candy");
		}
		sop("Removed: "+foo.emptyMoney());//Should remove $9.50
		
		foo.insertMoney(Money.MoneyType.HALFDOLLAR);
		sop(foo.toString());
		foo.buyItem("candy");//Should not work because out of stock.
		sop("Removed: "+foo.emptyMoney());//Should remove $0.50
		
		foo.addProduct("candy", 10);
		foo.addProduct("candy", -10);//Should ignore
		sop(foo.toString());//Candy should have 10 here.
		
	}
	
	private static void inputHandlerUTest()
	{
		InputHandler in = new InputHandler();
		
		
		String input;
		do
		{
			input = in.takeInput();
			sop(input);
			input = input.strip().toUpperCase();
			sop("treated: "+input);
			
		} while(input.charAt(0)!='Q');
		
	}
	
	private static void completeTest()
	{
		InputHandler in = new InputHandler();
		VendingMachine foo = new VendingMachine();
	}

	private static void coinInsertTest(){
		VendingMachine wale = new VendingMachine();
		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.DIME);
		wale.insertMoney(Money.MoneyType.TENDOLLAR);
		wale.insertMoney(Money.MoneyType.TWENTYDOLLAR);
		wale.insertMoney(Money.MoneyType.NICKEL);
		System.out.printf("You entered $ %.2f\n", wale.getPaidAmount());

		System.out.println(wale.toString());					//FIXME: fix this method

	}

	private static void buyProduct(){
		VendingMachine wale = new VendingMachine();
		wale.newProduct("Doritos", 2.99, 5);
		wale.newProduct("Cheetos", 2.99, 5);
		wale.newProduct("Twix", 0.99, 5);
		wale.newProduct("Cookies", 1.50, 5);

		Product twix = new Product("Twix", 2.99, 10);

		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.DIME);
		wale.insertMoney(Money.MoneyType.TENDOLLAR);
		wale.insertMoney(Money.MoneyType.TWENTYDOLLAR);
		wale.insertMoney(Money.MoneyType.NICKEL);


		wale.buyItem("Doritos");
		System.out.println(wale);
		wale.buyItem("Chips");			// there is no "chips" item. Does nothing.
		System.out.println(wale);
		wale.buyItem("Twix");

	}
	
}
