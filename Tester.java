/*Gavin Lampton, Alfonso Villalobos
 * March 5, 2020
 * Purpose: This program is used to simulate a vending machine.
 * Inputs: The user's commands
 * Outputs: Text prompts based on the situation.
 */

package cecs277.classes;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Alfonso Villalobos
 * @author Gavin Lamptom
 */

public class Tester
{
	
	public static void main(String[] args)
	{
		//Make this match a case listed below.
		String TESTMODE = "ALL";
		
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

			case("FULLY_STOCKED"):
				fullyStockAndBuy();
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
	
	/*--------------Variables----------------*/
	private static String uiPrompt = "S)how products\tI)nsert coin\tB)uy\tA)dd product\tR)emove coins\tQ)uit";
	
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
	}

	private static void buyProduct(){
		VendingMachine wale = new VendingMachine();

		wale.newProduct("Doritos", 2.99, 5);
		wale.newProduct("Cheetos", 2.99, 5);
		wale.newProduct("Twix", 0.99, 5);
		wale.newProduct("Cookies", 1.50, 5);

		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.QUARTER);
		wale.insertMoney(Money.MoneyType.DIME);
		wale.insertMoney(Money.MoneyType.TENDOLLAR);
		wale.insertMoney(Money.MoneyType.TWENTYDOLLAR);
		wale.insertMoney(Money.MoneyType.NICKEL);

		wale.buyItem("Doritos");
		System.out.println(wale);
		wale.buyItem("Chips");						// there is no "chips" item. Does nothing.
		System.out.println(wale);
		wale.buyItem("Twix");
	}

	private static void fullyStockAndBuy(){
		VendingMachine wale = new VendingMachine();
		wale.fullyStockVendingMachine();

		wale.buyItem("Doritos: Cool Ranch"); 					// Can't buy because we haven't paid

		wale.insertMoney(Money.MoneyType.TENDOLLAR);

		wale.buyItem("Doritos");
		wale.buyItem("Doritos");
		wale.buyItem("Doritos");
		wale.buyItem("Hershey's");
		wale.buyItem("Twix");
		wale.buyItem("Cookie");

		wale.restockAll();

        System.out.println(wale.toString());

        System.out.println(wale.productDetails("Doritos"));
	}
	

	private static void completeTest()
	{
		InputHandler in = new InputHandler();
		VendingMachine foo = new VendingMachine();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String input;
		boolean isLooping = true;
		
		foo.fullyStockVendingMachine();
		
		do
		{
			System.out.println(uiPrompt);
			input = in.takeInput().toUpperCase();
			
			switch(input.charAt(0))
			{
			
			case 'S':
				sop(foo.toString());
				break;
				
			case 'I':
				for(Money.MoneyType moneyType : Money.MoneyType.values())
				{
					System.out.printf( "%c) %s @ $%.2f\n", moneyType.getID(), moneyType.toString(), moneyType.getValue());
				}
				
				input = in.takeInput().toUpperCase();
				sop("Input: "+input.charAt(0));
				
				for(Money.MoneyType moneyType : Money.MoneyType.values())
				{
					if(moneyType.getID()==input.charAt(0))
					{
						foo.insertMoney(moneyType);
						sop("You inserted a "+moneyType.toString());
					}
				}
					
				break;
				
			case 'B':
				st = new StringTokenizer(foo.toString(),"\n");
				sb.delete(0, sb.length());
				
				for(int x=0; st.hasMoreTokens(); x++)
				{
					sb.append((char)(x+'A'));
					sb.append(") ");
					sb.append(st.nextToken());
					
					sop(sb.toString());
					
					sb.delete(0, sb.length());
				}
				
				input = in.takeInput().toUpperCase();
				foo.buyItem(foo.lookupItem(input.charAt(0)));
				
				break;
				
			case 'A':
				System.out.println("Enter product name: ");
				input = in.takeInput();
				
				if(foo.hasProduct(input))
				{
					foo.addProduct(input, 10);
				}
				else
				{
					System.out.println("Enter product price: ");
					foo.newProduct(input, Double.parseDouble(in.takeInput()), 10);
				}
				
				break;
				
			case 'R':
				foo.emptyMoney();
				break;
				
			case 'Q':
				isLooping=false;
				break;
			}
			
		} while(isLooping);
	}
}
