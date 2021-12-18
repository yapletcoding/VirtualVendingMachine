package com.techelevator;

import java.math.BigDecimal;

public class MoneyMachine {
    private BigDecimal balance = new BigDecimal("0.00");
    private double changeOut;
    private BigDecimal moneyIn;

    public MoneyMachine(BigDecimal balance) {
        this.balance = balance;
    }

    public MoneyMachine() {
    }

    int quarter = 25;
    int dime = 10;
    int nickel = 5;

    public void feedMoney(int input) {
        if (input == 1) {
            balance = balance.add(new BigDecimal(1.00));
            moneyIn = new BigDecimal(1.00);
        }
        if (input == 2) {
            balance = balance.add(new BigDecimal(2.00));
            moneyIn = new BigDecimal(2.00);
        }
        if (input == 5) {
            balance = balance.add(new BigDecimal(5.00));
            moneyIn = new BigDecimal(5.00);
        }
        if (input == 10) {
            balance = balance.add(new BigDecimal(10.00));
            moneyIn = new BigDecimal(10.00);
        }
    }

    public void takeCustomerMoney(BigDecimal input) {
        balance = balance.subtract(input);
    }

    public void returnMoney(BigDecimal balance) {
        changeOut = balance.doubleValue() * 100;
        int quarterCount = (int)changeOut / quarter;
        int remainder = (int)changeOut - (quarterCount * quarter);
        int dimeCount = remainder / dime;
        remainder = remainder - (dimeCount * dime);
        int nickelCount = remainder / nickel;
        String quarters = " quarters, ";
        String dimes = " dimes and ";
        String nickels = " nickels.";
        if (quarterCount == 1) {
            quarters = " quarter, ";
        }
        if (dimeCount == 1) {
            dimes = " dime and ";
        }
        if (nickelCount == 1) {
            nickels = " nickel.";
        }
        System.out.println("Your change will be " + quarterCount + quarters
                + dimeCount + dimes + nickelCount + nickels);

        this.balance = new BigDecimal("0.00");

    }
        // Return user to main menu to continue using machine
        
        // Generate line in log.txt
    public BigDecimal getBalance() {
            return balance;
        }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getMoneyIn() {
        return moneyIn;
    }
}





