package A04;

import java.util.Scanner;
import java.util.Locale;

public class Matrix {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("N: ");
        Integer n = sc.nextInt();
        Integer[][] matrix = new Integer[n][n];
        Integer qtdNegativeNumbers = 0;

        System.out.println("Enter matrix elements:");

        for (int i = 0 ; i < n ; i ++) {
            for (int j = 0 ; j < n ; j++) {
                // System.out.printf("Matrix[\033[34m%d\033[m][\033[35m%d\033[m]: ",
                // i, j);
                matrix[i][j] = sc.nextInt();

                if (matrix[i][j] < 0) {qtdNegativeNumbers ++;}

            }
        }
        
        System.out.println("\nMain Diagonal: ");
        for (int i = 0 ; i < n ; i ++) {
            System.out.println(matrix[i][i] + " ");
        }

        System.out.println("\nQTD NEGATIVE NUMBERS: " + qtdNegativeNumbers);

        sc.close();
    }
}
