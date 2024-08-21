package Exercises.Array.Ex04;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Times to iterate: ");
        int[] numbers = new int[sc.nextInt()];
        int qdtEven = 0;

        for (int c = 0 ; c < numbers.length ; c++) {

            System.out.print("Number: ");
            numbers[c] = sc.nextInt();

        }

        System.out.println("EVEN NUMBERS:");
        for (int c = 0 ; c < numbers.length ; c++) {

            if (numbers[c] % 2 == 0) {
                System.out.print(numbers[c] + " ");
                qdtEven ++;
            }

        }

        System.out.println("\nQTD EVEN: " + qdtEven);
        
        sc.close();
    }
}
