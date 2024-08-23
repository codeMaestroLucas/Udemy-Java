package A01.app;

import java.util.Scanner;
import java.util.Locale;

public class NoPOO {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        double xA, xB, xC, yA, yB, yC, xP, xArea, yP, yArea;

        System.out.println("Enter the mesures of triangle X:");
        xA = sc.nextDouble();
        xB = sc.nextDouble();
        xC = sc.nextDouble();

        xP = (xA + xB + xC) / 2;
        xArea = Math.sqrt(xP * (xP - xA) * (xP - xB) * (xP - xC));
        
        System.out.println("Enter the mesures of triangle Y:");
        yA = sc.nextDouble();
        yB = sc.nextDouble();
        yC = sc.nextDouble();

        yP = (yA + yB + yC) / 2;
        yArea = Math.sqrt(yP * (yP - yA) * (yP - yB) * (yP - yC));
        
        System.out.printf("Area X: %.2fU.C.;\nArea Y: %.2fU.C.\n", xArea, yArea);

        if (xArea > yArea) {
            System.out.println("Triangle X has a greater area.");
        } else {
            System.out.println("Triangle Y has a greater area.");
        }
        
        sc.close();
    }
}
