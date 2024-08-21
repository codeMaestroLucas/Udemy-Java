package Exercises.Array.Ex02;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Times to iterate: ");
        int times = sc.nextInt();
        double[] numbers = new double[times];

        double sum = 0;

        for (int c = 0 ; c < times ; c++) {

            System.out.print("Number: ");
            numbers[c] = sc.nextDouble();
            sum += numbers[c];

        }
        

        System.out.print("\n[ ");
        for (int c = 0 ; c < numbers.length ; c++) {

            if (c == numbers.length - 1) {
                System.out.printf("%.2f ]\n", numbers[c]);
            } else {
                System.out.printf("%.2f, ", numbers[c]);
            }

        }

        System.out.printf("SUM: %.2f\nAVG: %.2f", sum, sum / times);

        
        sc.close();
    }
}
