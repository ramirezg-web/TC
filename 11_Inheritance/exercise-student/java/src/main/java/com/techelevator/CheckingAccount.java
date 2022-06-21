package com.techelevator;

public class CheckingAccount extends BankAccount{
    private static final int OVERDRAFT_PROTECTION=100;
    private static final int OVERDRAFT_FEE=10;
    public CheckingAccount(){
        super();

    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);

    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }


    public int withdraw(int amountToWithdraw) {
        int newBalance=getBalance()-amountToWithdraw;
        if(newBalance>=0){
            return super.withdraw(amountToWithdraw);
        }

        if (newBalance>OVERDRAFT_PROTECTION*-1){
            return super.withdraw(amountToWithdraw+ OVERDRAFT_FEE);
        }
        return getBalance();

//        if(getBalance()>=0&& amountToWithdraw<getBalance()){
//
//            return super.withdraw(amountToWithdraw);
//        }
//        else if((getBalance()>=-100)&&(getBalance()<=0)){
//            if(getBalance()+amountToWithdraw<=-100){
//                return super.withdraw(amountToWithdraw);
//            }
//            else{
//                int balance=super.withdraw(amountToWithdraw);
//                return balance-10;
//            }
////
////
////
//        }
//        return getBalance();



//else if(getBalance()+amountToWithdraw>=-100){
//                int balance=getBalance()+amountToWithdraw;
//                return balance-10;
//            }
//            return getBalance()-10;
//        if (getBalance()<=0.00 && getBalance()>=-100){
//            //nested if
//
//           int balance=getBalance()-10;
//           return balance-amountToWithdraw;
//        }
//        else if(getBalance()<=-100){
//            return getBalance()-10;
//        }
//        else if(getBalance()+amountToWithdraw<=-100){
//            return getBalance();
//        }
//        else if (getBalance()+amountToWithdraw>=-100&& getBalance()+amountToWithdraw<=0.00){
//            int balance=getBalance()-amountToWithdraw;
//            return balance-10;
//        }


    }


}
