package Exercises.Array.Ex01;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Times to iterate: ");
        int times = sc.nextInt();

        int[] numbers = new int[times];

        for (int c = 0 ; c < times ; c++) {

            System.out.print("Number: ");
            numbers[c] = sc.nextInt();

        }

        System.out.println("NEGATIVE NUMBERS");
        for (int c = 0 ; c < numbers.length ; c++) {

            if (numbers[c] < 0) {
                System.out.println(numbers[c]);
            }

        }
        
        sc.close();
    }
}
