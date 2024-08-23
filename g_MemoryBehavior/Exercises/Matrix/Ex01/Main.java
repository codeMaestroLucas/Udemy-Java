package Exercises.Matrix.Ex01;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.print("Insert the NxM values for the matrix: ");
        Integer[][] matrix = new Integer[sc.nextInt()][sc.nextInt()]; // NxM

        // Input matrix values
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the element to be analyzed: ");
        Integer element = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == element) {
                    found = true;

                    System.out.printf("\nPOSITION: [%d][%d]\n", i + 1, j + 1);

                    // Checking boundaries before accessing neighboring elements
                    if (i > 0) {
                        System.out.println("TOP: " + matrix[i - 1][j]);
                    }
                    if (j < matrix[i].length - 1) {
                        System.out.println("RIGHT: " + matrix[i][j + 1]);
                    }
                    if (i < matrix.length - 1) {
                        System.out.println("BOTTOM: " + matrix[i + 1][j]);
                    }
                    if (j > 0) {
                        System.out.println("LEFT: " + matrix[i][j - 1]);
                    }

                    System.out.println(); // Print an empty line after each occurrence
                }
            }
        }

        // If no element was found, print a message
        if (!found) {
            System.out.println("Element doesn't exist.");
        }

        sc.close();
    }
}
