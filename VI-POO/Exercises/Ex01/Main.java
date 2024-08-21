package Exercises.Ex01;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Rectangle width and height");
        Rectangle r1 = new Rectangle(sc.nextDouble(), sc.nextDouble());
        
        System.out.println(r1);
        
        sc.close();
    }
}
