/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtonbank.sysjm2.grupp3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Befkadu Degefa the pro!
 */
public class BankLogic
{
    static List<Customer> allCustomersArrayList;
    private static BankLogic instance; //Step 2 declare the instance variabel
    static List<String> removedCustomerList = new ArrayList<>();
    static List<String> stringListCustomer = new ArrayList<>();
    

    private BankLogic() //Step 1 change this constructor to private
    {
        allCustomersArrayList = new ArrayList<>();
//        Customer customer1 = new Customer("AA1", 11 ,new SavingsAccount("Saving", 123456));
//        Customer customer2 = new Customer("BB1", 22 ,new SavingsAccount("Saving",1003, 123456));
//        allCustomersArrayList.add(customer1);
//        allCustomersArrayList.add(customer2);
    }
    
    public static BankLogic getInstance() //Step 3 write getInstance method
    {
        if(instance==null)
        {
            instance = new BankLogic();
        }
        else
            System.out.println("Redan skapat!");
        return instance;
    }
    
    /**
     * Returns all allCustomersArrayList of the bank(Personal number and name)
     * @return 
     */
    public List<String> getCustomers()    
    {
        List allCustListToReturn = new ArrayList();
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            allCustListToReturn.add(allCustomersArrayList.get(i).toString());
        }
        return allCustListToReturn;
    }
    
