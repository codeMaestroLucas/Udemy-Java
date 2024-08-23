package Exercises.Array.Ex07;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Array legnth: ");
        double[] grades  = new double[sc.nextInt()];
        double avg = 0;

        for (int c = 0 ; c < grades.length ; c++) {

            System.out.printf("%dst Grade: ", c + 1);
            grades[c] = sc.nextDouble();
            avg += grades[c];

        }

        avg /= grades.length;
        System.out.printf("AVG: \033[32m%.2f\033[m\n", avg);

        System.out.println("GRADES BELOW AVG");
        for (int c = 0 ; c < grades.length ; c++) {
            if (grades[c] < avg) {
                System.out.printf("\033[31m%.2f\033[m\n", grades[c]);
            }
        }
        
        sc.close();
    }
}
