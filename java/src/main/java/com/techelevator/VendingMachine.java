package com.techelevator;


import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

//    Menu menu = new Menu(System.in, System.out);
//    private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed money";
//    private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select product";
//    private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish transaction";
//    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT,
//            SUB_MENU_OPTION_FINISH_TRANSACTION};

    private Map<String, List<Product>> inventory = new TreeMap<>();
    MoneyMachine moneyMachine = new MoneyMachine(); //should b private
    List<Product> shoppingCart = new ArrayList<>();

    public VendingMachine (Map<String, List<Product>> inventory){
        this.inventory = inventory;
    }

    public void purchase(String slotLocation, BigDecimal balance){

        BigDecimal itemPrice = inventory.get(slotLocation).get(0).getPrice();
        moneyMachine.setBalance(balance);
        if(inventory.get(slotLocation).size() == 1 ){
            System.out.println("Out of stock");
//            menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
        }
        else if(inventory.get(slotLocation).size() > 1){
            if (moneyMachine.getBalance().compareTo(itemPrice)>=0 ){
                moneyMachine.takeCustomerMoney(itemPrice);
                System.out.println("Your current balance is: " + moneyMachine.getBalance());
                Product soldItem = inventory.get(slotLocation).remove(0);
                shoppingCart.add(soldItem);
            } else {
                System.out.println("Insufficient funds! Add some more.");
//                menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
            }
        }
    }

    public void completeTransaction(){
        moneyMachine.returnMoney(moneyMachine.getBalance());
    }


    public void displayInventory() {
        for (Map.Entry<String, List<Product>> entry : inventory.entrySet()) {
            String key = entry.getKey();
            List<Product> value = entry.getValue();
            if (value.size() - 1 == 0) {
                System.out.println(key + ": " + value.get(0) + "  SOLD OUT");
            } else {
                System.out.println(key + ": " + value.get(0) + "  [ " + (value.size() - 1) + " ]");
            }
        }
    }
    public Map<String, List<Product>> getInventory() {
        return inventory;
    }
}
