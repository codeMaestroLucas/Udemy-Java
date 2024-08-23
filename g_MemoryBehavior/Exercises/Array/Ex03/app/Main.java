package Exercises.Array.Ex03.app;

import Exercises.Array.Ex03.entities.Person;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Times to iterate: ");
        Person[] persons = new Person[sc.nextInt()];

        double avgHeight = 0;
        double minors = 0;

        for (int c = 0 ; c < persons.length ; c++) {

            System.out.printf("Data form the %dst Person:\n", c + 1);
            System.out.println("NAME AGE HEIGHT");
            persons[c] = new Person(sc.next(),        // Name
                                    sc.nextInt(),     // Age
                                    sc.nextDouble()); // Height

            avgHeight += persons[c].getHeight();

            if (persons[c].getAge() < 16) {
                minors ++;
            }

            System.out.println();
        }

        System.out.printf("\nAVG HEIGHT: %.2f\nMINORS: %.2f%%\n",
        avgHeight / persons.length, minors * 100 / persons.length);

        for (int c = 0 ; c < persons.length ; c++) {
            if (persons[c].getAge() < 16) {
                System.out.println(persons[c].getName());
            }
        }
        
        
        sc.close();
    }
}
