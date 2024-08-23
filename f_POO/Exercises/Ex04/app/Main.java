package Exercises.Ex04.app;

import java.util.Scanner;

import Exercises.Ex04.entities.BankAccount;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);

        BankAccount b1 = new BankAccount(1234, "Alex Green", 500);

        System.out.println(b1);
        b1.deposit(-300);
        b1.deposit(300);
        b1.deposit(10);
        b1.withdraw(-90);
        b1.withdraw(95);
        b1.withdraw(890);

        b1.setAccHolder("Alex Red");

        System.out.println(b1);

        
        
        sc.close();
    }
}
