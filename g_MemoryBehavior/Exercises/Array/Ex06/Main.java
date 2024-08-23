package Exercises.Array.Ex06;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void fillIntVect(int[] vect, String vect_name, Scanner sc) {
        for (int i = 0; i < vect.length; i++) {
            System.out.printf("%s %dst number: ", vect_name, i + 1);
            vect[i] = sc.nextInt();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Array's lenght: ");
        int lenght = sc.nextInt();
        int[] A = new int[lenght];
        int[] B = new int[lenght];
        int[] C = new int[lenght];

        fillIntVect(A, "A", sc);
        fillIntVect(B, "B", sc);

        System.out.println("C VALUES");
        for (int c = 0 ; c < lenght ; c++) {
            C[c] = A[c] + B[c];
            System.out.println(C[c]);
        }
        
        sc.close();
    }
}
