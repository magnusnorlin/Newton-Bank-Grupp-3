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
 * @author Befkadu Degefa
 */
public class NewtonBankSYSJM2Grupp3
{
    public static BankLogic bankLogic;

    public static List <Customer> arrayList = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        bankLogic = BankLogic.getInstance();
        bankLogic = BankLogic.getInstance();
        
        
        
//        SavingsAccount savingsAccount = new SavingsAccount("Saving",1003, 123456);
//        savingsAccount.deposit(200);
//        System.out.println(savingsAccount.getBalance());
//        savingsAccount.withdraw(300);
//        
//        System.out.println(savingsAccount.getBalance());  
//        savingsAccount.withdraw(100);
//        System.out.println(savingsAccount.getBalance());
//        //savingAccount.CalculateInterest();
        
        
        
//        Customer aa1 = new Customer("AA1", 11 ,new SavingAccount(2, 1000,"Saving", 123456));
//        Customer bb1 = new Customer("BB1", 22 ,new SavingAccount(2, 2000,"Saving", 223456));
//        //Customer cc1 = new Customer("CC1", 33);
//        arrayList.add(aa1);
//        arrayList.add(bb1);
//        arrayList.add(new Customer("CC1", 33));
//        BankLogic bl = new BankLogic();
//        
//        System.out.println(bl.getCustomer() + " ");
//        
//        //Adding the customer, if not exist in the system. Returns true if the customer created
//        System.out.println(bl.addCustomer("DD1", 44));
//        System.out.println(bl.getCustomer() + " ");
//        
//        //To search for a specific customer by entering the personal number
//        System.out.println(bl.getCustomer(22));
//        
//        //To change the customer name
//        System.out.println("Is the name changed " + bl.changeCustomerName("EE2", 55));
//        System.out.println(bl.getCustomer());
        
        //Returns bank's all customer (Personal number and name)
        //BankLogic bankLogic = BankLogic.getInstance();
//        System.out.println(bankLogic.getCustomers());
//        
//
//        
//        //Adding the customer, if not exist in the system. Returns true if the customer created

        // Lägger till 3 kunder. addCustomer - metoden lägger till nya Customer-objekt(Customer-kontruktor körs)
        // i allCustomersArrayList OM deras pNr inte redan finns
        System.out.println("Kund har lagts till: " + bankLogic.addCustomer("CC", 33));
        System.out.println("Kund har lagts till: " + bankLogic.addCustomer("MM", 44));
        System.out.println("Kund har lagts till: " + bankLogic.addCustomer("NN", 55));
        
        // addSavingsAccount lägger skapar SavingAccount-objekt, lägger detta i custumerAccountsList 
        bankLogic.addSavingsAccount(55);
        System.out.println("GetAccount" + bankLogic.getAccount(55, 1000));
        System.out.println("Gör deposit: " + bankLogic.deposit(55, 1000, 500));
        System.out.println("GetAccount" + bankLogic.getAccount(55, 1000));
        System.out.println("Gör withdraw: " + bankLogic.withdraw(55, 1000, 500));
        System.out.println("GetAccount" + bankLogic.getAccount(55, 1000));
        
        
        
        printGetCustumers();
        
        System.out.println("Is the name changed " + bankLogic.changeCustomerName("CH", 9));
        
        printGetCustumers();
        
        System.out.println("getCustumer: ");
        printGetCustumer(55);
        
        for (int i = 0; i < bankLogic.removeCustomer(55).size(); i++)
        {
            System.out.println("Tar bort med loop: " + bankLogic.removeCustomer(55).get(i));
        }
   
        
        System.out.println("Tar bort " + bankLogic.removeCustomer(55));
        printGetCustumers();
        
        
        
        
////        System.out.println(bankLogic.addSavingsAccount(22));
////        System.out.println(bankLogic.getCustomers());
//        System.out.println(bankLogic.addSavingsAccount(33));
//        System.out.println(bankLogic.addSavingsAccount(44));
//        
//        
//        System.out.println(BankLogic.allCustomersArrayList.get(0).custumerAccountsList.get(0).getAccountID());
//        System.out.println(BankLogic.allCustomersArrayList.get(1).custumerAccountsList.get(0).getAccountID());
//        System.out.println(bankLogic.addSavingsAccount(33));
//        //System.out.println(bankLogic.getCustomers());
//        
//        System.out.println(BankLogic.allCustomersArrayList.get(0).custumerAccountsList.get(1).getAccountID());
//        System.out.println(Account.accountIDCounter);
//        
//        System.out.println(BankLogic.allCustomersArrayList.get(0).custumerAccountsList.get(0).getAccountID());
//        //To get the information about the specific customer after entering the personal number, search
////        System.out.println("Search the customer having pNr 11 ");
////        System.out.println(bankLogic.getCustomer(11));
////        
////        //To change the customer name
////        System.out.println("Is the name changed " + bankLogic.changeCustomerName("DD", 33));
////        System.out.println(bankLogic.getCustomers());
////        
////        //Removing a customer
////        System.out.println(bankLogic.removeCustomer(11));
////        
////        System.out.println(bankLogic.addSavingsAccount(22));
////        System.out.println(bankLogic.addSavingsAccount(22));
//   
        
    }
    public static void printGetCustumers()
    {
        ArrayList<String> testGetCustumers = new ArrayList<>(bankLogic.getCustomers());
        
        for (int i = 0; i < testGetCustumers.size(); i++)
        {
            System.out.println(testGetCustumers.get(i));
        }
    }
    
    public static void printGetCustumer(long pnr)
    {
        ArrayList<String> testGetCustumer = new ArrayList<>(bankLogic.getCustomer(pnr));
        
        for (int i = 0; i < testGetCustumer.size(); i++)
        {
            System.out.println(testGetCustumer.get(i));
        }
    }
            
}
