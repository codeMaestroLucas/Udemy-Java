package j_InheritanceAndPolymorphism.A01.app;

import j_InheritanceAndPolymorphism.A01.entities.*;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Account normalAcc = new Account(1234, "Lucas");
        normalAcc.deposit(100.0);
        normalAcc.deposit(500.0);
        System.out.println(normalAcc);


        BusinessAccount bussinessAcc = new
            BusinessAccount(4556, "Lucas Samuel", 500.0,
                                        1000.0);
        System.out.println(bussinessAcc);

        bussinessAcc.deposit(300.0);
        bussinessAcc.withdraw(9000.0);
        bussinessAcc.withdraw(10.93);

        System.out.println(bussinessAcc);

        bussinessAcc.loan(900.0);
        bussinessAcc.loan(9000.0);
        System.out.println(bussinessAcc);
        
    }
}
