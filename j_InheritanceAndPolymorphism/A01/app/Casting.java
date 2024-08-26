package j_InheritanceAndPolymorphism.A01.app;

import java.util.Locale;

import j_InheritanceAndPolymorphism.A01.entities.Account;
import j_InheritanceAndPolymorphism.A01.entities.BusinessAccount;
import j_InheritanceAndPolymorphism.A01.entities.SavingsAccount;

public class Casting {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Account normalAcc = new Account(1234, "Lucas");

        BusinessAccount bussinessAcc = new
            BusinessAccount(4556, "Lucas Samuel", 500.0,
                                        1000.0);

        SavingsAccount svsAcc = new SavingsAccount();

        
        // UpCasting
        Account acc1 = bussinessAcc;
        Account acc2 = new BusinessAccount(12, "john", 900.0);
        Account acc3 = new SavingsAccount();
        
        // DownCasting
        // BusinessAccount bacc1 = acc1; // method not allowed
        BusinessAccount bacc1 =  (BusinessAccount) acc1;

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount bacc2 = (BusinessAccount) acc3;
            System.out.println("LOAN!");
        }
        
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount bacc2 = (SavingsAccount) acc3;
            System.out.println("UPADTE!");
        }



    }
}
