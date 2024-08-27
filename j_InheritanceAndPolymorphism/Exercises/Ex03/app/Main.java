package j_InheritanceAndPolymorphism.Exercises.Ex03.app;

import java.util.Scanner;
import java.util.Locale;

import j_InheritanceAndPolymorphism.Exercises.Ex03.entities.*;
import j_InheritanceAndPolymorphism.Exercises.Ex03.entities.enums.Color;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);

        Circle circle = new Circle(Color.valueOf("BLUE"), 12.3);
        Rectangle rectangle = new Rectangle(Color.valueOf("RED"), 15.0, 20.0);

        System.out.println(circle.area());
        System.out.println(rectangle.area());
            
        
        
        sc.close();
    }
}

