/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtonbank.sysjm2.grupp3;

import java.util.ArrayList;

/**
 *
 * @author Befkadu Degefa
 */
public class Customer
{

    private String customerName;
    private long personalNumber;
    //private Account account;
    public ArrayList<Account> custumerAccountsList;

    /**
     * Default constructor
     */
    public Customer() {  }
    
    public Customer(long personalNumber)
    {
        this.personalNumber = personalNumber;
        this.custumerAccountsList = new ArrayList<>();
    }
    public Customer(String customerName, long personalNumber)
    {
        this.customerName = customerName;
        this.personalNumber = personalNumber;
        this.custumerAccountsList = new ArrayList<>();
    }

    public Customer(String customerName, long personalNumber, Account account)
    {
        this.customerName = customerName;
        this.personalNumber = personalNumber;
        //this.account = account;
        this.custumerAccountsList = new ArrayList<>();
    }
    

    public String toString2()
    {
        return "customerName=" + customerName + ", personalNumber=" + personalNumber + custumerAccountsList.toString();
    }
    
//    public String toString1()
//    {
//        return "customerName=" + customerName + ", personalNumber=" + personalNumber + ", Account type= " + account.getAccountType() + "\n";
//    }
//    
    @Override
    public String toString()
    {
        return "customerName=" + customerName + ", personalNumber=" + personalNumber;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public long getPersonalNumber()
    {
        return personalNumber;
    }

    public void setPersonalNumber(long personalNumber)
    {
        this.personalNumber = personalNumber;
    }

//    public Account getAccount()
//    {
//        return account;
//    }

    public ArrayList<Account> getCustumerAccountsList()
    {
        return custumerAccountsList;
    }

    public void setCustumerAccountsList(ArrayList<Account> custumerAccountsList)
    {
        this.custumerAccountsList = custumerAccountsList;
    }
    
    
       
}
