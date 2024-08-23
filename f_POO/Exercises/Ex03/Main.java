package Exercises.Ex03;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Name and 3 Grades");
        Student s1 = new Student(sc.next(),
                                 sc.nextDouble(),
                                 sc.nextDouble(),
                                 sc.nextDouble());

        System.out.println(s1);
        
        
        sc.close();
    }
}
