package Exercises.Array.Ex05;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Times to iterate: ");
        double[] numbers = new double[sc.nextInt()];
        double heighest_value = 0;
        int position_heighest = 0;

        for (int i = 0 ; i < numbers.length ; i++) {
            System.out.print("Number: ");
            numbers[i] = sc.nextDouble();

            if (numbers[i] >= heighest_value) {
                heighest_value = numbers[i];
                position_heighest = i;
            }

        }

        System.out.printf("HEIGHEST VALUE: %.2f\nPOS OF HEIGHEST VALUE: %d\n",
                                        heighest_value, position_heighest);

        sc.close();
    }
}

