package Exercises.Array.Ex10.app;

import Exercises.Array.Ex10.entities.Person;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void showData(Person[] persons) {

        double smallerHeight = 100;
        double highestHeight = 0;
        double womenAvgHeight = 0;
        int numberOfMens = 0;

        for (Person p : persons) {

            if (smallerHeight > p.getHeight()) {
                smallerHeight = p.getHeight();
            }

            if (highestHeight < p.getHeight()) {
                highestHeight = p.getHeight();
            }

            if (p.getGender() == 'F' || p.getGender() == 'f') {
                womenAvgHeight += p.getHeight();
            } else {
                numberOfMens++;
            }

        }
        
        System.out.printf("SMALLER HEIGHT: %.2f\n", smallerHeight);
        System.out.printf("HIGHTES HEIGHT %.2f\n", highestHeight);
        System.out.printf("Women AVG Height: %.2f\n", womenAvgHeight / (persons.length - numberOfMens));
        System.out.printf("Number of mens: %d\n", numberOfMens);

    }

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Number of persons: ");
        Person[] persons = new Person[sc.nextInt()];

        String separator1 = "-".repeat(30);


        System.out.println(separator1);
        System.out.println("Insert People data");
        System.out.println(separator1);
        System.out.println("HEIGHT GENDER");


        for (int c = 0 ; c < persons.length ; c++) {

            System.out.print("Height and Gender: ");
            persons[c] = new Person(sc.nextDouble(), sc.next().charAt(0));

        }

        System.out.println(separator1);
        showData(persons);
        System.out.println(separator1);


        sc.close();
    }
}