//    public List<String> getCustomers()//Check the data type, not string, public List<Customer> getCustomers()
//    {
//        
//        for(Customer customerList: allCustomersArrayList)
//        {
//           //List<String> stringListCustomer2 = List.transform(customerList, Functions.toStringFunction());
//           //listCustomerList.get(i) = (List<String>) allCustomersArrayList.get(i);
//        }
//        
//        return stringListCustomer;
//    }
     
    
    /**
     * //Adding the allCustomersArrayList, if not exist in the system. Returns true if the allCustomersArrayList created
     * @param name
     * @param pNr
     * @return 
     */
    public boolean addCustomer(String name, long pNr) 
    {
        boolean check = true;
        for (Customer list : allCustomersArrayList)
        {
            if (list.getPersonalNumber() == pNr)
            {
                check = false;
                break;
            }
        }

        //if the allCustomersArrayList doesn't exist in the database, he/she will be added here
        if (check == true)
        {
            allCustomersArrayList.add(new Customer(name, pNr));//
        }
        return check;
    }
    
    /**
     * To get the information about the specific allCustomersArrayList after entering the personal number, returns name and pNr
     * @param pNr
     * @return 
     */
    public List<String> getCustomer(long pNr)  //Check the data type,  public String getCustomer(long pNr)
    {
        List<String> custumerInfoAndAccountsList = new ArrayList<>();//String custumerInfoAndAccountsList = null;
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
            {
                custumerInfoAndAccountsList.add(allCustomersArrayList.get(i).toString2());
                for (int j = 0; j < allCustomersArrayList.get(i).getCustumerAccountsList().size(); j++)
                {
                    custumerInfoAndAccountsList.add(allCustomersArrayList.get(i).getCustumerAccountsList().get(j).toString());
                }
                break;
            }
        }
        return custumerInfoAndAccountsList;
    }
    
    /**
     * Change name for the guy having the same personal number
     * return true if the name changes
     * @param name
     * @param pNr
     * @return 
     */
    public boolean changeCustomerName(String name, long pNr)
    {
        boolean changeCustomerName = false;
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            
            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
            { 
                allCustomersArrayList.remove(allCustomersArrayList.get(i));
                changeCustomerName = true;
                break;
            }
            
        }
        
        //If there is the same personal number, change the name
        if(changeCustomerName)
        {
        System.out.println(allCustomersArrayList.size());//test
        allCustomersArrayList.add(new Customer(name, pNr));
        }
        
        return changeCustomerName;
    }
    
    /**
     * Deleting the allCustomersArrayList with pNr and the result will be returned
 The return list will have the information about the last balance, interest
     * @param pNr
     * @return 
     */
    
    
    public List<String> removeCustomer(long pNr)   
    {
        
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            
            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
            { 
                removedCustomerList.add(allCustomersArrayList.get(i).toString());
                for (int j = 0; j < allCustomersArrayList.get(i).custumerAccountsList.size(); j++)
                {
                    removedCustomerList.add(allCustomersArrayList.get(i).custumerAccountsList.get(j).toString());
                    if (allCustomersArrayList.get(i).custumerAccountsList.get(j).getAccountType() == "Savings")
                    {
                        removedCustomerList.add("Uppbetalning av ränta: " + 
                                (allCustomersArrayList.get(i).custumerAccountsList.get(j).getBalance()/100) * 5);
                    }
                    else if ((allCustomersArrayList.get(i).custumerAccountsList.get(j).getAccountType() == "Credit"))
                    {
                        
                    }
                    
                }
                
                allCustomersArrayList.remove(allCustomersArrayList.get(i));
                break;
            }
            
        }
        
        return removedCustomerList;
    }
    
    /**
     * create an account for a allCustomersArrayList with personal number, that returns the account number
 or return -1 if not created
     * @param pNr
     * @return 
     */ 
    public int addSavingsAccount(long pNr) //data type int
    {
        
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
            {
             allCustomersArrayList.get(i).getCustumerAccountsList().add(new SavingsAccount(0, 5 , "Savings"));
             
             break;
            }
        }
        return -1;
    }
    
    public String getAccount(long pNr, int accountId)
    {
        String getAccountReturnString = null;
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
            {
                for (int j = 0; j < allCustomersArrayList.get(i).getCustumerAccountsList().size(); j++)
                {
                    if (allCustomersArrayList.get(i).getCustumerAccountsList().get(j).getAccountID() == accountId)
                    {
                        getAccountReturnString = allCustomersArrayList.get(i).getCustumerAccountsList().get(j).toString();
                    }
                            
                }
            }
        }
        return getAccountReturnString;
    }
    
    
    public boolean deposit(long pNr, int accountId, double amount)
    {
        boolean depositMade = false;
        
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
            {
                for (int j = 0; j < allCustomersArrayList.get(i).custumerAccountsList.size(); j++)
                {
                    if (allCustomersArrayList.get(i).custumerAccountsList.get(j).getAccountID() == accountId)
                    {
                        allCustomersArrayList.get(i).custumerAccountsList.get(j)
                                .setBalance(allCustomersArrayList.get(i)
                                        .custumerAccountsList.get(j).getBalance() + amount);
                        depositMade = true;
                    }
                }
            }

        }
        return depositMade;
    }
    
    public boolean withdraw(long pNr, int accountId, double amount)
    {
        boolean withdrawMade = false;
        
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
            {
                for (int j = 0; j < allCustomersArrayList.get(i).custumerAccountsList.size(); j++)
                {
                    if (allCustomersArrayList.get(i).custumerAccountsList.get(j).getAccountID() == accountId)
                    {
                        allCustomersArrayList.get(i).custumerAccountsList.get(j)
                                .setBalance(allCustomersArrayList.get(i)
                                        .custumerAccountsList.get(j).getBalance() - amount);
                        withdrawMade = true;
                    }
                }
            }            
        }
        return withdrawMade;
    }
    
    public String closeAccount(long pNr, int accountId)
    {
        String closeAccountReturnString = null;
        for (int i = 0; i < allCustomersArrayList.size(); i++)
        {
            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
            {
                for (int j = 0; j < allCustomersArrayList.get(i).custumerAccountsList.size(); j++)
                {
                    if (allCustomersArrayList.get(i).custumerAccountsList.get(j).getAccountID() == accountId)
                    {
                        closeAccountReturnString = allCustomersArrayList.get(i).custumerAccountsList.get(j)
                                .toString() + ("Uppbetalning av ränta: " + (allCustomersArrayList.get(i)
                                        .custumerAccountsList.get(j).getBalance()/100) * 5);
                        
                        allCustomersArrayList.get(i).custumerAccountsList.remove(j);
                    }
                }
            }            
        }
        return closeAccountReturnString;
    }
}

    
//    public int addSavingsAccount2(long pNr) //data type int
//    {
//        int anotherAccount=0;
//        List<String> custumerInfoAndAccountsList = new ArrayList<>();//String custumerInfoAndAccountsList = null;
//        if(addSavingsAccount(pNr)==-1)
//        {
//        
//        for (int i = 0; i < allCustomersArrayList.size(); i++)
//        {
//            if (allCustomersArrayList.get(i).getPersonalNumber() == pNr)
//            {
//             anotherAccount = allCustomersArrayList.get(i).getAccount().getAccountID();
//             anotherAccount++;
//              break;
//            }
//        }
//           
//            
//           
//        }
//        return anotherAccount;
//    }
    

