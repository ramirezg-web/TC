package com.techelevator;

public class SavingsAccount extends BankAccount{
    private static final int SERVICE_CHARGE=2;
    private static final int MINIMUM_BALANCE=150;

    public SavingsAccount(){
        super();
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public int withdraw(int amountToWithdraw){
        int newBalance=getBalance()-amountToWithdraw;
        if (newBalance<SERVICE_CHARGE){
            return getBalance();
        }

        if(newBalance< MINIMUM_BALANCE){
            return super.withdraw(amountToWithdraw+SERVICE_CHARGE);
        }
        return super.withdraw(amountToWithdraw);
    }
}
