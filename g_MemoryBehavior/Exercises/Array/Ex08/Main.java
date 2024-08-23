package Exercises.Array.Ex08;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Quantity of persons to be register: ");
        int qtd = sc.nextInt();
        String[] names = new String[qtd];
        int[] ages = new int[qtd];

        int heigher_age = 0;
        int heigher_age_pos = 0;

        for (int i = 0; i < qtd; i++) {

            System.out.printf("%dst Person Data\n", i + 1);
            System.out.print("Person Name: ");
            names[i] = sc.next();
            System.out.print("Person Age: ");
            ages[i] = sc.nextInt();

            if (ages[i] > heigher_age) {
                heigher_age = ages[i];
                heigher_age_pos = i;
            }

            System.out.println("=".repeat(35));
        }
        
        System.out.printf("Oldest Person: %s with %d years old.\n",
                names[heigher_age_pos], ages[heigher_age_pos]);
        
        sc.close();
    }
}

