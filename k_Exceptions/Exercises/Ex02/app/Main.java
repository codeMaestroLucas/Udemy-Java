package k_Exceptions.Exercises.Ex02.app;

import java.util.Locale;
import java.util.Scanner;

import k_Exceptions.Exercises.Ex02.models.entities.Account;
import k_Exceptions.Exercises.Ex02.models.exceptions.SpecialExpt;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static Account registerAcc() {

        System.out.print("Number: ");
        Integer accNumber = sc.nextInt();

        System.out.print("Holder: ");
        String accHolder = sc.next();

        System.out.print("Initial Balance: $");
        Double initialBalance = sc.nextDouble();

        System.out.print("Withdraw Limit: $");
        Double withdrawLimit = sc.nextDouble();

        return new Account(accNumber, accHolder, initialBalance, withdrawLimit);

    }


    public static void main(String[] args) throws RuntimeException, SpecialExpt{
        
        Locale.setDefault(Locale.US);
        
        try {
            Account acc = registerAcc();
            System.out.println("\n" + acc);

            System.out.print("Deposit value: $");
            acc.deposit(sc.nextDouble());
            
            System.out.print("Withdraw value: $");
            acc.withdraw(sc.nextDouble());

            System.out.println("\n" + acc);

        } catch (SpecialExpt e) {
            System.out.println("\033[31mError:\033[m " + e.getMessage());

        } catch (RuntimeException e) {
            System.out.println("\033[31mUnexpected Error:\033[m " + e.getMessage());
        }
        
        
        sc.close();
    }
}
