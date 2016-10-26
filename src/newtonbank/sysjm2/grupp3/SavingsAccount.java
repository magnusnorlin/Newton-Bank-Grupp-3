/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtonbank.sysjm2.grupp3;

import java.util.Calendar;

/**
 *
 * @author Befkadu Degefa
 */
public class SavingsAccount extends Account
{

    
    Calendar currentYear = Calendar.getInstance();
    private double balance;
    private int counter = 0;
    private int accountID;

    public SavingsAccount()
    {
    }

    public SavingsAccount(double balance, double interestRate, String accountType)
    {
        super(balance, interestRate, accountType);
        this.accountID = Account.accountIDCounter;
    }

    public Calendar getCurrentYear()
    {
        return currentYear;
    }

    public void setCurrentYear(Calendar currentYear)
    {
        this.currentYear = currentYear;
    }

    @Override
    public double getBalance()
    {
        return balance;
    }

    @Override
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public int getCounter()
    {
        return counter;
    }

    public void setCounter(int counter)
    {
        this.counter = counter;
    }

    @Override
    public int getAccountID()
    {
        return accountID;
    }

    @Override
    public void setAccountID(int accountID)
    {
        this.accountID = accountID;
    }

    @Override
    public String toString()
    {
        return "SavingsAccount{" + "balance=" + balance + ", counter=" + counter + ", accountID=" + accountID + '}';
    }
    
    
    
    
    


    
    
//    @Override
//    public int getAccountID()
//    {
//        return accountID;
//    }
//
//    @Override
//    public void setAccountID(int accountID)
//    {
//        this.accountID = accountID;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "SavingsAccount{counter=" + counter + ", accountID=" + accountID + '}';
//    }

    
   
    
    
    @Override
    public void withdraw(double withdrawAmount)
    {
        
        int numberOfWeeksInYear = currentYear.getWeeksInWeekYear();
        int currentWeekOfYear = currentYear.get(Calendar.WEEK_OF_YEAR);
        if(currentWeekOfYear <= numberOfWeeksInYear)
        {
            if(counter == 0)
            {
            super.withdraw(withdrawAmount);
            counter++;
            }
            
            else
            {
               super.withdraw(withdrawAmount + (getInterestRate()*withdrawAmount/100));
            }
        }

    }
//    public void CalculateInterest()
//    {
//        System.out.println("Balance " + getBalance()); //test
//        double calculatedInterest = getBalance() * interestRate/100;   
//        System.out.println("Calculated Interest " + calculatedInterest); //test
//    }
}
