package A01.app;

import A01.entities.Triangle;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        System.out.println("Triangle X Data:");
        Scanner sc = new Scanner(System.in);
        Triangle x = new Triangle(sc.nextDouble(),
                                   sc.nextDouble(),
                                  sc.nextDouble());


        System.out.println("Triangle Y Data:");
        Triangle y = new Triangle(sc.nextDouble(),
                                  sc.nextDouble(),
                                  sc.nextDouble());

        System.out.printf("Area X: %.2f\nArea Y: %.2f\n", x.getArea(), y.getArea());
        if (x.getArea() > y.getArea()) {
            System.out.println("Triangle X has a greater area.");
        } else {
            System.out.println("Triangle Y has a greater area.");
        }
        
        
        sc.close();
    }
}

