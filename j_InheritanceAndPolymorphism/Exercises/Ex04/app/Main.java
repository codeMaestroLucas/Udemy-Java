package j_InheritanceAndPolymorphism.Exercises.Ex04.app;

import static java.lang.StringTemplate.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import j_InheritanceAndPolymorphism.Exercises.Ex04.entities.Company;
import j_InheritanceAndPolymorphism.Exercises.Ex04.entities.Individual;
import j_InheritanceAndPolymorphism.Exercises.Ex04.entities.Person;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Number of Tax Payers: ");
        Integer iter = sc.nextInt();
        ArrayList<Person> taxPayers = new ArrayList<>();
        Person p = null;


        for (int i = 0; i < iter; i++) {

            System.out.println(STR."\033[1mTAX PAYER #\{i + 1} DATA\033[m");

            System.out.print("[I]ndividual or [C]ompany? ");
            char option = sc.next().trim().toUpperCase().charAt(0);

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Anual Income: $");
            Double anualIncome = sc.nextDouble();

            if (option == 'I') {
                System.out.print("Health expenditures: $");
                Double healthExpnd = sc.nextDouble();

                p = new Individual(name, anualIncome, healthExpnd);
            } else if (option == 'C') {
                System.out.print("Number of employees: ");
                Integer numberOfEmp = sc.nextInt();

                p = new Company(name, anualIncome, numberOfEmp);
            }

            taxPayers.add(p);
        }

        System.out.println("\nTAX PAID");
        for (Person person : taxPayers) {
            System.out.println(person);
        }
        
        sc.close();
    }
}

