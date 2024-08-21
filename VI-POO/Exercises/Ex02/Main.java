package Exercises.Ex02;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Employee Data: Name Gross Salary Tax in percentage");
        Employee e1 = new Employee(sc.next(), sc.nextDouble(), sc.nextDouble());

        System.out.println(e1);
        
        e1.increaseSalary(100);

        
        
        sc.close();
    }
}
