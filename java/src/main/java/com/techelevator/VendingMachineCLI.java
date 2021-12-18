package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed money";
	private static final String FEED_MONEY_OPTION1 = "Insert $1.00";
	private static final String FEED_MONEY_OPTION2 = "Insert $2.00";
	private static final String FEED_MONEY_OPTION3 = "Insert $5.00";
	private static final String FEED_MONEY_OPTION4 = "Insert $10.00";
	private static final String[] FEED_MONEY_OPTIONS = {FEED_MONEY_OPTION1, FEED_MONEY_OPTION2, FEED_MONEY_OPTION3, FEED_MONEY_OPTION4};
	private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select product";
	private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish transaction";
	private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT,
			SUB_MENU_OPTION_FINISH_TRANSACTION};
	private static VendingMachine vendingMachine;
	private static MoneyMachine moneyMachine;
	private static LogWriter logWriter;
//	private static SalesReport salesReport;
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}


	public void run() throws FileNotFoundException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vendingMachine.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

					String subMenuChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					if (subMenuChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						String feedMoneyChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
						if (feedMoneyChoice.equals(FEED_MONEY_OPTION1)) {
							moneyMachine.feedMoney(1);
							System.out.println("Current Money Provided: " + moneyMachine.getBalance());
						} else if (feedMoneyChoice.equals(FEED_MONEY_OPTION2)) {
							moneyMachine.feedMoney(2);
							System.out.println("Current Money Provided: " + moneyMachine.getBalance());
						} else if (feedMoneyChoice.equals(FEED_MONEY_OPTION3)) {
							moneyMachine.feedMoney(5);
							System.out.println("Current Money Provided: " + moneyMachine.getBalance());
						} else if (feedMoneyChoice.equals(FEED_MONEY_OPTION4)) {
							moneyMachine.feedMoney(10);
							System.out.println("Current Money Provided: " + moneyMachine.getBalance());
						}
						logWriter.LogWrite(" FEED MONEY: \\$" + moneyMachine.getMoneyIn() + " \\$" +
								moneyMachine.getBalance());

					} else if (subMenuChoice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
						if (moneyMachine.getBalance().compareTo(new BigDecimal("0.00")) <= 0){
							System.out.println("Please deposit money before making a selection.");
						}else {
							System.out.println(moneyMachine.getBalance());
							vendingMachine.displayInventory();
							System.out.println("Please input your selection");
							Scanner userInput = new Scanner(System.in);
							String userSelection = userInput.nextLine();
							if (!vendingMachine.getInventory().containsKey(userSelection)){
								System.out.println("Invalid key insert");
							} else if (vendingMachine.getInventory().containsKey(userSelection)) {
								vendingMachine.purchase(userSelection, moneyMachine.getBalance());
								logWriter.LogWrite(" " + vendingMachine.getInventory().get(userSelection).get(0).getName() +
										" " + userSelection + " \\$" + vendingMachine.getInventory().get(userSelection).get(0).getPrice() +
										" \\$" + moneyMachine.getBalance());
//							salesReport.SalesReportWriter(userSelection);
								while (vendingMachine.shoppingCart.size() > 0) {
									Product removedItem = vendingMachine.shoppingCart.remove(0);
									System.out.println(removedItem.getSound());
									//THE FIX
									moneyMachine.takeCustomerMoney(vendingMachine.getInventory().get(userSelection).get(0).getPrice());

									//CHECKING
									System.out.println(moneyMachine.getBalance());
								}
							}
//							menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
						}
					} else if (subMenuChoice.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
						vendingMachine.completeTransaction();
						logWriter.LogWrite(" GIVE CHANGE: \\$"+ moneyMachine.getBalance() +" \\$0.00");
						///////////////?????????????????/////////////// why getBalance print out before-change dispense
					}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.exit(0);
			}
		}
	}

		public static void main (String[]args) throws FileNotFoundException {
			Menu menu = new Menu(System.in, System.out);
			VendingMachineCLI cli = new VendingMachineCLI(menu);
			vendingMachine = new VendingMachine(new InventoryScanner().InventoryScanner());
			moneyMachine = new MoneyMachine();
			logWriter = new LogWriter();
//			salesReport = new SalesReport();
			cli.run();
		}

	public static String[] getMainMenuOptions() {
		return MAIN_MENU_OPTIONS;
	}
}



